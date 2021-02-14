package com.kh.practice.chap01_poly.model.view;

import java.util.Scanner;

import com.kh.practice.chap01_poly.model.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.*;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		System.out.print("������ �Է��ϼ���(M/F) : ");
		char gender = sc.next().charAt(0);
		
		Member mem = new Member(name,age,gender);
		lc.insertMember(mem);
		while(true) {
			System.out.println("==== �޴� ====");
			System.out.println("1. ����������");
			System.out.println("2. ���� ��ü ��ȸ");
			System.out.println("3. ���� �˻�");
			System.out.println("4. ���� �뿩�ϱ�");
			System.out.println("9. ���α׷� �����ϱ�");
			System.out.println("�޴� ��ȣ");
			
			int cho = sc.nextInt();		
			switch(cho) {
				case 1 : lc.myinfo(); break;
				case 2 : selectAll(); break;
				case 3 : searchBook(); break;
				case 4 : rentBook(); break;
				case 9 : return;
				default : System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
	}
	
	public void selectAll() {
		Book[] bList = lc.selectAll();
		
		for(int i=0;i<bList.length;i++)
			System.out.println(i+"�� ���� : "+bList[i]);
	}
	
	public void searchBook() {
		System.out.print("�˻��� å �̸��� �Է����ּ��� : ");
		Book[] searchList = lc.searchBook(sc.next());
		
		for(int i=0;i<searchList.length;i++)
			System.out.println(i+"�� ���� : "+searchList[i]);
	}
	
	public void rentBook() {
		System.out.println("���� ��� �Դϴ�.");
		selectAll();
		
		System.out.print("�뿩�� ���� ��ȣ�� ���� : ");
		int result = lc.rentBook(sc.nextInt());
		
		switch(result) {
			case 0 : System.out.println("���������� �뿩�Ǿ����ϴ�.");
			case 1 : System.out.println("���� �������� �뿩 �Ұ����Դϴ�.");
			case 2 : System.out.println("���������� �뿩�Ǿ����ϴ�. �丮�п� ������ �߱޵Ǿ����� ����"
					+ "���������� Ȯ���ϼ���");
		}
	}
	
}
