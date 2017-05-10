package com.yang.mod;

import java.util.Date;

public class Key {
	private int seq;
	private int num;
	private String name;
	private float strong;
	private float HZ;
	private Date date;
	public Key() {
	}
	public Key(int seq, int num, String name, float strong, float hZ, Date date, int times,
			float error) {
		super();
		this.seq = seq;
		this.num = num;
		this.name = name;
		this.strong = strong;
		HZ = hZ;
		this.date = date;
		this.times = times;
		this.error = error;
	}
	private int times;
	private float duration;
	private float error;
	
	public float getError() {
		return error;
	}
	public void setError(float error) {
		this.error = error;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getStrong() {
		return strong;
	}
	public void setStrong(float strong) {
		this.strong = strong;
	}
	public float getHZ() {
		return HZ;
	}
	public void setHZ(float hZ) {
		HZ = hZ;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public float getDuration() {
		return this.times*40;
	}
	
}
