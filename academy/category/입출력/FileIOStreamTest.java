package com.io.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.io.model.vo.Person;

public class FileIOStreamTest {
	/*
	 * FileStream�� ���� ���� �� �̹� ������ ������ �ִ� ��� ����⸦ �Ѵ�. 
	 * FileOutputFile("secretLamda",true); �� �ۼ��ϸ� ���� ���Ͽ� �̾ �ۼ��� �����ϴ�.
	 * Stream�� ��� �� �ݵ�� ��ȯ�ؾ� �Ѵ� -> close()�޼ҵ带 ���
	 * FileStream �����ڿ� ���� ������ �־� �ݵ�� ����ó���� ����� �� -> try ~ catch��
	 * close() ���� ���� ������ �־� ���� ó���� ����� �Ѵ�.
	*/
	
	
	// *** OutputStream -> FileOutputStream
	public void saveFile() {		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("secretLamda"); //���� �̸�
			String msg = "lamda fight 123"; //���� ����

			//write() �޼ҵ带 �̿��ؼ� ������ ����
			//byte���� ����̱⿡ �Ϲ� ���ڿ��� �ٷ� ����� �� ����.
			out.write((msg+"\n").getBytes());
			out.write("abced\n".getBytes());
			out.write("�ѱ۵� ����\n".getBytes()); //�˾Ƽ� 2byte�� �����⿡ �ѱ۵� �����ϴ�.
			
			/*����Ʈ �迭�� �޾� ó�� ���
			 byte[] data = msg.getBytes();
			 out.write(data);
			*/
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	// *** InputStream -> FileInputStream
	/*
	 * ���Ͽ� �ִ� �����͸� �����ö� read()�޼ҵ带 �̿��Ѵ�. ���� �����͸� ������ �� byte�� �������� ��ȯ�� int�� �Ѵ�.
	 * inputStream���� ���Ͽ� ����� ������ ���̻� ������ ���� ������ -1�� ��ȯ�Ѵ�.
	 * */
	public void loadFile() {
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream("secretLamda"); //���� �̸�

			int data = -1; //������ byte �����͸� �����ϴ� ����
			while((data=fis.read())!=-1) { //������ ������ ���� ��� ����
				//����Ʈ ���� ���� char�� ����ȯ�Ͽ� �ֿܼ� ���ڷ� ��µǵ��� �Ѵ�.(�׷��� �ѱ��� ������ ���δ�.)
				System.out.println((char)data); 

				byte[] temp = new byte[(int)new File("secretLamda").length()];
				fis.read(temp);		//�˾Ƽ� byte�迭�� �����͸� �ִ´�.
				String data1 = new String(temp);
				System.out.println(data1);
			}	
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	// *** ����ó�� ����� ��Ʈ�� - Reader / Writer
	// *** Writer -> FileWriter
	public void strSaveFile() {
		// try-with-resource�� �����Ͽ� �ڵ� close() ����
		try(FileWriter out = new FileWriter("strData")){ //���� �̸�		
			
			String str = "������ ����� ";
			out.write(str);
			out.write("�߿� �����");			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// *** Reader -> FileReader
	public void strLoadFile() {
		try(FileReader fr = new FileReader("strData")){
			
			int data=-1;
			String msg="";
			while((data=fr.read())!=-1) {
				msg+=(char)data; //�� ���ھ� ���ڿ��� �߰�
			}
			System.out.println(msg);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * ������ �޸��� �����
	 * Ŭ���̾�Ʈ���� ���� �Է� ������ �Է� ���� ���� ������ �����ϰ� exit��� �Է��ϸ� ���Ͽ� ����
	 * (exit�Է� �������� ��� �Է��� ����)   
	 */
	public void strWriter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== �޸��� ====");
		System.out.println("������ ���� �Է��� �ּ���. ���Ḧ ���Ͻø� exit�� �Է����ּ���.");
		String total="";
		
		while(true) {
			String temp=sc.nextLine();
			if(temp.equals("exit")) break;
			total+="\n"+temp;
		}
		
		System.out.print("������ ���ϸ��� �Է��� �ּ��� : ");
		String fileName = sc.next(); 
		
		try(FileWriter out = new FileWriter(fileName)){
			out.write(total);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void strReader() {
		String path = FileIOStreamTest.class.getResource("/").getPath(); //bin ��� ���� 
		path = path.substring(0,path.lastIndexOf("bin")); //���ڿ��� �߶� bin������ ��� ����
		File f= new File(path);
		String[] fileList=f.list();
		
		System.out.println("==== ����� �޸��� ��� ====");
		for(String name:fileList) {
			if(name.contains(".bs")) {	//Ȯ���ڰ� .bs�� ���� ���
				System.out.println(name);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ҷ��� ���ϸ� : ");
		try(FileReader fr = new FileReader(sc.nextLine())){
			int data=-1;
			String msg="";
			
			while((data=fr.read())!=-1) {
				msg+=(char)data;
			}
			System.out.println(msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// ***�����͸� ���Ϸ� ����
	public void dataSave() {
		Person[] person = new Person[3];
		person[0] = new Person("�����1",19,'��',180.5);
		person[1] = new Person("�����2",29,'��',189.5);
		person[2] = new Person("�����3",39,'��',185.5);
		
		try(FileWriter out = new FileWriter("person.dat")){
			for(Person p : person) {
				out.write(p.getName()+",");
				out.write(String.valueOf(p.getAge())+",");
				out.write(p.getGender()+",");
				out.write(String.valueOf(p.getHeight())+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dataLoad() {
		try(FileReader fr = new FileReader("person.dat")){
			int data=-1;
			String person="";

			while((data=fr.read())!=-1) {
				person+=(char)data;
			}
			System.out.println(person);
			String[] strPersons = person.split("\n");
			Person[] persons = new Person[3]; //���� �����͸� ��ü�� ����
			
			for(int i=0;i<persons.length;i++) {
				String[] temp = strPersons[i].split(",");
				persons[i] = new Person(temp[0],Integer.parseInt(temp[1]),temp[2].charAt(0),Double.valueOf(temp[3]));
			}	
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

	
	
	
	
}

