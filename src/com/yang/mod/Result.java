package com.yang.mod;

import com.yang.compare.Compare;

public class Result {
	private float strong_ratio;  //����ǿ�ȱ�ֵ��������ǿ/��׼��ǿ  ��>1��ʾ������������
	private int stand;	    //��׼�������ܰ�������
	private int input;		//�����������ܰ�������
	private int diff;		// inpu - stand
	private float diff_ratio;  //  diff/stand �������ı�ֵ
	
	
	
	private float score;    //�ۺϻ�õķ���





	public float getStrong_ratio() {
		return strong_ratio;
	}



	public void setStrong_ratio(float strong_ratio) {
		this.strong_ratio = strong_ratio;
	}



	public int getStand() {
		return stand;
	}



	public void setStand(int stand) {
		this.stand = stand;
	}



	public int getInput() {
		return input;
	}



	public void setInput(int input) {
		this.input = input;
	}



	public int getDiff() {
		return diff;
	}



	public void setDiff(int diff) {
		this.diff = diff;
	}



	public float getDiff_ratio() {
		return diff_ratio;
	}



	public void setDiff_ratio(float diff_ratio) {
		this.diff_ratio = diff_ratio;
	}



	public float getScore() {
		return score;
	}



	public void setScore(float score) {
		this.score = score;
	}
	
	
}
