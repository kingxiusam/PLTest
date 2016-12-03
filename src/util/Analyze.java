package util;


import java.util.ArrayList;

import bean.Node;

public class Analyze {
	
	private Node particularNode=new Node(null, "#", null, null);
	private ArrayList<Node> inputStack=new ArrayList<Node>();//输入串
	private ArrayList<Node> inputQueue=new ArrayList<Node>();//输入栈
	private ArrayList<Node> singleQueue=new ArrayList<Node>();//符号栈
	private ArrayList<Integer> analyzeQueue=new ArrayList<Integer>();//分析栈(状态栈)
	private static Analyze analyze=null;
	private int statuSum=16;//该文法涉及了16个状态
	private int Action=8;//8个动作
	private int Turn=3;//3个转移
	public static boolean lastAnayScuccess=true;
	int act = 0 ;//动作  
	int turn=0;//转移
	int status=0;//初始状态
	int actionIndex=-1;
	int turnIndex=-1;
	int index;//输入串的字符下标
	int SUCCESS=0;
	int FAILE=1;
	int sindex;
	int aindex;

	Node reduceNode = null;//规约后压入符号栈的单词结点
	
	private  Analyze(){
		this.inputQueue.add(particularNode);//输入串在进行语法分析前要先将结束符压入栈底
		this.singleQueue.add(particularNode);//符号栈初始状态下为#
		this.analyzeQueue.add(0);
		//result = new StringBuilder();
	
	}
	
	public static Analyze getAnalyze(){
		if(analyze==null){
			analyze=new Analyze();
		}
		return analyze;
	}
	
	public void addNode(Node node){//初始化输入串
		inputStack.add(node);
	}
	
