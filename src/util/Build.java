package util;




public class Build {
  //�±� 
  private int i;
  
  //�洢��ȡ���ַ�
  private char ch;
  
  //�������Է���תΪ�ַ�����
  private char[] input_array;
  
  //��ȡ�洢�ַ���
  private String s;
  //��¼��һ����������ֵ�λ��
  private int lastSingle;
  private String input;
  public Build(String input){
	  this.input_array = input.toCharArray();
	  this.input=input;
	  ch=input_array[0];
	  this.i=0;
	  this.lastSingle=-1;
  }
  
  
  
  //�ʷ���������
  public int getsym(){
	  
	  
	  
	//i=0ʱ�����ַ�ΪС����,+,-��*��/�׳�����
    if(BuildUtils.throwFirstSigleError(ch)){
    //���˴ηǷ���ʶ�����ֵ�λ�ô洢��lastSingle
    lastSingle=0;
    i++;
    }
    
    
	 while(i<input.length()){//���ѭ�������ж��Ǻ��ֱ�ĵ���
		 
		  ch=input_array[i];
		  while(ch==' '||ch==10||ch==13||ch==9){//���У��ո񣬻س���tab
	
			  	ch=input_array[i++];//ȡ��һ���ַ���ch
		 
		  }
		  
		  if(ch>='0'&&ch<='9'){ //����Ƿ�Ϊ���֣����Ϊ���ֲ���Ҫ�ֶδ洢���ִ�
			  if(ch=='0'){//���Ϊ0
				  i++;
				  if(i<input.length())	ch=input_array[i];//ȡ��һ���ַ���ch
				  else{
					  BuildUtils.getEndSingle(input, lastSingle, i);break;
				  }
				  if(ch=='.'){//ΪС����
					  i++;
					  if(i<input.length())	ch=input_array[i];	
		  				else{
		  					 BuildUtils.getEndSingle(input, lastSingle, i);break;
			  			}//ȡ��һ���ַ���ch
					  	if(ch>='0'&&ch<='9'){//ȡ��һ���ַ���ch//С������������
					  		i++;
					  		if(i<input.length())	ch=input_array[i];	
			  				else{
			  					 BuildUtils.getEndSingle(input, lastSingle, i);break;
				  			}//ȡ��һ���ַ���ch//С�������ĺ���
					  		if(ch>='0'&&ch<='9'){
					  			while(ch>='0'&&ch<='9') {	
					  				i++;
					  				if(i<input.length())	ch=input_array[i];	
					  				else{
					  					 BuildUtils.getEndSingle(input, lastSingle, i);break;
						  			}
					  			
					  			}//��1-9�����ַ�Ϊ0-9ʱ�Զ���һֱ��תѭ��
						  			
					  		}else{
					  			continue;//��ǰ������forѭ�����ж��´�����(���ת����̬)
					  		}
					  		
					  		
					  	}else{//��С�����������˷Ƿ��ַ�
					  		  System.out.println("ERROR:\nС�����������ַ�"+String.valueOf(ch)); 
					  		  Analyze.lastAnayScuccess=false;
					  		  lastSingle=i;
							  continue;
					  	}
				  }else{//��ΪС����
					  continue;
				  }
				  
				  
				  
			   }else{//���Ϊ1-9
				  i++;
				  if(i<input.length()) ch=input_array[i];//ȡ��һ���ַ���ch//1-9����һ���ַ�
				  else{
					  BuildUtils.getEndSingle(input, lastSingle+1, i);break;
					  }
				  if(ch>='0'&&ch<='9'){
					  while(ch>='0'&&ch<='9') {	
						  i++;
						  if(i<input.length()) ch=input_array[i];	
						  else {
							  if(lastSingle==-1)  {BuildUtils.getEndSingle(input, 0, i);	break;}
							  else
								  {BuildUtils.getEndSingle(input, lastSingle, i);	break;}
						  }
					  }//��1-9�����ַ�Ϊ0-9ʱ�Զ���һֱ��תѭ��
					
					  
					  
				  }else if(ch=='.'){	
					    i++;
					    if(i<input.length()) ch=input_array[i];//ȡ��һ���ַ���ch
					  	if(ch>='0'&&ch<='9'){//ȡ��һ���ַ���ch//С������������
					  		
					  		i++;
					  	  if(i<input.length())ch=input_array[i];//ȡ��һ���ַ���ch//С�������ĺ���
					  	  else{ 
					  		BuildUtils.getEndSingle(input, lastSingle, i);  break;
					  	  }
					  	  
					  	  if(ch>='0'&&ch<='9'){
					  			while(ch>='0'&&ch<='9') {	
						  				i++;
						  				if(i<input.length()) ch=input_array[i];
						  				else{ 
						  					BuildUtils.getEndSingle(input, lastSingle, i);	break;
						  				}
					  				}//��1-9�����ַ�Ϊ0-9ʱ�Զ���һֱ��תѭ��
					  		}else{
					  			continue;//��ǰ������forѭ�����ж��´�����(���ת����̬)
					  		}
					  		
					  		
					  	}else{//��С�����������˷Ƿ��ַ�
					  		  System.out.println("ERROR:\nС�����������ַ�"+String.valueOf(ch));
					  		  Analyze.lastAnayScuccess=false;
					  		  lastSingle=i;
					  		  i++;
							  continue;
					  	}
					  
				  }else{
					  continue;//��ǰ���������ѭ�����жϴ˴�����(���ת����̬)
				  }
					  
				  
				  
			  }
			 
			  
			  
			  
		  }else if(ch=='.'){	
			    i++;
			    if(i<input.length()) ch=input_array[i];//ȡ��һ���ַ���ch
			  	if(ch>='0'&&ch<='9'){//ȡ��һ���ַ���ch//С������������
			  		
			  		i++;
			  	  if(i<input.length())ch=input_array[i];//ȡ��һ���ַ���ch//С�������ĺ���
			  	  else{ 
			  		BuildUtils.getEndSingle(input, lastSingle, i);  break;
			  	  }
			  	  
			  	  if(ch>='0'&&ch<='9'){
			  			while(ch>='0'&&ch<='9') {	
				  				i++;
				  				if(i<input.length()) ch=input_array[i];
				  				else{ 
				  					BuildUtils.getEndSingle(input, lastSingle, i);	break;
				  				}
			  				}//��1-9�����ַ�Ϊ0-9ʱ�Զ���һֱ��תѭ��
			  		}else{
			  			continue;//��ǰ������forѭ�����ж��´�����(���ת����̬)
			  		}
			  		
			  		
			  	}else{//��С�����������˷Ƿ��ַ�
			  		  System.out.println("ERROR:\nС�����������ַ�"+String.valueOf(ch)); 
			  		  Analyze.lastAnayScuccess=false;
			  		  lastSingle=i;
			  		  i++;
					  continue;
			  	}
			  
		  }
		  
		  
		  
		  
		  
		  
		  
		  else{//�������� 
			  
			  //ȡ�µ�Ϊ�����
			  if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'){
			     if(i!=0){
				      
				      if(lastSingle==-1) s=input.substring(0, i);
				      else s=input.substring(lastSingle+1, i);
				      //���˴���������ֵ�λ�ô洢��lastSingle
				      lastSingle=i;
				      if(!s.isEmpty()){
				    	  BuildUtils.parsertoIntOrDouble(s);
				      }
				   
					  BuildUtils.parsertoSingle(ch);
					  i++;
					  continue;//�����ж���һ�ַ�
			     }else{
			    	  BuildUtils.parsertoSingle(ch);
			    	  lastSingle=i;
					  i++;
					  continue;//�����ж���һ�ַ�
			     }
			  }else{//�����������Ҫͬʱ��¼�����ַ���λ���Ա��ȡ���ִ�
				  
				  //���˴ηǷ���ʶ�����ֵ�λ�ô洢��lastSingle
			      lastSingle=i;
				  //���κ�λ�ó����˷Ƿ��ַ�
				  System.out.println("ERROR:\n���ַǷ���ʶ��"+String.valueOf(ch)); 
				  i++;
				  continue;
				    
				  
			  }
			 
			  
			  
			  
			  
		  }
		  
		  
	 }
	  
	return 0;
	  
  }


}
