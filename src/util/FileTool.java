package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileTool {
	
	
	private ArrayList<String> list;
	private StringBuilder result;
	private BufferedReader br;
	
	public ArrayList<String> txtToString(File file){
			result = new StringBuilder();
		    list=new ArrayList<String>();
        try{
        	
            br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = new String();
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
                list.add(s);//需要将String类型的对象加进动态数组
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
         
		return list;
       
    }

}
