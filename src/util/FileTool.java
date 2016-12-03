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
        	
            br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
            String s = new String();
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
                result.append(System.lineSeparator()+s);
                list.add(s);//��Ҫ��String���͵Ķ���ӽ���̬����
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
         
		return list;
       
    }

}
