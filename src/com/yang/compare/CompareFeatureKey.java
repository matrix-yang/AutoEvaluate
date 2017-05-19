package com.yang.compare;

import java.util.ArrayList;
import java.util.List;
import com.yang.mod.Key;
import com.yang.mod.Music;

public class CompareFeatureKey extends CompareStrong{
	int featureKeyNum =-1;   //³õÊ¼¼üºÅ
	
	
	public CompareFeatureKey(float factor, int featureKeyNum) {
		super(factor);
		this.featureKeyNum = featureKeyNum;
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
	public float divide(Music stand, Music input){
		float score=0f;
		List<Music> s_Musics=new ArrayList<>();
		List<Music> i_Musics=new ArrayList<>();
		Music s_music=new Music();
		for (int i = 0; i < stand.length(); i++) {
			if (stand.getKey(i).getNum()==featureKeyNum) {
				s_Musics.add(s_music);
				s_music=new Music();
			}
			s_music.add(stand.getKey(i));
		}
		for (int i = 0; i < s_music.length(); i++) {
			score=this.evaluate(stand, input);
		}
		return 1f;
	}
}
