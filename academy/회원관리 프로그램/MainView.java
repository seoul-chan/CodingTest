package com.member.model.view;

import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MainView {
	public void mainMenu(MemberController mem) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== ȸ������ ���α׷� ====");
			System.out.println("1. ��üȸ�� ��ȸ");
			System.out.println("2. ȸ�� ���");
			System.out.println("3. ���̵�� ȸ�� ��ȸ");
			System.out.println("4. �̸����� ȸ�� ��ȸ");
			System.out.println("0. ���α׷� ����");
			
			int cho = sc.nextInt();
			switch(cho) {
				case 1 : mem.serchAll(); break;
				case 2 : mem.insertMember(); break;
				case 3 : mem.serchId(); break;
				case 4 : mem.serchName(); break;
				case 0 : return;
			}
		}
	}
	
	public void resultPrint(String msg) {
		System.out.println("\n============================================");
		System.out.print(msg);
		System.out.println("\n============================================\n");
	}
	
	public Member insetMember() {
		Scanner sc = new Scanner(System.in);
		Member mem = new Member();
		
		System.out.println("==== ȸ�� ��� �޴� ====");
		System.out.print("�̸��� �Է��ϼ��� : ");
		mem.setName(sc.next());
		System.out.print("������ �Է��ϼ��� : ");
		mem.setAge(sc.nextInt());
		System.out.print("������ �Է��ϼ��� : ");
		mem.setGender(sc.next().charAt(0));
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		mem.setAddress(sc.next());
		System.out.print("���̵� �Է��ϼ��� : ");
		mem.setId(sc.next());
		System.out.print("��й�ȣ�� �Է��ϼ��� : ");
		mem.setPw(sc.nextInt());
		
		return mem;
	}
	public String serchId() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== ID ��ȸ �޴� ====");
		System.out.print("���̵� �Է��ϼ��� : ");
		return sc.next();
	}
	public String serchName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== �̸� ��ȸ �޴� ====");
		System.out.print("�̸��� �Է��ϼ��� : ");
		return sc.next();
	}
	
}
