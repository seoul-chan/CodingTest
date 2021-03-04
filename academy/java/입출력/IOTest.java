package com.io.controller;

import java.io.File;
import java.io.IOException;

public class IOTest {
	public static void main(String[] args) {
		
		File f = new File("1_IOTest.txt"); //��� ��� ���� ����
		String path = IOTest.class.getResource("/").getPath();
		path = path.substring(0,path.lastIndexOf("bin"));
		File f2 = new File(path+"1_IOTest(2).txt"); //���� ��� ���� ����
		try{
			f.createNewFile();
			f2.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
//		File dir = new File("a\\b\\c");
//		File dir = new File("a/b/c");
		File dir = new File("a"+File.separator+"b"+File.separator+"c");
		dir.mkdirs();
		dir.delete();
		
		
		File FList = new File("C:\\Users\\Chan\\eclipse-workspace\\13_io.controller");
		String[] listStr = FList.list();
		
		//���ϸ� ���
		for(String name : listStr) {			
			File temp = new File(FList.getAbsolutePath(),name);
			if(temp.isFile()) System.out.print(name+" / ");	
		}
		
		System.out.println();
		
		//������ ���
		for(String name : listStr) {			
			File temp = new File(FList.getAbsolutePath(),name);
			if(temp.isDirectory()) System.out.print(name+" / ");	
		}
		
		System.out.println();
		
		File[] files = FList.listFiles();
		for(File temp : files) {
//			System.out.println(temp);
			if(temp.isFile()) System.out.println(temp.getName());
		}
				
	} // main
}
