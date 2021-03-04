package com.io.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

public class FileController {
	public static void main(String[] args) {
		/*	
		 * FileŬ������ �̿��ؼ� ���� ���� �� ���� �ϱ�
		 * File��ü�� �̿��� ���� �����̴�. Ŭ������ �����ؼ� ����ϸ� �������� �Ű������� 
		 * �����+���ϸ��� �����Ѵ�. ���ϸ� �ۼ��� ��� ����Ʈ ����� ������Ʈ ������ ������ ����ȴ�. 
		 * (��, C����̺꿡 ���� ���� �� ������ ��ü���� ���⿡ �������� �źεȴ�.)
		*/
		
		

		// ***����� ���ϻ��� : ������Ʈ ������ ����ȴ�.
		/*
		 * createNewFile() - ���� ���� �޼ҵ� 
		 * ���� �̸��� ������ �ִ� ��� ���� ���� X -> ���� ���� X
		 * boolean�� ��ȯ ���� ����, ������ �����Ǹ� true, �������������� false
		 */
		File f = new File("test.txt"); //heap������ File��ü�� ������ ����. 
		try {
			f.createNewFile();
			System.out.println(f.createNewFile()); //false, ������ �����̸��� ������ �̹� �����߱⿡
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		// *** ������Ʈ �������� ������ ã��
		// ���� ��� ��� �� ������, ������ ��ΰ� �ٸ��⿡ ������ �������־�� �Ѵ�.
		System.out.println(FileController.class.getResource("/").getPath()); //bin �������� ��� ���
		System.out.println(FileController.class.getResource("").getPath()); //����(��Ű��)��� ���� ���

		
		//bin������ ��α����� ��� �� ���� ����
		String path = FileController.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin"));
		System.out.println(path);

//		File f2= new File("C:\\Users\\Chan\\eclipse-workspace\\13_io.controller\\test2.txt"); //��θ� �����ؼ��� ��� �����ϴ�.
//		File f2 = new File(path+"/a/FileTest2.txt"); aó�� �߰��� �������� �ʴ� ��� �Է� �� IOException �߻�
		File f2 = new File(path+"testPath.txt");
		try {
			f2.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
			
		
		// *** ���丮 ����(mkdir) - (����Ʈ ���)�ϳ��� ���� ���丮�� ���� ����
		/*
		 * ������ �ϳ��� ������ �����ϱ⿡ �ۼ��� ��� �� ���� ��ΰ� ������ �������� �ʴ´�.
		 * ������ �����ϸ� true, �����ϸ� false�� ��ȯ�Ѵ�.
		 * (�ۼ��� ��� �� ���� ��ΰ� �־� ������ �����ϸ� false)
		*/
		File dir = new File("some");
		dir.mkdir(); //���� ������Ʈ ������ some���� ����
		
		
		// *** ���丮(���, mkdirs) ���� - ��η� ������ ��� ���丮 ���� ����
		/*
		 * ���� ������ �����ڴ� OSȯ�濡 ���� �ٸ���. File.separator�� ����ϸ� ȯ�濡 �°� �����ڸ� �־��ش�.
		 * new File("a\\b\\c\\d\\e");
		 * new File("a"+File.separator+"b"+File.separator+"c"+File.separator+"e");
		 * new File("a/b/c/d/e");
		 * �̷� ������ ���� ��θ� �ۼ��Ͽ� ����� �� �ִ�.
		 * ������ �����ϸ� true, �����ϸ� false�� ��ȯ�Ѵ�.
		 * (���� ��ΰ� �־� ������ �Ұ����ϸ� false)
		 */
		File dir2= new File("a/b/c/d/e");
		dir2.mkdirs(); //���� ������Ʈ ������ �������� �ۼ��� ��δ�� ������ ����
		
		
		
		// *** ���� ����, ������ ���ﶧ�� �� ������ ���� �ϳ��� ���� ����
		File del = new File("test.txt");
		del.delete();
		dir2.delete(); // ������ ���� e�� ���ŵ�(�ݺ� �����ص� ����)
		
		
		
		//createFile �޼ҵ带 �����
		//default��ο� test������ ����� test���� �ȿ� rclass������ �����ϴ� ��ɱ���
		createFile(); // �Ʒ� �޼ҵ� ����
		
		
		
		// *** file�� ���� ������ ������ִ� �޼ҵ�
		System.out.println(f2.getName()); //���� �Ǵ� ���� �̸� ���
		System.out.println(dir.getName());
		System.out.println(f2.canExecute());//true, �������� ���� Ȯ��, Ŭ���ؼ� ������ ���� ����
		System.out.println(dir.canExecute()); // ������ Ŭ�� �� �����⿡ true
		System.out.println(f2.canRead()); //���� �� �ִ� ��������
		System.out.println(f2.canWrite());//������ �� �ִ���
		System.out.println(f2.getParent());//���� ��ΰ� ��������
		
		File pa=f2.getParentFile();//�θ����� ���ϰ�ü�� ��ȯ
		System.out.println(pa.getName());
		System.out.println(f2.getAbsolutePath());//��ü ������
		System.out.println(f2.isHidden());//���� �������� Ȯ��
		System.out.println(f2.length()); //���� ũ��
		System.out.println(new Date(f2.lastModified()));//������¥
		System.out.println(f2.exists());//�����ϴ���
		if(f2.exists()) {
			System.out.println("�����ֳ�");
		}else {
			System.out.println("���Ͼ���!");
		}
		System.out.println(f2.isFile());//��������
		System.out.println(f2.isDirectory());//��������
		
		
		
		// *** [File f].list() -  ���� ������ ��ü ����/���� ����� ���ڿ� �迭�� ������
		File rootDir = new File("C:\\User\\Chan");
		String[] fileNames=rootDir.list(); //�ش� ������ ����/���� ����� ���ڿ� �迭�� ���
		
		//����Ʈ�� ����/������ �����ؼ� ���
		for(String name : fileNames) {
			// root.getAbsolutePath() = C:\Users\Chan
			// new File(rootDir.getAbsoluteFile()+"/"+name);-> ��� + ���� �̸��� File��ü�� �����ؼ� �ؼ� �ش� ����/������ �������� �������� ���
			
			File temp=new File(rootDir.getAbsoluteFile(),name); //(���, ���� �̸�)
			if(temp.isFile()) System.out.println(temp.getName());
		}

		
		// *** [File f].listFiles() -  ���� ������ ��ü ����&������ ������� ������
		File[] files=rootDir.listFiles();
		for(File temp : files) {
			//System.out.println(temp); ����&���� �ϳ��� ���+�̸� �������� ���
			if(temp.isFile()) System.out.println(temp.getName());
		}
		
		
		
		//**************************************************************************//
		FilenameFilter file12;
		System.out.println("==================Lamda==================");
		files=rootDir.listFiles((File f12, String name) -> new File(f12,name).isFile());
		for(File temp : files) {
			System.out.println(temp.getName());
		}
		
		files=rootDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir,name).isFile();
			}
		});
		
	}
	
	public static void createFile() {
		File dir=new File("test");
		dir.mkdir();
		File f = new File(dir.getName()+"rclass");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}