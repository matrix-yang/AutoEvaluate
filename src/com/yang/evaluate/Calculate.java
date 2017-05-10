package com.yang.evaluate;

import com.yang.compare.BasicCompare;
import com.yang.compare.Compare;
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
		if (Math.abs(diff)<0.5) {
			this.compare=new BasicCompare();
		}
						
	}
	
	public Result getResult(Music stand,Music input) {
		selectCompare(stand, input);
		
		return null;		
	}
}
