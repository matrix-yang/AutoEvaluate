package com.yang.mod;

public class Result {

	private int stand;	    //��׼�������ܰ�������
	private int input;		//�����������ܰ�������
	private int diff;		// inpu - stand
	private float diff_ratio;  //  diff/stand �������ı�ֵ
	private long standTime;   //��׼����ʱ��   ��λ��
	private long inputTime;	//��׼���ʱ��
	private long timeDiff;    //ʱ���ֵinpuTime - standTime
	private float time_ratio; //ʱ����ֵ timediff/standtime
	private float standStrong; //��׼��λƽ��ǿ��
	private float inputStrong; //�����λƽ��ǿ��
	private float strongDiff;  //����ǿ�Ȳ�ֵ��������ǿ-��׼��ǿ  ��>0��ʾ������������
	
	
	private float score;    //�ۺϻ�õķ���


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
		diff_ratio=diff/stand;
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



	public float getTime_ratio() {
		return time_ratio;
	}


	public void setTime_ratio(float time_ratio) {
		this.time_ratio = time_ratio;
	}


	public float getStrongDiff() {
		return strongDiff;
	}


	public void setStrongDiff(float strongDiff) {
		this.strongDiff = strongDiff;
	}


	public float getScore() {
		return score;
	}


	public void setScore(float score) {
		this.score = score;
	}

	
}
