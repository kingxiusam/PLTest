package util;

public class ParserType {
	
	 static final int BLANK=0;
	 
	 static final int ACC=20;
	static /*以下变量用于语法分析*/ 
	//终结符符号表 
	
	V $INTOrDouble=new V("i");
	static V $PLUS=new V("+");
	static V $MINUS=new V("-");
	static V $MUL=new V("*");
	static V $DIV=new V("/");
	static V $LPAR=new V("(");
	static V $RPAR=new V(")");
	static V $END=new V("#");
	
	static V $E=new V("E");
	static V $T=new V("T");
	static V $F=new V("F");
	static V $S=new V("S");
	
	static V vt[]={   
			$INTOrDouble,
			$PLUS,
			$MINUS,
			$MUL,
			$DIV,
			$LPAR,
			$RPAR,
			$END
	};
	//非终结符符号表 
	static V vn[]={   
			$E,
			$T,
			$F,
			//$S
	};


	//规约时所需要的文法的产生式集合
	static P pset[]={ 
		
			new P(0,$S,new String[]{$E.getSingle(),"0","0","0"}),//S->E
			new P(1,$E,new String[]{$T.getSingle(),$PLUS.getSingle(),$E.getSingle(),"0"}),//E->E+T   
			new P(2,$E,new String[]{$T.getSingle(),"0","0","0"}),   //E->T
			new P(3,$T,new String[]{$T.getSingle(),$MUL.getSingle(),$F.getSingle(),"0"}),   //T->T*F
			new P(4,$T,new String[]{$F.getSingle(),"0","0","0"}), //T->F
			new P(5,$F,new String[]{$LPAR.getSingle(),$E.getSingle(),$RPAR.getSingle(),"0"}),  //F->(E) 
			new P(6,$F,new String[]{$INTOrDouble.getSingle(),"0","0","0"}),   //F->i
			new P(7,$E,new String[]{$E.getSingle(),$MINUS.getSingle(),$T.getSingle(),"0"}),//E->E-T  
			new P(8,$T,new String[]{$T.getSingle(),$DIV.getSingle(),$F.getSingle(),"0"}),  //T-> T/F
			new P(9,$F,new String[]{"-"+$F.getSingle(),"0","0","0"}),//F->-F 
	};
 
	
	
	
	
	//action表 
	static int action[][] = { 
	    //i   +	    -      *     /  (    )     #
	/*0*/{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
    /*1*/{BLANK,6,7,BLANK,BLANK,BLANK,BLANK,ACC},
	/*2*/{BLANK,-2,-2,8,9,BLANK,-2,-2},
	/*3*/{BLANK,-4,-4,-4,-4,BLANK,-4,-4},
	/*4*/{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
	/*5*/{BLANK,-6,-6,-6,-6,BLANK,-6,-6},
	/*6*/{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
	/*7*/{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
	/*8*/{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
	/*9*/{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
	/*10*/{BLANK,6,7,BLANK,BLANK,BLANK,15,BLANK},
	/*11*/{BLANK,-1,-1,8,9,BLANK,-1,-1},
	/*12*/{BLANK,-7,-7,8,9,BLANK,-7,-7},
	/*13*/{BLANK,-3,-3,-3,-3,BLANK,-3,-3},
	/*14*/{BLANK,-8,-8,-8,-8,BLANK,-8,-8},
	/*15*/{BLANK,-5,-5,-5,-5,BLANK,-5,-5},
			
			
			/*{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
			{BLANK,6,7,BLANK,BLANK,BLANK,BLANK,ACC},
			{BLANK,-3,-3,8,9,BLANK,-3,-3},
			{BLANK,-6,-6,-6,-6,BLANK,-6,-6},
			
		
			{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
			{BLANK,-8,-8,-8,-8,BLANK,-8,-8},
		
			{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
			{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
			{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
			{5,BLANK,BLANK,BLANK,BLANK,4,BLANK,BLANK},
			{BLANK,6,7,BLANK,BLANK,BLANK,15,BLANK},
			{BLANK,-1,-1,-8,9,BLANK,-1,-1},
			{BLANK,-2,-2,8,9,BLANK,-2,-2},
			{BLANK,-4,-4,-4,-4,BLANK,-4,-4},
			{BLANK,-5,-5,-5,-5,BLANK,-5,-5},
			{BLANK,-7,-7,-7,-7,BLANK,-7,-7}*/
			
			
	};

	
	 //Goto表
	static int go[][] = {  
	  //E,T,F  
	  {1,2,3}, 
	  {BLANK,BLANK,BLANK},  
	  {BLANK,BLANK,BLANK},  
	  {BLANK,BLANK,BLANK},  
	  {10,2,3},   
	  {BLANK,BLANK,BLANK},
	  {BLANK,11,3},
	  {BLANK,12,3},
	  {BLANK,BLANK,13},
	  {BLANK,BLANK,14}, 
	  {BLANK,BLANK,BLANK},
	  {BLANK,BLANK,BLANK},
	  {BLANK,BLANK,BLANK}, 
	  {BLANK,BLANK,BLANK},
	  {BLANK,BLANK,BLANK},
	  {BLANK,BLANK,BLANK} 
	  };
	
	
	
	
}
