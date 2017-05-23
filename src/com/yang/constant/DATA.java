package com.yang.constant;

public class DATA {
	//比较失败后的尝试偏移的长度
	public static final int OFFSET_LENGTH =2;
		
	//声音差别的等级 即所得分数
	public static final int DIFF_STRONG_LEVEL1=1;
	public static final float DIFF_STRONG_SCORE1=1;
	
	public static final int DIFF_STRONG_LEVEL2=4;
	public static final float DIFF_STRONG_SCORE2=0.6f;
	
	public static final int DIFF_STRONG_LEVEL3=8;
	public static final float DIFF_STRONG_SCORE3=0.3f;
	
	public static final int DIFF_STRONG_LEVEL4=16;
	public static final float DIFF_STRONG_SCORE4=0.1f;
	
	//键位差别的等级
	public static final int DIFF_GAP_LEVEL1=0;
	public static final float DIFF_GAP_SCORE1=1;
	
	public static final int DIFF_GAP_LEVEL2=1;
	public static final float DIFF_GAP_SCORE2=0.5f;
	
	public static final int DIFF_GAP_LEVEL3=2;
	public static final float DIFF_GAP_SCORE3=0.1f;
	
	//段数的默认值
	public static final int DEFAULT_SEG=10;
}
