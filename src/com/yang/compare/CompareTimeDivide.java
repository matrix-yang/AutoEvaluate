package com.yang.compare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yang.constant.DATA;
import com.yang.mod.Key;
import com.yang.mod.Music;

public class CompareTimeDivide extends CompareGap {
	private int segments=DATA.DEFAULT_SEG; //划分的段数

	public CompareTimeDivide(float factor, int segments) {
		super(factor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float[] compareKey(Key stand, Key input) {
		// TODO Auto-generated method stub
		return super.compareKey(stand, input);
	}

	@Override
	public float evaluate(Music stand, Music input) {
		// TODO Auto-generated method stub
		return super.evaluate(stand, input);
	}

	@Override
	public float divide(Music stand, Music input) {
		// TODO Auto-generated method stub
		Date st_start = stand.getKey(0).getDate();
		Date st_end = stand.getKey(stand.length() - 1).getDate();
		long st_time = (st_end.getTime() - st_start.getTime()) / 1000;
		float st_segment = st_time / segments;

		Date in_start = input.getKey(0).getDate();
		Date in_end = input.getKey(input.length() - 1).getDate();
		long in_time = (in_end.getTime() - in_start.getTime()) / 1000;
		float in_segment = in_time / segments;

		float score = 0f;
		List<Music> s_Musics = new ArrayList<>();
		List<Music> i_Musics = new ArrayList<>();
		Music s_music = new Music();
		float s_temp = st_start.getTime();
		for (int i = 0; i < stand.length(); i++) {
			if (stand.getKey(i).getDate().getTime() - s_temp >= st_segment) {
				s_temp = stand.getKey(i).getDate().getTime();
				s_Musics.add(s_music);
				s_music = new Music();
			}
			s_music.add(stand.getKey(i));
		}

		Music i_music = new Music();
		float i_temp = in_start.getTime();
		for (int i = 0; i < input.length(); i++) {
			if (input.getKey(i).getDate().getTime() - i_temp >= in_segment) {
				i_temp = input.getKey(i).getDate().getTime();
				i_Musics.add(i_music);
				i_music = new Music();
			}
			i_music.add(input.getKey(i));
		}

		for (int i = 0; i < s_Musics.size(); i++) {
			Music st_temp = s_Musics.get(i);
			Music in_temp = i_Musics.get(i);
			score += this.evaluate(stand, input);
		}
		return score;
	}

}
