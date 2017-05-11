package com.yang.compare;

import com.yang.mod.Key;
import com.yang.mod.Music;
import com.yang.mod.Result;

public interface Compare {
	 //返回某个键的得分情况各个指标（,键位，强度，时间）
	public float[] compareKey(Key stand,Key input);   
	//返回整体的得分结果
	public Result evaluate(Music stand,Music input,Result result);
}
