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
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public Music getMusicFromText(String fileName) {
    	Music music=new Music();
    	Key key = null;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            //解析数据文件
            while ((text = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + text);
            	 int seq=line;
            	 int num = Integer.parseInt(getStrFromText( "键号：", ", 频率",0 ,text));
            	 String name=getStrFromText( "音名：", ", 键号",0 ,text);
            	 float strong=Float.parseFloat(getStrFromText( "强度：",text));
            	 float hZ=Float.parseFloat(getStrFromText( "频率：", "Hz,误差",0 ,text));
            	 Format f = new SimpleDateFormat("MM-dd HH:mm:ss");
            	 Date date = null;
            	 try {
					date=(Date) f.parseObject(getStrFromText( ": ", 0, text));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 int times=Integer.parseInt(getStrFromText( "V/KeyCount(15675): ", "次：",0 ,text));;
            	 //float error=Float.parseFloat(tempString.substring(2, 5));
            	 float error=(float) 0.2;
            	 
            	 //保存KEY的值
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
