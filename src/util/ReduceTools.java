package util;

import java.util.ArrayList;

import bean.Node;

public class ReduceTools {
	
	public static Node reduceByAdd(ArrayList<Node> reduceNodeList,P p){//E->E+T
		if(!reduceNodeList.get(0).getValue().toString().contains(".")&&
				 !reduceNodeList.get(2).getValue().toString().contains(".")){
   			int value=Integer.parseInt(reduceNodeList.get(0).getValue().toString())+Integer.parseInt(reduceNodeList.get(2).getValue().toString()); 
   			return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������

			 }else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
					 reduceNodeList.get(2).getValue().toString().contains(".")){
   			 double value=Double.parseDouble(reduceNodeList.get(0).getValue().toString())+Double.parseDouble(reduceNodeList.get(2).getValue().toString()); 
   			return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������

			 }else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
				 !reduceNodeList.get(2).getValue().toString().contains(".")){
				 double value=Double.parseDouble(reduceNodeList.get(0).getValue().toString())+Double.parseDouble(reduceNodeList.get(2).getValue().toString());
				 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������	 
			 }else{
				 double value=Double.parseDouble(reduceNodeList.get(0).getValue().toString())+Double.parseDouble(reduceNodeList.get(2).getValue().toString());
				 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(2).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������	 
			 }
	
	}
	
	
	public static Node reduceByJian(ArrayList<Node> reduceNodeList,P p){//E->E-T
		if(!reduceNodeList.get(0).getValue().toString().contains(".")&&
				 !reduceNodeList.get(2).getValue().toString().contains(".")){
   			 int value=Integer.parseInt(reduceNodeList.get(2).getValue().toString())-Integer.parseInt(reduceNodeList.get(0).getValue().toString()); 
   			return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������

			 }else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
					 reduceNodeList.get(2).getValue().toString().contains(".")){
   			 double value=Double.parseDouble(reduceNodeList.get(2).getValue().toString())-Double.parseDouble(reduceNodeList.get(0).getValue().toString()); 
   			return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������

			 }else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
				 !reduceNodeList.get(2).getValue().toString().contains(".")){
				 double value=Double.parseDouble(reduceNodeList.get(2).getValue().toString())-Double.parseDouble(reduceNodeList.get(0).getValue().toString());
				 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
			 }else{
				 double value=Double.parseDouble(reduceNodeList.get(2).getValue().toString())-Double.parseDouble(reduceNodeList.get(0).getValue().toString());
				 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(2).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
			 }
	}
	
	
	
	
	public static Node reduceByCheng(ArrayList<Node> reduceNodeList,P p){//T->T*F
		 if(!reduceNodeList.get(0).getValue().toString().contains(".")&&
				 !reduceNodeList.get(2).getValue().toString().contains(".")){
    			 int value=Integer.parseInt(reduceNodeList.get(0).getValue().toString())*Integer.parseInt(reduceNodeList.get(2).getValue().toString()); 
    			 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������

			 }else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
					 reduceNodeList.get(2).getValue().toString().contains(".")){
    			 double value=Double.parseDouble(reduceNodeList.get(0).getValue().toString())*Double.parseDouble(reduceNodeList.get(2).getValue().toString()); 
    			 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������

			 }else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
					 !reduceNodeList.get(2).getValue().toString().contains(".")){
				 double value=Integer.parseInt(reduceNodeList.get(0).getValue().toString())*Double.parseDouble(reduceNodeList.get(2).getValue().toString()); 
    			 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(2).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
			 }else{
				 double value=Double.parseDouble(reduceNodeList.get(0).getValue().toString())*Integer.parseInt(reduceNodeList.get(2).getValue().toString()); 
    			 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
			 }
	}
		 
	
	public static Node reduceByChu(ArrayList<Node> reduceNodeList,P p){//T-> T/F
		if(!reduceNodeList.get(0).getValue().toString().contains(".")&&
				 !reduceNodeList.get(2).getValue().toString().contains(".")){
   			 int value=Integer.parseInt(reduceNodeList.get(2).getValue().toString())/Integer.parseInt(reduceNodeList.get(0).getValue().toString()); 
   			 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������

		 	}else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
		 			reduceNodeList.get(2).getValue().toString().contains(".")){
		 		double value=Double.parseDouble(reduceNodeList.get(2).getValue().toString())/Double.parseDouble(reduceNodeList.get(0).getValue().toString()); 
			//��Լ��ĵ��ʽ���м��������洢���	 
		 		 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
   		
		 	}else if(reduceNodeList.get(0).getValue().toString().contains(".")&&
					 !reduceNodeList.get(2).getValue().toString().contains(".")){
				 double value=Integer.parseInt(reduceNodeList.get(0).getValue().toString())/Double.parseDouble(reduceNodeList.get(2).getValue().toString()); 
				 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(2).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
			 }else{
		 		double value=Double.parseDouble(reduceNodeList.get(0).getValue().toString())/Integer.parseInt(reduceNodeList.get(2).getValue().toString()); 
   			 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
			 }
	}
	 
		 
		 
		
	public static Node reduceFromi(ArrayList<Node> reduceNodeList,P p){//F->i
		 
		
		 if(reduceNodeList.get(0).getValue().toString().contains(".")){
			   double value=Double.parseDouble(reduceNodeList.get(0).getValue().toString());
			   return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());
		 }
		 else{
			 int value=Integer.parseInt(reduceNodeList.get(0).getValue().toString());
		 //reduceNode=new Node(reduceNodeList.get(0).getNumType(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
			 return new Node(p.getLeftV().getSingle(),String.valueOf(value),value,reduceNodeList.get(0).getBeanTpye());//ָ�����ʵ��ֱ��롢ԭ�͡�ֵ������
		 }
	 }
	
	
	public static Node reduceByKuoHao(ArrayList<Node> reduceNodeList,P p){ //F->(E) 
		
		return new Node(p.getLeftV().getSingle(),reduceNodeList.get(1).getKey(),reduceNodeList.get(1).getValue().toString(),reduceNodeList.get(1).getBeanTpye());
		
	}
	
	
	public static Node reduceFromOther(ArrayList<Node> reduceNodeList,P p){//T->F//E->T//S->E
	 
		return new Node(p.getLeftV().getSingle(),reduceNodeList.get(0).getKey(),reduceNodeList.get(0).getValue().toString(),reduceNodeList.get(0).getBeanTpye());
	
	
}
	
	
	public static Node reduceByFu(ArrayList<Node> reduceNodeList,P p){//F->-F
		if(reduceNodeList.get(1).getValue().toString().contains("."))
			return new Node(p.getLeftV().getSingle(),reduceNodeList.get(0).getKey()+reduceNodeList.get(1).getKey(),-Double.parseDouble(reduceNodeList.get(1).getValue().toString()),reduceNodeList.get(1).getBeanTpye());
		else
			return new Node(p.getLeftV().getSingle(),reduceNodeList.get(0).getKey()+reduceNodeList.get(1).getKey(),-Integer.parseInt(reduceNodeList.get(1).getValue().toString()),reduceNodeList.get(1).getBeanTpye());

		
	}
	
	
	
	
	
	

}
