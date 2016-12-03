package util;


import java.io.File;
import java.util.Scanner;




public class Test {
	

	private final static String filename="E:/Hadoop WorkSpace/PLTest/src/util/test.txt";
	private static Scanner in;
 
	

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		System.out.println("班级：软件1班\t姓名：曾煌东\t 序号:30");
		System.out.print("输入测试程序名");
		in.nextLine();
		System.out.println("开始编译......");
		

		File fileObj=new File(filename);
		java.util.Iterator<String> it=new FileTool().txtToString(fileObj).iterator();
		while(it.hasNext()){
		Build build=new Build(it.next());
		build.getsym();
		Analyze.getAnalyze().divceProgram();
		}
		


	}

}
