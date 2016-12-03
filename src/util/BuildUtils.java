package util;

import bean.Node;

public class BuildUtils {
	
	//�ж�Ϊ���͵��������

	public static void parsertoInt(String s){
		
		  Node detail=new Node("5",s,Integer.parseInt(s),"int");//�б�Ϊ�޷�������
		  Analyze.getAnalyze().addNode(detail);
		  System.out.println(detail.toString());
	}
	
	
	public static void parsertoDouble(String s){
	
		  Node detail=new Node("8",s,Double.parseDouble(s),"double");//�б�Ϊ�޷��Ÿ�����
		  Analyze.getAnalyze().addNode(detail);
		  System.out.println(detail.toString());
	}
	
	public static void parsertoIntOrDouble(String s){
		if(s.contains(".")) parsertoDouble(s);
		else
			parsertoInt(s);
	}
	
	
	public static void getEndSingle(String input,int beginIndex, int endIndex){
			
			parsertoIntOrDouble(input.substring(beginIndex,endIndex));
	}
	
	
	
	
	public static void parsertoSingle(char ch){
		switch(ch){
		case '+':
			Node detail1=new Node("1",String.valueOf(ch),"NULL","NULL");//�б�Ϊ+��
			 Analyze.getAnalyze().addNode(detail1);
		    System.out.println(detail1.toString());break;
		    
		case '-':
			Node detail2=new Node("2",String.valueOf(ch),"NULL","NULL");//�б�Ϊ-��
			 Analyze.getAnalyze().addNode(detail2);
		    System.out.println(detail2.toString());break;
		   
		case '*':
			Node detail3=new Node("3",String.valueOf(ch),"NULL","NULL");//�б�Ϊ*��
			 Analyze.getAnalyze().addNode(detail3);
		    System.out.println(detail3.toString());break;
		    
		case '/':
			Node detail4=new Node("4",String.valueOf(ch),"NULL","NULL");//�б�Ϊ/��
			 Analyze.getAnalyze().addNode(detail4);
		    System.out.println(detail4.toString());break;
		    
	    case '(':
			Node detail5=new Node("6",String.valueOf(ch),"NULL","NULL");//�б�Ϊ(��
			 Analyze.getAnalyze().addNode(detail5);
		    System.out.println(detail5.toString());break;
	    
		    
	    case ')':
			Node detail6=new Node("7",String.valueOf(ch),"NULL","NULL");//�б�Ϊ}��
			 Analyze.getAnalyze().addNode(detail6);
		    System.out.println(detail6.toString());break;
		
		    default:
		    	break;
		}
	
		  
	}
	
	
	
	public static boolean throwFirstSigleError(char ch){
		
		
		switch(ch){ 
		
		
		case '.': System.out.println("ERROR:�ַ� . �����ڱ��ʽ��ͷ");Analyze.lastAnayScuccess=false;return true;
		
		case '+': System.out.println("ERROR:�ַ� +�����ڱ��ʽ��ͷ");Analyze.lastAnayScuccess=false;return true;
			 
		case '-':System.out.println("ERROR:�ַ� +�����ڱ��ʽ��ͷ");Analyze.lastAnayScuccess=false;return true;
		 
		case '*':System.out.println("ERROR:�ַ� *�����ڱ��ʽ��ͷ");Analyze.lastAnayScuccess=false;return true;
		 
		case '/': System.out.println("ERROR:�ַ� /�����ڱ��ʽ��ͷ");Analyze.lastAnayScuccess=false;return true;
		  
		case ')':  System.out.println("ERROR:�ַ� )�����ڱ��ʽ��ͷ");Analyze.lastAnayScuccess=false;return true;
		
		default:break;
		 
	}
		return false;
		
	}
	
	
}
