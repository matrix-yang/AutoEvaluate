package com.yang.test;

import com.yang.evaluate.Calculate;
import com.yang.mod.Music;
import com.yang.mod.Result;
import com.yang.util.Convert;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert convert=new Convert();
		Music stand =convert.getMusicFromText("all.txt");
		Music input =convert.getMusicFromText("bll.txt");
		Calculate calculate=new Calculate();
		Result result=calculate.getResult(stand, input);
		Convert.out(result);
/*		String text="04-29 18:35:46.460: V/KeyCount(15675): 7次：音名：#F(bG)_5, 键号：58, 频率：739.989Hz,误差：未计算(精度：0.8）	 强度：20.708987024212735";
		
		System.out.println(convert.getStrFromText( ": ", 0, text));
		System.out.println(convert.getStrFromText( "V/KeyCount(15675): ", "次：",0 ,text));
		System.out.println(convert.getStrFromText( "音名：", ", 键号",0 ,text));
		System.out.println(convert.getStrFromText( "键号：", ", 频率",0 ,text));
		System.out.println(convert.getStrFromText( "频率：", ",误差",0 ,text));
		System.out.println(convert.getStrFromText( "强度：",text));*/
	}

}
