package com.yang.compare;

import com.yang.constant.DATA;
import com.yang.mod.Key;
import com.yang.mod.Music;
import com.yang.mod.Result;
import com.yang.util.Convert;

public class CompareStrong extends BasicCompare {

	public CompareStrong(float factor) {
		// TODO Auto-generated constructor stub
		super.factor = factor;
	}

	@Override
	public float[] compareKey(Key stand, Key input) {
		float rs[] = new float[3];
		System.out.println("stand的键号：" + stand.getNum() + "  比较  " + "input的键号："
				+ input.getNum());
		if (stand.getNum() == input.getNum()) {
			rs[0] = 1.0f; // key是否匹配
			rs[1] = 1; // 键位的得分
			// 声音强度的分
			System.out.println("stand的声音强度：" + stand.getStrong() * super.factor
					+ "  比较  " + "input的声音强度：：" + input.getStrong());
			float diff = Math.abs(stand.getStrong() * super.factor
					- input.getStrong());
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
		} else {
			rs[0] = 0;
			rs[1] = 0;
			// 声音强度的分
			rs[2] = 0f;
		}
		return rs;
	}

	@Override
	public float evaluate(Music stand, Music input) {
		// TODO Auto-generated method stub
		return super.evaluate(stand, input);
	}

	@Override
	public float divide(Music stand, Music input) {
		// TODO Auto-generated method stub
		return this.evaluate(stand, input);
	}
	/*
	 * @Override public float evaluate(Music stand, Music input) { // TODO
	 * Auto-generated method stub Convert.out(input, "input: ");
	 * Convert.out(stand, "stand: "); int index; // 回溯记录
	 * 
	 * float score = 0; // 记录分数
	 * 
	 * while (stand.getResidue() > 0 && input.getResidue() > 0) {
	 * 
	 * boolean s_flag = true; // stand是否回朔 boolean i_flag = true; // input是否回朔
	 * 
	 * float rs[] = compareKey(stand.next(), input.next()); if (rs[0] == 1) { //
	 * 得分 score = score + 1f; } else { // 推进stand index = stand.getI(); for (int
	 * i = 0; i < 5; i++) { float rs1[] = compareKey(stand.next(),
	 * input.getKey(index)); if (rs1[0] == 1) { s_flag = false; // 得分 score =
	 * score + 0.5f; input.next(); break; } } // 推进Input if (s_flag) { for (int
	 * i = 0; i < 5; i++) { float rs2[] = compareKey(stand.getKey(index),
	 * input.next()); if (rs2[0] == 1) { i_flag = false; // 得分 score = score +
	 * 0.5f; break; } } if (!i_flag) { input.setI(index + 1); } } else { //
	 * stand推进失败回溯指针 stand.setI(index); }
	 * 
	 * } }
	 * 
	 * System.out.println("stand.getResidue()----------------->" +
	 * stand.getResidue());
	 * System.out.println("input.getResidue()----------------->" +
	 * input.getResidue()); return score; }
	 */

}