package util;


import java.util.ArrayList;

import bean.Node;

public class Analyze {
	
	private Node particularNode=new Node(null, "#", null, null);
	private ArrayList<Node> inputStack=new ArrayList<Node>();//���봮
	private ArrayList<Node> inputQueue=new ArrayList<Node>();//����ջ
	private ArrayList<Node> singleQueue=new ArrayList<Node>();//����ջ
	private ArrayList<Integer> analyzeQueue=new ArrayList<Integer>();//����ջ(״̬ջ)
	private static Analyze analyze=null;
	private int statuSum=16;//���ķ��漰��16��״̬
	private int Action=8;//8������
	private int Turn=3;//3��ת��
	public static boolean lastAnayScuccess=true;
	int act = 0 ;//����  
	int turn=0;//ת��
	int status=0;//��ʼ״̬
	int actionIndex=-1;
	int turnIndex=-1;
	int index;//���봮���ַ��±�
	int SUCCESS=0;
	int FAILE=1;
	int sindex;
	int aindex;

	Node reduceNode = null;//��Լ��ѹ�����ջ�ĵ��ʽ��
	
	private  Analyze(){
		this.inputQueue.add(particularNode);//���봮�ڽ����﷨����ǰҪ�Ƚ�������ѹ��ջ��
		this.singleQueue.add(particularNode);//����ջ��ʼ״̬��Ϊ#
		this.analyzeQueue.add(0);
		//result = new StringBuilder();
	
	}
	
	public static Analyze getAnalyze(){
		if(analyze==null){
			analyze=new Analyze();
		}
		return analyze;
	}
	
	public void addNode(Node node){//��ʼ�����봮
		inputStack.add(node);
	}
	
