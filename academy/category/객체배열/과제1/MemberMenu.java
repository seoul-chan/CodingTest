package com.kh.hw.memberview;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {	}
	
	public void maintMenu() {
		
		while(true) {
			System.out.println();
			System.out.println("�ִ� ��� ������ ȸ�� ���� "+mc.SIZE+"�� �Դϴ�.");
			System.out.println("���� ��ϵ� ȸ�� ���� "+mc.existMemberNum()+"�� �Դϴ�.");
			
			System.out.println((mc.existMemberNum()<mc.SIZE)?"1. �� ȸ�� ���":"ȸ�� ���� ��� �� á�� ������ �Ϻ� �޴��� ���µ˴ϴ�.");
			System.out.println("2. ȸ�� �˻�");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ��� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			
			int cho = sc.nextInt();
			if(mc.existMemberNum()>=mc.SIZE&&cho==1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			switch(cho) {
				case 1 : insertMember(); break;
				case 2 : searchMember(); break;
				case 3 : updateMember(); break;
				case 4 : deleteMember(); break;
				case 5 : printAll(); break;
				case 9 : System.out.println("���α׷��� �����մϴ�."); return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}				
	}
	
	public void insertMember() {
		String id;			// �����ϱ�##############
		while(true) {
			System.out.print("���̵� : ");
			id = sc.next();
			if(mc.checkId(id)) break;
			System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
		}		
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("��й�ȣ : ");
		String password = sc.next();
		System.out.print("�̸��� : ");
		String email = sc.next();
		char gender;		// �����ϱ�##############
		while(true) {
			System.out.print("����(M/F) : ");
			gender = sc.next().charAt(0);
			if(gender=='m'||gender=='M'||gender=='f'||gender=='F') break;
			System.out.println("������ �ٽ� �Է��ϼ���.");
		}
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		mc.insertMember(id, name, password, email, gender, age);
	}
	
	public void searchMember() {
		System.out.println("1. ���̵�� �˻��ϱ�");
		System.out.println("2. �̸����� �˻��ϱ�");
		System.out.println("3. �̸��Ϸ� �˻��ϱ�");
		System.out.println("9. �������� ���ư���");
		int cho = sc.nextInt();
		switch(cho) {
			case 1 : searchId(); break;
			case 2 : searchName(); break;
			case 3 : searchEmail(); break;
			case 9 : maintMenu(); break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�."); maintMenu();
		}
	}
	
	public void searchId() {
		System.out.println("�˻��� ���̵� : ");
		String id = sc.next();
		String search = mc.searchId(id);
		if(search.equals("")) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.println("ã���� ȸ�� ��ȸ ����Դϴ�.");
			System.out.println(search);
		}
	}
	
	public void searchName() {
		System.out.println("�˻��� �̸� : ");
		String name = sc.next();
		Member[] search = mc.searchName(name);
		if(search==null) {	//equals�� ���� ����???
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.println("ã���� ȸ�� ��ȸ ����Դϴ�.");
			
			for(int i=0;i<search.length;i++) {
				if(search[i]!=null)
				System.out.println(search[i]);
			}
		}
	}
	
	public void searchEmail() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void updatePassword() {
		
	}
	
	public void updateName() {
		
	}
	
	public void updateEmail() {
		
	}
	
	public void deleteMember() {
		
	}
	
	public void deleteOne() {
		
	}
	
	public void deleteAll() {
		
	}
	
	public void printAll() {
		System.out.println("==== ��� ��� =====");
		Member[] m = mc.printAll();
		for(int i=0;i<m.length;i++) {
			if(m[i]!=null)
			System.out.println(m[i].inform());
		}
			
	}
}
