package util;


import java.io.File;
import java.util.Scanner;




public class Test {
	

	private final static String filename="E:/Hadoop WorkSpace/PLTest/src/util/test.txt";
	private static Scanner in;
 
	

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		System.out.println("�༶�����1��\t���������Ͷ�\t ���:30");
		System.out.print("������Գ�����");
		in.nextLine();
		System.out.println("��ʼ����......");
		

		File fileObj=new File(filename);
		java.util.Iterator<String> it=new FileTool().txtToString(fileObj).iterator();
		while(it.hasNext()){
		Build build=new Build(it.next());
		build.getsym();
		Analyze.getAnalyze().divceProgram();
		}
		


	}

}
