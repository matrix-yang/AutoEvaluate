package com.yang.test;

import com.yang.mod.Music;
import com.yang.util.Convert;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convert convert=new Convert();
		Music music =convert.getMusicFromText("KeyCount_1.txt");
		System.out.println(music.getDuration());
		System.out.println(music.getKeyNum());
/*		String text="04-29 18:35:46.460: V/KeyCount(15675): 7�Σ�������#F(bG)_5, ���ţ�58, Ƶ�ʣ�739.989Hz,��δ����(���ȣ�0.8��	 ǿ�ȣ�20.708987024212735";
		
		System.out.println(convert.getStrFromText( ": ", 0, text));
		System.out.println(convert.getStrFromText( "V/KeyCount(15675): ", "�Σ�",0 ,text));
		System.out.println(convert.getStrFromText( "������", ", ����",0 ,text));
		System.out.println(convert.getStrFromText( "���ţ�", ", Ƶ��",0 ,text));
		System.out.println(convert.getStrFromText( "Ƶ�ʣ�", ",���",0 ,text));
		System.out.println(convert.getStrFromText( "ǿ�ȣ�",text));*/
	}

}