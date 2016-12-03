package util;




public class Build {
  //下标 
  private int i;
  
  //存储读取的字符
  private char ch;
  
  //将输入自符串转为字符数组
  private char[] input_array;
  
  //截取存储字符串
  private String s;
  //记录上一次运算符出现的位置
  private int lastSingle;
  private String input;
  public Build(String input){
	  this.input_array = input.toCharArray();
	  this.input=input;
	  ch=input_array[0];
	  this.i=0;
	  this.lastSingle=-1;
  }
  
  
  
  //词法分析函数
  public int getsym(){
	  
	  
	  
	//i=0时，首字符为小数点,+,-，*，/抛出错误
    if(BuildUtils.throwFirstSigleError(ch)){
    //将此次非法标识符出现的位置存储到lastSingle
    lastSingle=0;
    i++;
    }
    
    
	 while(i<input.length()){//外层循环用于判断是何种别的单词
		 
		  ch=input_array[i];
		  while(ch==' '||ch==10||ch==13||ch==9){//换行，空格，回车和tab
	
			  	ch=input_array[i++];//取下一个字符到ch
		 
		  }
		  
		  if(ch>='0'&&ch<='9'){ //检测是否为数字，如果为数字测需要分段存储数字串
			  if(ch=='0'){//如果为0
				  i++;
				  if(i<input.length())	ch=input_array[i];//取下一个字符到ch
				  else{
					  BuildUtils.getEndSingle(input, lastSingle, i);break;
				  }
				  if(ch=='.'){//为小数点
					  i++;
					  if(i<input.length())	ch=input_array[i];	
		  				else{
		  					 BuildUtils.getEndSingle(input, lastSingle, i);break;
			  			}//取下一个字符到ch
					  	if(ch>='0'&&ch<='9'){//取下一个字符到ch//小数点后面的数字
					  		i++;
					  		if(i<input.length())	ch=input_array[i];	
			  				else{
			  					 BuildUtils.getEndSingle(input, lastSingle, i);break;
				  			}//取下一个字符到ch//小数点后面的后面
					  		if(ch>='0'&&ch<='9'){
					  			while(ch>='0'&&ch<='9') {	
					  				i++;
					  				if(i<input.length())	ch=input_array[i];	
					  				else{
					  					 BuildUtils.getEndSingle(input, lastSingle, i);break;
						  			}
					  			
					  			}//当1-9后面字符为0-9时自动机一直空转循环
						  			
					  		}else{
					  			continue;//提前返回至for循环，判断下次输入(最后转至终态)
					  		}
					  		
					  		
					  	}else{//在小数点后面出现了非法字符
					  		  System.out.println("ERROR:\n小数点后出现了字符"+String.valueOf(ch)); 
					  		  Analyze.lastAnayScuccess=false;
					  		  lastSingle=i;
							  continue;
					  	}
				  }else{//不为小数点
					  continue;
				  }
				  
				  
				  
			   }else{//如果为1-9
				  i++;
				  if(i<input.length()) ch=input_array[i];//取下一个字符到ch//1-9的下一个字符
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
					  }//当1-9后面字符为0-9时自动机一直空转循环
					
					  
					  
				  }else if(ch=='.'){	
					    i++;
					    if(i<input.length()) ch=input_array[i];//取下一个字符到ch
					  	if(ch>='0'&&ch<='9'){//取下一个字符到ch//小数点后面的数字
					  		
					  		i++;
					  	  if(i<input.length())ch=input_array[i];//取下一个字符到ch//小数点后面的后面
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
					  				}//当1-9后面字符为0-9时自动机一直空转循环
					  		}else{
					  			continue;//提前返回至for循环，判断下次输入(最后转至终态)
					  		}
					  		
					  		
					  	}else{//在小数点后面出现了非法字符
					  		  System.out.println("ERROR:\n小数点后出现了字符"+String.valueOf(ch));
					  		  Analyze.lastAnayScuccess=false;
					  		  lastSingle=i;
					  		  i++;
							  continue;
					  	}
					  
				  }else{
					  continue;//提前返回至外层循环，判断此次输入(最后转至终态)
				  }
					  
				  
				  
			  }
			 
			  
			  
			  
		  }else if(ch=='.'){	
			    i++;
			    if(i<input.length()) ch=input_array[i];//取下一个字符到ch
			  	if(ch>='0'&&ch<='9'){//取下一个字符到ch//小数点后面的数字
			  		
			  		i++;
			  	  if(i<input.length())ch=input_array[i];//取下一个字符到ch//小数点后面的后面
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
			  				}//当1-9后面字符为0-9时自动机一直空转循环
			  		}else{
			  			continue;//提前返回至for循环，判断下次输入(最后转至终态)
			  		}
			  		
			  		
			  	}else{//在小数点后面出现了非法字符
			  		  System.out.println("ERROR:\n小数点后出现了字符"+String.valueOf(ch)); 
			  		  Analyze.lastAnayScuccess=false;
			  		  lastSingle=i;
			  		  i++;
					  continue;
			  	}
			  
		  }
		  
		  
		  
		  
		  
		  
		  
		  else{//不是数字 
			  
			  //取下的为运算符
			  if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'){
			     if(i!=0){
				      
				      if(lastSingle==-1) s=input.substring(0, i);
				      else s=input.substring(lastSingle+1, i);
				      //将此次运算符出现的位置存储到lastSingle
				      lastSingle=i;
				      if(!s.isEmpty()){
				    	  BuildUtils.parsertoIntOrDouble(s);
				      }
				   
					  BuildUtils.parsertoSingle(ch);
					  i++;
					  continue;//继续判断下一字符
			     }else{
			    	  BuildUtils.parsertoSingle(ch);
			    	  lastSingle=i;
					  i++;
					  continue;//继续判断下一字符
			     }
			  }else{//否则出错，但需要同时记录出错字符的位置以便获取数字串
				  
				  //将此次非法标识符出现的位置存储到lastSingle
			      lastSingle=i;
				  //在任何位置出现了非法字符
				  System.out.println("ERROR:\n出现非法标识符"+String.valueOf(ch)); 
				  i++;
				  continue;
				    
				  
			  }
			 
			  
			  
			  
			  
		  }
		  
		  
	 }
	  
	return 0;
	  
  }


}
