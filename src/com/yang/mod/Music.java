package com.yang.mod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Music {
	private List<Key> keyLst;   //按键序列
	private int keyNum=0;			//乐曲有多少个键
	private float duration=0;		//乐曲时长 单位秒
	private int i=-1;             //游标   指示当前所指的KEY的位置
	private int residue;          //剩余未比较的键数
	
	public Music() {
		// TODO Auto-generated constructor stub
		this.keyLst=new ArrayList<>();
	}
	
	public int getResidue() {
		return this.length()-i-1;
	}

	public Key getKey(int index) {
		return keyLst.get(index);
	}
	
	public int length() {
		return keyLst.size();
	}
	
	public Key next() {
		if (++i>=this.length()-1) {
			return keyLst.get(this.length()-1);
		}
		return keyLst.get(++i);
	}
	public Key pre() {
		return keyLst.get(--i);
	}
	
	public void add(Key key) {
		keyLst.add(key);
	}
	
	public int getKeyNum() {
		if (keyNum==0) {
			keyNum=keyLst.size();
		}
		return keyNum;
	}
	
	public float getDuration() {
		if (duration==0) {
			Date endDate =keyLst.get(keyLst.size()-1).getDate();
			Date startDate =keyLst.get(0).getDate();
			duration=(endDate.getTime()-startDate.getTime())/1000;
		}
		return duration;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
}
