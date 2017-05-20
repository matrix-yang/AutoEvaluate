package com.yang.compare;

import com.yang.constant.DATA;
import com.yang.mod.Key;
import com.yang.mod.Music;

public class CompareGap extends CompareStrong {

	public CompareGap(float factor) {
		super(factor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float[] compareKey(Key stand, Key input) {
		// TODO Auto-generated method stub
		float rs[] = new float[3];
		System.out.println("stand" + stand.getNum() + "比较" + "input"
				+ input.getNum());
		if ( Math.abs(stand.getNum() - input.getNum()) <= DATA.DIFF_GAP_LEVEL1) {
			rs[0] = 1.0f; // key是否匹配
			rs[1] = DATA.DIFF_GAP_SCORE1; // 键位的得分
			// 声音强度的分
			float diff = Math.abs(stand.getStrong() * super.factor - input.getStrong());
			if (diff <= DATA.DIFF_STRONG_LEVEL1) {
				rs[2] = DATA.DIFF_STRONG_SCORE1;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL2) {
				rs[2] = DATA.DIFF_STRONG_SCORE2;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL3) {
				rs[2] = DATA.DIFF_STRONG_SCORE3;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL4) {
				rs[2] = DATA.DIFF_STRONG_SCORE4;
			} else {
				rs[2] = 0f;
			}
		} else if ( Math.abs(stand.getNum() - input.getNum()) <= DATA.DIFF_GAP_LEVEL2) {
			rs[0] = 1.0f; // key是否匹配
			rs[1] = DATA.DIFF_GAP_SCORE2; // 键位的得分
			// 声音强度的分
			float diff =  Math.abs(stand.getStrong() * super.factor - input.getStrong());
			if (diff <= DATA.DIFF_STRONG_LEVEL1) {
				rs[2] = DATA.DIFF_STRONG_SCORE1;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL2) {
				rs[2] = DATA.DIFF_STRONG_SCORE2;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL3) {
				rs[2] = DATA.DIFF_STRONG_SCORE3;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL4) {
				rs[2] = DATA.DIFF_STRONG_SCORE4;
			} else {
				rs[2] = 0f;
			}
		} else if ( Math.abs(stand.getNum() - input.getNum()) <= DATA.DIFF_GAP_LEVEL3) {
			rs[0] = 1.0f; // key是否匹配
			rs[1] = DATA.DIFF_GAP_SCORE3; // 键位的得分
			// 声音强度的分
			float diff =  Math.abs(stand.getStrong() * super.factor - input.getStrong());
			if (diff <= DATA.DIFF_STRONG_LEVEL1) {
				rs[2] = DATA.DIFF_STRONG_SCORE1;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL2) {
				rs[2] = DATA.DIFF_STRONG_SCORE2;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL3) {
				rs[2] = DATA.DIFF_STRONG_SCORE3;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL4) {
				rs[2] = DATA.DIFF_STRONG_SCORE4;
			} else {
				rs[2] = 0f;
			}
		}else {
			rs[0] = 0;
			rs[1] = 0;
			// 声音强度的分
			float diff =  Math.abs(stand.getStrong() * super.factor - input.getStrong());
			if (diff <= DATA.DIFF_STRONG_LEVEL1) {
				rs[2] = DATA.DIFF_STRONG_SCORE1;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL2) {
				rs[2] = DATA.DIFF_STRONG_SCORE2;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL3) {
				rs[2] = DATA.DIFF_STRONG_SCORE3;
			} else if (diff <= DATA.DIFF_STRONG_LEVEL4) {
				rs[2] = DATA.DIFF_STRONG_SCORE4;
			} else {
				rs[2] = 0f;
			}
		}
		return rs;
	}

	@Override
	public float evaluate(Music stand, Music input) {
		// TODO Auto-generated method stub
		return super.evaluate(stand, input);
	}

}
