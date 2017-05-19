package com.yang.evaluate;

import java.util.Date;

import com.yang.compare.BasicCompare;
import com.yang.compare.Compare;
import com.yang.compare.CompareStrong;
import com.yang.mod.Music;
import com.yang.mod.Result;

public class Calculate {
	private Compare compare;
	private Result result =new Result();
	
	/*根据MUSIC选着合适的评价类*/
	public void selectCompare(Music stand,Music input){
		int st=stand.getKeyNum();
		int in=input.getKeyNum();
		int diff=in-st;
		int diff_ratio=diff/st;
		
		//计算声音强度差
		float st_strong=0;
		for (int i = 0; i < stand.length(); i++) {
			st_strong=st_strong+stand.getKey(i).getStrong();
		}
		st_strong=st_strong/st;
		
		float in_strong=0;
		for (int i = 0; i < input.length(); i++) {
			in_strong=in_strong+input.getKey(i).getStrong();
		}
		in_strong=in_strong/in;
		
		float strong_ratio=in_strong/st_strong;
		
		
		//计算两个MUSIC的时间差
		Date st_start=stand.getKey(0).getDate();
		Date st_end=stand.getKey(stand.length()-1).getDate();
		long st_time=(st_end.getTime()-st_start.getTime())/1000;
		
		Date in_start=input.getKey(0).getDate();
		Date in_end=input.getKey(input.length()-1).getDate();
		long in_time=(in_end.getTime()-in_start.getTime())/1000;
		
		long time_diff= in_time-st_time;
		
		
		//保存初步比较的结果
		result.setDiff(diff);
		result.setDiff_ratio(diff_ratio);
		result.setInput(in);
		result.setStand(st);
		result.setInputStrong(in_strong);
		result.setStandStrong(st_strong);
		//result.setStrong_ratio(strong_ratio);
		result.setStrongDiff(in_strong-st_strong);
		result.setStandTime(st_time);
		result.setInputTime(in_time);
		result.setTimeDiff(time_diff);
				
		//根据初步比较结果选择计算分数的方案
		/*if (Math.abs(diff)<0.5) {
			this.compare=new BasicCompare();
		}else {
			this.compare=new CompareStrong(strong_ratio);
			//this.compare=new BasicCompare();
		}*/
		this.compare=new CompareStrong(strong_ratio);				
	}
	
	public Result getResult(Music stand,Music input) {
		selectCompare(stand, input);
		float score1=compare.divide(stand, input);
		System.out.println("score1----------------------->"+score1);
		
		//回朔指针
		input.setI(-1);
		stand.setI(-1);
		float score2=compare.evaluate(input, stand);
		System.out.println("score2----------------------->"+score2);
		result.setScore(Math.max(score1, score2)/stand.getKeyNum()*100/2);
		System.out.println(Math.max(score1, score2)/stand.getKeyNum()*100/2);
		return this.result;		
	}
}
