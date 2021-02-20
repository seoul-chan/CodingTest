package com.io.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Scanner;

import com.io.model.vo.Person;

public class FileSubStreamTest {
	
	//���꽺Ʈ���� �̿��غ���.
	//�⺻ ��Ʈ���� �Ű������� ����Ͽ� ���� ��Ʈ�� ����(������Ʈ���� �����ؼ��� ����� ���� ����)
	
	
	// *** BufferedWriter
	/* 
	 * BufferedReader, BufferedWriter�� ����� ������ ����� �������� ����Ѵ�.
	 * OutputStreamWriter : byte���� �����͸� ���ڿ��� ��ȯ�Ͽ� ���� (���� ��Ʈ��)
	 * OutputStreamWriter�� ��� ��Ʈ��(System.out -> PrintStream)�� �ֱ⿡ �̷� �����ε� ����� �����ϴ�.
	 * System.out�� ���ڰ����� �־� write()�� �Է��� ���� ���Ϸ� ����Ǵ� ���� �ƴ� �ݼֿ� ��µȴ�.
	 */
	public void stringChangeOutPut() {
		BufferedWriter fw =null;
		try {//try-with-resource�� ����
			fw = new BufferedWriter(new OutputStreamWriter(System.out)); 
			fw.write("���ڿ� ����");
			fw.flush(); //���ۿ� ����� �������ν� ������ ������ �ѹ��� ���� -> ������� ȭ�� ���
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	
	// *** BufferedReader
	/*
	 * fileStream : Ű����� �����͸� �޾ƿ��� �������� Scanner�� ����� ����ϳ� ���ڿ� ���常 �����ϴ�. 
	 */
	
	public void stringChangeInput() {
		BufferedReader br =null;
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("�Է� : ");
			String data=br.readLine(); //Ű����� �Է°��� ����(���ڿ�)
			System.out.println(data);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// *** BufferedWriter <-> FileWriter
	public void bufferedWriterTest() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("sample.txt"));){ //���Ϸ� ����
			bw.write("������ ����� \n");
			bw.write("������ �ݿ��� \n");
			bw.write("������ ����� \n");
			bw.write("������ �Ͽ��� \n");
			bw.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// *** BufferedReader <-> FileReader
	public void bufferedReaderTest() {
		try(BufferedReader br = new BufferedReader(new FileReader("sample.txt"))){
			
			String data="";
			while((data=br.readLine())!=null) {
				System.out.println(data);
			}			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	


	
	// ***DataOutputStream : �������� �ڷ����� ������ ���·� ���Ͽ� ����
	// DataOutputStream <-> FileOutputStream
	public void dataOutputStreamTest() {
		Scanner sc = new Scanner(System.in);
		try(DataOutputStream dis = new DataOutputStream(new FileOutputStream("member.dat"))){
			System.out.print("���̵� : ");
			dis.writeUTF(sc.nextLine());//���ڿ� Ÿ�� ����
			System.out.print("�н����� : ");
			dis.writeUTF(sc.nextLine());
			System.out.print("���� : ");
			dis.writeChar(sc.next().charAt(0));
			System.out.print("���� : ");
			dis.writeInt(sc.nextInt());
			System.out.print("Ű : ");
			dis.writeDouble(sc.nextDouble());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// ***DataInputStream : �ڷ����� ������ ���·� ������
	/* 
	 * DataInputStream <-> FileInputStream
	 * �ڷḦ �ҷ��� �� ���� �������� �ҷ��� �ڷ����� ������ ������ ���� ������ �о�;� �Ѵ�. 
	 * dataOutputStreamTest()���� UTF -> UTF -> Char -> Int -> Double ������ �ڷḦ �����ߴ�.  
	 * ������ ���� ������ EOFException �߻��ϱ⿡ �ݵ�� �Է��ߴ� ������ ������� �Ѵ�.
	 */
	public void dataInputStreamTest() {
		try(DataInputStream dis = new DataInputStream(new FileInputStream("member.dat"))){
			String id = dis.readUTF();
			String pw = dis.readUTF();
			char gender = dis.readChar();
			int age = dis.readInt();
			double height = dis.readDouble();
			
			System.out.println(id+pw+gender+age+height);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Person 3���� �Է¹޾� person.dat�� �����ϰ� ����� �����͸� Person�迭�� �����Ͽ� ����ϱ�
	public void personOutputStream() {
		Scanner sc = new Scanner(System.in);
		
		try(DataOutputStream dis = new DataOutputStream(new FileOutputStream("person.dat"))){
			for(int i=0;i<3;i++) {
				System.out.println("==== ("+ (i+1)+"/3)�Է� ====");
				System.out.print("�̸� : ");
				String name=sc.next();
				System.out.print("���� : ");
				int age=sc.nextInt();
				System.out.print("���� : ");
				char gender=sc.next().charAt(0);
				System.out.print("Ű : ");
				double height = sc.nextDouble();
				
				dis.writeUTF(name);
				dis.writeInt(age);
				dis.writeChar(gender);
				dis.writeDouble(height);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void personInputStream() {
		try(DataInputStream dis = new DataInputStream(new FileInputStream("person.dat"))){
			Person[] persons=new Person[3];
			
			for(int i=0;i<persons.length;i++) {	
				persons[i]=new Person();
				persons[i].setName(dis.readUTF());
				persons[i].setAge(dis.readInt());
				persons[i].setGender(dis.readChar());
				persons[i].setHeight(dis.readDouble());	
			}
			for(Person p : persons) {
				System.out.println(p);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// ***ObjectOutputStream
	//Person Ŭ�������� implements Serializable �߰��Ͽ� ����ȭ ó���� �����ϰ� �Ѵ�.
	//�߰� �������� ��� NotSerializableException ���ܰ� �߻��Ѵ�.
	public void objectOutPutStreamTest() {
		//������ ��ü�� �ѹ��� �����ϱ�.
		Person p =new Person("�����",19,'��',180.5);
		
		Person[] persons = new Person[3]; 
		persons[0] =new Person("�����",19,'��',180.5);
		persons[1] =new Person("�����",20,'��',180.5);
		persons[2] =new Person("�����",26,'��',180.5);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.dat"))) {
//			for(int i=0;i<persons.length;i++) {
//				oos.writeObject(persons[i]);
//			}
			oos.writeObject(persons); // for�� ���� ��ü �ּ� �� ��°�� �� �� �ִ�.(������)
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// ***ObjectInputStream
	public void objectInputStreamTest() {
//		Person p=null;
		Person[] persons = new Person[3];
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.dat"))){
//			p = (Person)ois.readObject(); //�ҷ��� ��ü ���Ͽ� ������ ��ü�� ���� ���� �ֱ⿡ ClassNotFoundException���� ó���� ���־�� �Ѵ�.
			
//			for(int i=0;i<persons.length;i++) {
//				persons[i] = (Person)ois.readObject();
//			}
			persons = (Person[])ois.readObject();
			
			for(Person p : persons) {
				if(p.getAge()==26)
					System.out.println(p);
			}
				
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
