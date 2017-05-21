package com.yang.compare;

import com.yang.constant.DATA;
import com.yang.mod.Key;
import com.yang.mod.Music;
import com.yang.mod.Result;
import com.yang.util.Convert;

public class BasicCompare implements Compare {

	public BasicCompare(float factor, float hz_diff) {
		this.factor = factor;
		this.hz_diff = hz_diff;
	}

	public BasicCompare() {
	}

	protected float factor = 1; // 演奏时音强的差别
	protected float hz_diff = 0; // 演奏时集体音差

	// private int distance;
	@Override
	public float[] compareKey(Key stand, Key input) {
		// TODO Auto-generated method stub
		float rs[] = new float[3];
		System.out.println("stand的键号：" + stand.getNum() + "  比较  " + "input的键号："
				+ input.getNum());
		if (stand.getNum() == input.getNum()) {
			rs[0] = 1.0f; // key是否匹配
			rs[1] = 1; // 键位的得分
			rs[2] = 1; // 声音强度的分
		} else {
			rs[0] = 0;
			rs[1] = 0;
			rs[2] = 1;
		}
		return rs;
	}

	@Override
	public float evaluate(Music stand, Music input) {

		Convert.out(input, "input的键号序列: ");
		Convert.out(stand, "stand的键号序列: ");

		boolean flag = true; // 是否回朔
		int index; // 回溯记录

		float score = 0; // 记录分数
		while (stand.getResidue() > 0 && input.getResidue() > 0) {			
			float num[] = compareKey(stand.next(), input.next());
			
			int s_index=stand.getI();
			int i_index=input.getI();
			if (num[0] == 1.0f) {
				score = score + num[1] + num[2];
			} else {
				flag = true;
				for (int j = 0; j < DATA.OFFSET_LENGTH; j++) {
					float num1[] = compareKey(stand.getKey(s_index), input.next());
					if (num1[0] == 1.0f) {
						score = score + num1[1] + num1[2];
						flag = false;
						break;
					}
				}
				if (flag) {
					input.setI(i_index-1);
				}
			}
		}
		System.out.println("stand末尾剩余键数：----------------->"
				+ stand.getResidue());
		System.out.println("input末尾剩余键数：----------------->"
				+ input.getResidue());
		
		return score;
	}

	@Override
	public float divide(Music stand, Music input) {
		// TODO Auto-generated method stub
		return this.evaluate(stand, input);
	}

	
	
	
}
