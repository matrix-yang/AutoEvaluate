package com.yang.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yang.mod.Key;
import com.yang.mod.Music;


public class Convert {
	
	
	/**
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
     */
    public Music getMusicFromText(String fileName) {
    	Music music=new Music();
    	Key key = null;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            //���������ļ�
            while ((text = reader.readLine()) != null) {
                // ��ʾ�к�
                System.out.println("line " + line + ": " + text);
            	 int seq=line;
            	 int num = Integer.parseInt(getStrFromText( "���ţ�", ", Ƶ��",0 ,text));
            	 String name=getStrFromText( "������", ", ����",0 ,text);
            	 float strong=Float.parseFloat(getStrFromText( "ǿ�ȣ�",text));
            	 float hZ=Float.parseFloat(getStrFromText( "Ƶ�ʣ�", "Hz,���",0 ,text));
            	 Format f = new SimpleDateFormat("MM-dd HH:mm:ss");
            	 Date date = null;
            	 try {
					date=(Date) f.parseObject(getStrFromText( ": ", 0, text));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 int times=Integer.parseInt(getStrFromText( "V/KeyCount(15675): ", "�Σ�",0 ,text));;
            	 //float error=Float.parseFloat(tempString.substring(2, 5));
            	 float error=(float) 0.2;
            	 
            	 //����KEY��ֵ
            	 key=new Key(seq, num, name, strong, hZ, date, times, error);
            	 music.add(key);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return music;
    }
    
    
    
    public String getStrFromText(String start,String end,int eOffset,String text){
    	String str=null;
    	str=text.substring(text.indexOf(start)+start.length(),text.indexOf(end)+eOffset);
    	return str;
    }
    public String getStrFromText(String end,int eOffset,String text){
    	String str=null;
    	str=text.substring(0,text.indexOf(end)+eOffset);
    	return str;
    }
    public String getStrFromText(String start,String text){
    	String str=null;
    	str=text.substring(text.indexOf(start)+start.length());
    	return str;
    }
}
