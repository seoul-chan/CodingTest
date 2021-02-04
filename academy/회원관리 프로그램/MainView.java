package com.member.model.view;

import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MainView {
	public void mainMenu(MemberController memc) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== ȸ������ ���α׷� ====");
			System.out.println("1. ��üȸ�� ��ȸ");
			System.out.println("2. ȸ�� ���");
			System.out.println("3. ���̵�� ȸ�� ��ȸ");
			System.out.println("4. �̸����� ȸ�� ��ȸ");
			System.out.println("5. ȸ�� ���� ����");
			System.out.println("6. ȸ�� ���� ����");
			System.out.println("0. ���α׷� ����");
			
			int cho = sc.nextInt();
			switch(cho) {
				case 1 : memc.serchAll(); break;
				case 2 : memc.insertMember(); break;
				case 3 : memc.serchId(); break;
				case 4 : memc.serchName(); break;
				case 5 : memc.updateMember(); break;
				case 6 : memc.removeMember(); break;
				case 0 : return;
			}
		}
	}
	
	public void memberList(String msg) {
		System.out.println("\n============================================");
		System.out.println("ȸ����ȣ\t�̸�\t����\t����\t�ּ�\t���̵�\t�н�����");
		System.out.print(msg);
		System.out.println("\n============================================\n");
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
	
	public Member updateMember() {
		Scanner sc = new Scanner(System.in);
		Member mem = new Member();
		
		System.out.println("==== ȸ������ ���� �޴� ====");
		System.out.print("������ ���ϴ� ȸ���� �̸��� �Է��ϼ��� : ");
		mem.setName(sc.next());
		
		while(true) {
		System.out.println("������ ���ϴ� �׸��� �Է��ϼ���. ");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. �ּ�");
		System.out.println("4. ���̵�");
		System.out.println("5. �н�����");
		System.out.println("0. ���� ����");
		int cho = sc.nextInt();
		
			switch(cho) {
				case 1 :System.out.print("������ �Է��ϼ��� : ");
						mem.setAge(sc.nextInt()); break;
				case 2 :System.out.print("������ �Է��ϼ��� : ");
						mem.setGender(sc.next().charAt(0)); break;
				case 3 :System.out.print("�ּҸ� �Է��ϼ��� : ");
						mem.setAddress(sc.next()); break; 
				case 4 :System.out.print("���̵� �Է��ϼ��� : ");
						mem.setId(sc.next());break; 
				case 5 :System.out.print("��й�ȣ�� �Է��ϼ��� : ");
						mem.setPw(sc.nextInt());break;
				case 0 : return mem;
			}
		}

	}
	
	public Member removeMember() {
		Scanner sc = new Scanner(System.in);
		Member mem = new Member();
		
		System.out.println("==== ȸ������ ���� �޴� ====");
		System.out.print("ȸ����ȣ�� �Է��ϼ��� : ");
		mem.setMemberNo(sc.nextInt());
		System.out.print("�̸��� �Է��ϼ��� : ");
		mem.setName(sc.next());
		
//		System.out.print("������ �Է��ϼ��� : ");
//		mem.setAge(sc.nextInt());
//		System.out.print("������ �Է��ϼ��� : ");
//		mem.setGender(sc.next().charAt(0));
//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		mem.setAddress(sc.next());
//		System.out.print("���̵� �Է��ϼ��� : ");
//		mem.setId(sc.next());
//		System.out.print("��й�ȣ�� �Է��ϼ��� : ");
//		mem.setPw(sc.nextInt());
		
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
