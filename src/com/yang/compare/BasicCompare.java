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

	protected float factor = 1; // ����ʱ��ǿ�Ĳ��
	protected float hz_diff = 0; // ����ʱ��������

	// private int distance;
	@Override
	public float[] compareKey(Key stand, Key input) {
		// TODO Auto-generated method stub
		float rs[] = new float[3];
		System.out.println("stand�ļ��ţ�" + stand.getNum() + "  �Ƚ�  " + "input�ļ��ţ�"
				+ input.getNum());
		if (stand.getNum() == input.getNum()) {
			rs[0] = 1.0f; // key�Ƿ�ƥ��
			rs[1] = 1; // ��λ�ĵ÷�
			rs[2] = 1; // ����ǿ�ȵķ�
		} else {
			rs[0] = 0;
			rs[1] = 0;
			rs[2] = 1;
		}
		return rs;
	}

	@Override
	public float evaluate(Music stand, Music input) {

		Convert.out(input, "input�ļ�������: ");
		Convert.out(stand, "stand�ļ�������: ");

		boolean flag = true; // �Ƿ��˷
		int index; // ���ݼ�¼

		float score = 0; // ��¼����
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
		System.out.println("standĩβʣ�������----------------->"
				+ stand.getResidue());
		System.out.println("inputĩβʣ�������----------------->"
				+ input.getResidue());
		
		return score;
	}

	@Override
	public float divide(Music stand, Music input) {
		// TODO Auto-generated method stub
		return this.evaluate(stand, input);
	}

	
	
	
}
