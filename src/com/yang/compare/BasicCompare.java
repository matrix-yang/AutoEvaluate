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
	protected float factor=1;	//����ʱ��ǿ�Ĳ��
	protected float hz_diff=0;  //����ʱ��������
	//private int distance;
	@Override
	public float[] compareKey(Key stand, Key input) {
		// TODO Auto-generated method stub
		float rs[]=new float[3];
		if (stand.getNum()==input.getNum()) {
			rs[0]=1.0f;    //key�Ƿ�ƥ��
			rs[1]=1;	//��λ�ĵ÷�
			rs[2]=1;	//����ǿ�ȵķ�
		}else {
			rs[0]=0;
			rs[1]=0;
			rs[2]=1;
		}
		return rs;
	}
	@Override
	public Result evaluate(Music stand, Music input,Result result) {
		
		boolean flag=true; //�Ƿ��˷
		int index; //���ݼ�¼
		
		float score=0;  //��¼����
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