	public void shiftNode(Node node){//将待匹配的node移进符号栈
		singleQueue.add(node);
	}
	
	
	public void addNodeToSQ(Integer Istatus){//状态栈添加状态
		analyzeQueue.add(Istatus);
	}
	
	
	public int divceProgram(){//驱动程序
	exchange(inputStack, inputQueue);
	index=inputQueue.size()-1;
	int ti=1;//t1,t2,t3...
	if(lastAnayScuccess){//在上一步词法分析没有出错的情况下往下进行语法分析
		
		
		System.out.println("开始进行语法分析");
	
		
		while(true){   //从输入串的首单词开始判断是否移入符号栈
			
			
					//该单词节点执行的状态跳转
					while(turnIndex<Turn){	
						
						if(index>=0){
							for(int j=0;j<Turn;j++){
								if(inputQueue.get(index).getKey().equals(ParserType.vn[j].getSingle())){
									turnIndex=j;
									break;
								}
							}
						}
						
						
						
						 if(turnIndex!=-1){
							 
							 turn=ParserType.go[status][turnIndex];//true是goto表中的元素值
							 if(turn>0){
								 status=turn;//状态跳转到goto表true所对应的值
								 turnIndex=-1;
								 index--;//跳转到turn步骤之后匹配下一个输入单词
								 System.out.println("输入串剩余长度"+index);
						    	 break;
							 }else{//等于0时出错
								 ProcError();   return FAILE;
							 }
							 
							 
						 }else
						 {
							break; 
						 }
						
					}
					
					
						//该单词节点执行的动作
						while(actionIndex<Action){
							
							
							
							if(index>0){
								for(int i=1;i<Action;i++){
									if(inputQueue.get(index).getKey().equals(ParserType.vt[i].getSingle())){
										actionIndex=i;
										break;
									} 
									
								}
								if(inputQueue.get(index).getBeanTpye().equals("int")||inputQueue.get(index).getBeanTpye().equals("double")){
										actionIndex=0;
									}
								
							}
							if(index==0){
								actionIndex=7;
							}
					
							
							
							if(actionIndex!=-1){
								System.out.println("状态"+status);
								System.out.println("动作下标"+actionIndex);
								
									act=ParserType.action[status][actionIndex];//动作	
								
							     if (act == ParserType.BLANK)    {    
							    	 ProcError();    System.out.println("语法错误"); return FAILE; 
							     }else if(act==ParserType.ACC){
							    	 
							    	 System.out.println("该输入串符合语法要求并已被接收");
							    	 System.out.println("计算结果："+singleQueue.get(1).getValue());
							    	 return SUCCESS;
							    	 
							     }else if(act>0){//进行移进操作，然后转向状态act
							    	 //移进操作，将待分析的单词压入符号栈
							    	 singleQueue.add(inputQueue.get(index));
							    	 analyzeQueue.add(act);
							    	 System.out.println(inputQueue.get(index)+"加入符号栈");
							    	 System.out.println(act+"加入状态栈");
							    	 System.out.println("符号栈："+singleQueue.toString());
							    	 System.out.println("状态栈："+analyzeQueue.toString());
							    	 status=act;
							    	 actionIndex=-1;
							    	 index--;
							    	 continue;
							    	 
							     }else{//进行规约操作
							    	 
							    	 //此时act值小于0，取绝对值之后即为规约所用的文法产生式序号Math.abs(act);
							         for(P p:ParserType.pset){//寻找产生式
							        	 if(p.getNum()== Math.abs(act)){
							        		 int noZeroNum=0;
							        		 
							        		 aindex=analyzeQueue.size()-1;
							        		 sindex=singleQueue.size()-1;
							        		 ArrayList<Node>  reduceNodeList=new ArrayList<Node>();//规约中间结果存储列表
							        		// ArrayList<Node>  saveNodeList=new ArrayList<Node>();//规约中间变量存储列表
							        		 StringBuilder result=new StringBuilder();
							        		 for(int i=0;i<p.getRigthExp().length;i++){
							        			 if(!p.getRigthExp()[i].toString().equals("0")){
							        				 noZeroNum++;
							        			 }
							        			 
							        		 }
							        		 
							        		 
							        			 while(noZeroNum>0){
							        			 //存储需要规约的单词
							        			
							        			 reduceNodeList.add(singleQueue.get(sindex));
							        			
							        			 System.out.println(singleQueue.get(sindex)+"被规约");
							        			//状态栈和符号栈要移除的结点
							        			 singleQueue.remove(singleQueue.get(sindex));
							        	  		 if(sindex>0)	sindex--;
							        			 analyzeQueue.remove(analyzeQueue.get(aindex));//符号栈和状态的操作需同步
							        			 if (aindex>0)	aindex--;
							        			 noZeroNum--;
							        		 }
							        			 
							        	
				        		 V ch=p.getLeftV();//获取规约后的单词，
				        		 int leftVindex=0;
				        		 //找到在goto表对应的turnIndex值
				        		 for(V v:ParserType.vn){
				        			 if(!v.equals(ch)){
				        				 leftVindex++;
				        			 }else
				        				 break;
				        		 }
							        
							        		 
							        	
							        		 for(String str:p.getRigthExp()){
							        			result.append(str);
							        		 }
							        		 String rigthExp=result.toString();
							        		 System.out.println("rigthExp："+rigthExp);
						        		
							        		 if(rigthExp.contains("+")||rigthExp.contains("-")||rigthExp.contains("*")||rigthExp.contains("/")){
							        			     //规约后的单词四元式
													 Node saveNode=new Node(p.getRigthExp()[1].toString(),reduceNodeList.get(2).getValue().toString(),
									        				 reduceNodeList.get(0).getValue().toString(),"t"+(ti++));
													// saveNodeList.add(saveNode);
													//输出中间四元式
									        		 System.out.println(saveNode.toString());
												 
												
								        		 //将单词串转换成真实的字符运算并用reduceNode存储中间结果
								        		 switch(p.getRigthExp()[1].toString()){
								        		 case "+":
								        			 reduceNode=ReduceTools.reduceByAdd(reduceNodeList, p);break;
								        			 							        		     
								        		 case "-":
								        			 reduceNode=ReduceTools.reduceByJian(reduceNodeList, p); break;
						 			 
								        		 case "*":
								        			 reduceNode=ReduceTools.reduceByCheng(reduceNodeList, p);break;
								        			     			
								        		 case "/": 
								        			 reduceNode=ReduceTools.reduceByChu(reduceNodeList, p); break;
								        			
								        		 default:
								        			 	break;
								        		
								        			 
								        		 }

							        		 }else if(rigthExp.contains("i")){
							        			 
							        			 reduceNode=ReduceTools.reduceFromi(reduceNodeList, p);
							        			 
							        		 }else if(rigthExp.contains("(")&&rigthExp.contains(")")){
							        			 
							        			 reduceNode=ReduceTools.reduceByKuoHao(reduceNodeList, p);
							        			 
							        		 }/*else if(rigthExp.contains("-F")){//F->-F
							        			 reduceNode=ReduceTools.reduceByFu(reduceNodeList, p);
							        			 
							        		 }*/else{//T->F//E->T//S->E
							        			 reduceNode=ReduceTools.reduceFromOther(reduceNodeList, p);
							        		 }
							        
							        		 
							        		 
							        		
							        		 
							        		 singleQueue.add(reduceNode);//规约之后将中间结果压入符号栈
							        		 sindex++;
							        		 status=ParserType.go[analyzeQueue.get(aindex)][leftVindex];
							        		 analyzeQueue.add(status);//向状态栈添加规约后的状态
							        		 aindex++;
							        		 System.out.println(singleQueue.get(sindex)+"加入符号栈");	
									    	 System.out.println(analyzeQueue.get(aindex)+"加入状态栈");
									    	 System.out.println("符号栈："+singleQueue.toString());
									    	 System.out.println("状态栈："+analyzeQueue.toString());
							        		 actionIndex=-1;
							        		 break;
							        	 }
							         } 
							    	 //规约阶段涉及goto操作
							     }
					}else{
							break;	
					}
							
							
							
					
					
						}
						
				
				}
		
	
		
	}else{
		WorldError();
	}
	return 0;
		  
		
		
		
	}

	private void ProcError() {
		// TODO Auto-generated method stub
		System.out.println("语法错误");
		
	}
	
	private void WorldError() {
		// TODO Auto-generated method stub
		System.out.println("存在词法错误，无法进行语法分析");
		
	}
	//栈数据倒灌
	public void exchange(ArrayList<Node> list1,ArrayList<Node> list2){
		for(int i=list1.size()-1;i>=0;i--){
			list2.add(list1.get(i));
		}
	}
	
}
