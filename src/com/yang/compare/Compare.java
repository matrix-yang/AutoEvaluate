package com.yang.compare;

import com.yang.mod.Key;
import com.yang.mod.Music;
import com.yang.mod.Result;

public interface Compare {
	 //����ĳ�����ĵ÷��������ָ�꣨,��λ��ǿ�ȣ�ʱ�䣩
	public float[] compareKey(Key stand,Key input);   
	//��������ĵ÷ֽ��
	public Result evaluate(Music stand,Music input,Result result);
}
