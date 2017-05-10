package com.yang.compare;

import com.yang.mod.Key;
import com.yang.mod.Music;
import com.yang.mod.Result;

public class BasicCompare implements Compare{
	
	public BasicCompare(float factor,float hz_diff){
		this.factor=factor;
		this.hz_diff=hz_diff;
	}
	public BasicCompare(){
	}
	protected float factor=1;	//演奏时音强的差别
	protected float hz_diff=0;  //演奏时集体音差
	//private int distance;
	@Override
	public float[] compareKey(Key stand, Key input) {
		// TODO Auto-generated method stub
		float rs[]=new float[3];
		if (stand.getNum()==input.getNum()) {
			rs[0]=1.0f;    //key是否匹配
			rs[1]=1;	//键位的得分
			rs[2]=1;	//声音强度的分
		}else {
			rs[0]=0;
			rs[1]=0;
			rs[2]=1;
		}
		return rs;
	}
	@Override
	public Result evaluate(Music stand, Music input,Result result) {
		
		boolean flag=true; //是否回朔
		int index; //回溯记录
		
		float score=0;  //记录分数
		if (stand.getKeyNum()<=input.getKeyNum()) {
			for (int i = 0; i < stand.getKeyNum(); i++) {
				float num[]=compareKey(stand.next(), input.next());
				if (num[0]==1.0f) {
					score=score+num[1]+num[2];
				}else {
					flag=true;
					index=i;
					for (int j = 0; j < 5; j++) {
						float num1[]=compareKey(stand.getKey(i), input.next());
						if (num1[0]==1.0f) {
							score=score+num1[1]+num1[2];
							flag=false;
							break;
						}
					}
					if (flag) {
						input.setI(index);
					}
				}				
			}			
		}else {
			
		}
		
		result.setScore(score/result.getStand()*100/2);
		return result;
	}


	
}
