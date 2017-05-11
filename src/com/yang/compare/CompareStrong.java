package com.yang.compare;

import com.yang.mod.Music;
import com.yang.mod.Result;

public class CompareStrong extends BasicCompare {

	public CompareStrong(float factor) {
		// TODO Auto-generated constructor stub
		super.factor = factor;
	}

	@Override
	public Result evaluate(Music stand, Music input, Result result) {
		// TODO Auto-generated method stub
		
		int index; // ���ݼ�¼

		float score = 0; // ��¼����
		while (stand.getResidue() >= 0 && input.getResidue() >= 0) {
			
			boolean s_flag = true; // stand�Ƿ��˷
			boolean i_flag = true; // input�Ƿ��˷
			
			float rs[] = compareKey(stand.next(), input.next());
			if (rs[0] == 1) {
				//�÷�
				
			} else {
				//�ƽ�stand
				index = stand.getI();
				for (int i = 0; i < 5; i++) {
					float rs1[] = compareKey(stand.next(), input.getKey(index));
					if (rs1[0]==1) {
						s_flag=false;
						//�÷�
						
						break;
					}
				}
				//�ƽ�Input
				if (s_flag) {
					for (int i = 0; i < 5; i++) {
						float rs2[] = compareKey(stand.getKey(index), input.next());
						if (rs2[0]==1) {
							i_flag=false;
							//�÷�
							
							break;
						}
					}
					if (!i_flag) {
						input.setI(index+1);
					}
				}else {
					//stand�ƽ�ʧ�ܻ���ָ��
					stand.setI(index);
				}

			}
		}

		result.setScore(score / result.getStand() * 100 / 2);
		return result;
	}

}