	public void shiftNode(Node node){//����ƥ���node�ƽ�����ջ
		singleQueue.add(node);
	}
	
	
	public void addNodeToSQ(Integer Istatus){//״̬ջ���״̬
		analyzeQueue.add(Istatus);
	}
	
	
	public int divceProgram(){//��������
	exchange(inputStack, inputQueue);
	index=inputQueue.size()-1;
	int ti=1;//t1,t2,t3...
	if(lastAnayScuccess){//����һ���ʷ�����û�г������������½����﷨����
		
		
		System.out.println("��ʼ�����﷨����");
	
		
		while(true){   //�����봮���׵��ʿ�ʼ�ж��Ƿ��������ջ
			
			
					//�õ��ʽڵ�ִ�е�״̬��ת
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
							 
							 turn=ParserType.go[status][turnIndex];//true��goto���е�Ԫ��ֵ
							 if(turn>0){
								 status=turn;//״̬��ת��goto��true����Ӧ��ֵ
								 turnIndex=-1;
								 index--;//��ת��turn����֮��ƥ����һ�����뵥��
								 System.out.println("���봮ʣ�೤��"+index);
						    	 break;
							 }else{//����0ʱ����
								 ProcError();   return FAILE;
							 }
							 
							 
						 }else
						 {
							break; 
						 }
						
					}
					
					
						//�õ��ʽڵ�ִ�еĶ���
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
								System.out.println("״̬"+status);
								System.out.println("�����±�"+actionIndex);
								
									act=ParserType.action[status][actionIndex];//����	
								
							     if (act == ParserType.BLANK)    {    
							    	 ProcError();    System.out.println("�﷨����"); return FAILE; 
							     }else if(act==ParserType.ACC){
							    	 
							    	 System.out.println("�����봮�����﷨Ҫ���ѱ�����");
							    	 System.out.println("��������"+singleQueue.get(1).getValue());
							    	 return SUCCESS;
							    	 
							     }else if(act>0){//�����ƽ�������Ȼ��ת��״̬act
							    	 //�ƽ����������������ĵ���ѹ�����ջ
							    	 singleQueue.add(inputQueue.get(index));
							    	 analyzeQueue.add(act);
							    	 System.out.println(inputQueue.get(index)+"�������ջ");
							    	 System.out.println(act+"����״̬ջ");
							    	 System.out.println("����ջ��"+singleQueue.toString());
							    	 System.out.println("״̬ջ��"+analyzeQueue.toString());
							    	 status=act;
							    	 actionIndex=-1;
							    	 index--;
							    	 continue;
							    	 
							     }else{//���й�Լ����
							    	 
							    	 //��ʱactֵС��0��ȡ����ֵ֮��Ϊ��Լ���õ��ķ�����ʽ���Math.abs(act);
							         for(P p:ParserType.pset){//Ѱ�Ҳ���ʽ
							        	 if(p.getNum()== Math.abs(act)){
							        		 int noZeroNum=0;
							        		 
							        		 aindex=analyzeQueue.size()-1;
							        		 sindex=singleQueue.size()-1;
							        		 ArrayList<Node>  reduceNodeList=new ArrayList<Node>();//��Լ�м����洢�б�
							        		// ArrayList<Node>  saveNodeList=new ArrayList<Node>();//��Լ�м�����洢�б�
							        		 StringBuilder result=new StringBuilder();
							        		 for(int i=0;i<p.getRigthExp().length;i++){
							        			 if(!p.getRigthExp()[i].toString().equals("0")){
							        				 noZeroNum++;
							        			 }
							        			 
							        		 }
							        		 
							        		 
							        			 while(noZeroNum>0){
							        			 //�洢��Ҫ��Լ�ĵ���
							        			
							        			 reduceNodeList.add(singleQueue.get(sindex));
							        			
							        			 System.out.println(singleQueue.get(sindex)+"����Լ");
							        			//״̬ջ�ͷ���ջҪ�Ƴ��Ľ��
							        			 singleQueue.remove(singleQueue.get(sindex));
							        	  		 if(sindex>0)	sindex--;
							        			 analyzeQueue.remove(analyzeQueue.get(aindex));//����ջ��״̬�Ĳ�����ͬ��
							        			 if (aindex>0)	aindex--;
							        			 noZeroNum--;
							        		 }
							        			 
							        	
				        		 V ch=p.getLeftV();//��ȡ��Լ��ĵ��ʣ�
				        		 int leftVindex=0;
				        		 //�ҵ���goto���Ӧ��turnIndexֵ
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
							        		 System.out.println("rigthExp��"+rigthExp);
						        		
							        		 if(rigthExp.contains("+")||rigthExp.contains("-")||rigthExp.contains("*")||rigthExp.contains("/")){
							        			     //��Լ��ĵ�����Ԫʽ
													 Node saveNode=new Node(p.getRigthExp()[1].toString(),reduceNodeList.get(2).getValue().toString(),
									        				 reduceNodeList.get(0).getValue().toString(),"t"+(ti++));
													// saveNodeList.add(saveNode);
													//����м���Ԫʽ
									        		 System.out.println(saveNode.toString());
												 
												
								        		 //�����ʴ�ת������ʵ���ַ����㲢��reduceNode�洢�м���
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
							        
							        		 
							        		 
							        		
							        		 
							        		 singleQueue.add(reduceNode);//��Լ֮���м���ѹ�����ջ
							        		 sindex++;
							        		 status=ParserType.go[analyzeQueue.get(aindex)][leftVindex];
							        		 analyzeQueue.add(status);//��״̬ջ��ӹ�Լ���״̬
							        		 aindex++;
							        		 System.out.println(singleQueue.get(sindex)+"�������ջ");	
									    	 System.out.println(analyzeQueue.get(aindex)+"����״̬ջ");
									    	 System.out.println("����ջ��"+singleQueue.toString());
									    	 System.out.println("״̬ջ��"+analyzeQueue.toString());
							        		 actionIndex=-1;
							        		 break;
							        	 }
							         } 
							    	 //��Լ�׶��漰goto����
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
		System.out.println("�﷨����");
		
	}
	
	private void WorldError() {
		// TODO Auto-generated method stub
		System.out.println("���ڴʷ������޷������﷨����");
		
	}
	//ջ���ݵ���
	public void exchange(ArrayList<Node> list1,ArrayList<Node> list2){
		for(int i=list1.size()-1;i>=0;i--){
			list2.add(list1.get(i));
		}
	}
	
}
