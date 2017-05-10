package com.yang.mod;

public class Result {

	private int stand;	    //标准乐曲的总按键个数
	private int input;		//输入乐曲的总按键个数
	private int diff;		// inpu - stand
	private float diff_ratio;  //  diff/stand 相差键数的比值
	private long standTime;   //标准输入时间   单位秒
	private long inputTime;	//标准输出时间
	private long timeDiff;    //时间差值inpuTime - standTime
	private float standStrong; //标准键位平均强度
	private float inputStrong; //输入键位平均强度
	private float strong_ratio;  //声音强度比值，弹奏音强/标准音强  ，>1表示弹奏着音量大
	
	
	private float score;    //综合获得的分数


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


	public long getStandTime() {
		return standTime;
	}


	public void setStandTime(long standTime) {
		this.standTime = standTime;
	}


	public long getInputTime() {
		return inputTime;
	}


	public void setInputTime(long inputTime) {
		this.inputTime = inputTime;
	}


	public long getTimeDiff() {
		return timeDiff;
	}


	public void setTimeDiff(long timeDiff) {
		this.timeDiff = timeDiff;
	}


	public float getStandStrong() {
		return standStrong;
	}


	public void setStandStrong(float standStrong) {
		this.standStrong = standStrong;
	}


	public float getInputStrong() {
		return inputStrong;
	}


	public void setInputStrong(float inputStrong) {
		this.inputStrong = inputStrong;
	}


	public float getStrong_ratio() {
		return strong_ratio;
	}


	public void setStrong_ratio(float strong_ratio) {
		this.strong_ratio = strong_ratio;
	}


	public float getScore() {
		return score;
	}


	public void setScore(float score) {
		this.score = score;
	}

	
}
