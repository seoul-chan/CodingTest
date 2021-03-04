package com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	
	public static void main(String[] args) {
		
		/*
		 * Properties Ȱ���ϱ�
		 * key, value �������� ����ǳ�
		 * key,value ������ Map�� ����ϳ� String �������� �����Ѵ�.
		 * setProperty(key,value) : ������ ����
		 * ������ ������ �Ǳ⿡ �ַ� ȯ�漳���� ���� ���䤷.���� ���, ��ƮƮ���� ����
		 */
		
		Properties prop=new Properties();
		prop.setProperty("email", "prince0324@naver.com");
		prop.setProperty("domain", "www.iei.or.kr");
		
		String v = prop.getProperty("email");
		System.out.println(v);
		
		/*
		 * ���ϰ� �����ؼ� ó������
		 * Ư�����Ͽ� properties��ü�� ������ �ִ� ������ �����ϴ� �޼ҵ带 �������ִ�.
		 * properties, xml ����
		 * store( ) : �Ϲ� ����
		 * storeToXML : xml������ ���Ϸ� ����
		 * 
		 */
		
		try {
			prop.store(new FileOutputStream("test.properties"),"myinfo"); //store(���� ��Ʈ��, �ּ�)
			prop.storeToXML(new FileOutputStream("txt.xml"), "");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// properties�ܺ����ϰ� �ս��� ������ �Ǳ� ������...
		// �ַ� ȯ�漳���� ���� ����, ��������, ����Ʈ���� ����...
		
		//�ܺο��� ������ ���ϵ� �ҷ��� �� ����
		loadProperty();

		
	}
	
	public static void loadProperty() {
		Properties prop=new Properties();
		//�ܺ����Ͽ� ������ �ҷ������� 
		//load() �żҵ带 �̿���
		try {
			prop.load(new FileInputStream("testData.properties"));
			
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			
			//xml���� �ҷ�����
			prop.loadFromXML(new FileInputStream("test.xml"));
			System.out.println(prop.getProperty("domain"));
			
			prop.list(System.out);//properties���� ��ü�� �ѹ��� Ȯ���Ҷ� ���
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
