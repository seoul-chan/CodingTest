package com.kh.hw.memberview;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {	}
	
	public void maintMenu() {
//		mc.init(); //�׽�Ʈ �� �޼���
		
		while(true) {
			System.out.println();
			System.out.println("�ִ� ��� ������ ȸ�� ���� "+mc.SIZE+"�� �Դϴ�.");
			System.out.println("���� ��ϵ� ȸ�� ���� "+mc.existMemberNum()+"�� �Դϴ�.");
			
			System.out.println((mc.existMemberNum()<mc.SIZE)?"1. �� ȸ�� ���":"ȸ�� ���� ��� �� á�� ������ �Ϻ� �޴��� ���µ˴ϴ�.");
			System.out.println("2. ȸ�� �˻�");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ��� ȸ�� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			
			int cho = sc.nextInt();
			
			//��� ȸ���� ��ϵ� ��� 1�� �Է� ��
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
		String id;
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
		char gender;
		while(true) {
			System.out.print("����(M/F) : ");
			gender = sc.next().toUpperCase().charAt(0);
			if(gender=='M'||gender=='F') break;
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
			case 9 : break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
			System.out.println("���̵�\t�̸�\t�н�����\t�̸���\t\t����\t����");
			System.out.println(search);
		}
	}
	
	public void searchName() {
		System.out.println("�˻��� �̸� : ");
		String name = sc.next();
		Member[] search = mc.searchName(name);
		if(search==null) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.println("ã���� ȸ�� ��ȸ ����Դϴ�.");
			System.out.println("���̵�\t�̸�\t�н�����\t�̸���\t\t����\t����");
			
			for(int i=0;i<search.length;i++) {
				if(search[i]!=null)
				System.out.println(search[i]);
			}
		}
	}
	
	public void searchEmail() {
		System.out.println("�˻��� �̸��� : ");
		String email = sc.next();
		Member[] search = mc.searchEmail(email);
		if(search==null) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.println("ã���� ȸ�� ��ȸ ����Դϴ�.");
			System.out.println("���̵�\t�̸�\t�н�����\t�̸���\t\t����\t����");
			
			for(int i=0;i<search.length;i++) {
				if(search[i]!=null)
				System.out.println(search[i]);
			}
		}
	}
	
	public void updateMember() {
		System.out.println("==== ��� ���� ���� ====");
		System.out.println("1. ��й�ȣ �����ϱ�");
		System.out.println("2. �̸� �����ϱ�");
		System.out.println("3. �̸��� �����ϱ�");
		System.out.println("9. �������� ���ư���");
		int cho = sc.nextInt();
		switch(cho) {
			case 1 : updatePassword(); break;
			case 2 : updateName(); break;
			case 3 : updateEmail(); break;
			case 9 : break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void updatePassword() {
		System.out.println("==== ��й�ȣ ���� ====");
		System.out.println("���̵� �Է����ּ��� : ");
		String id = sc.next();
		System.out.println("������ ��й�ȣ�� �Է����ּ��� : ");
		String password = sc.next();
		
		boolean flag = mc.updatePassword(id, password);
		System.out.println(flag?"������ ���������� �Ǿ����ϴ�.":"�������� �ʴ� ���̵��Դϴ�.");
	}
	
	public void updateName() {
		System.out.println("==== �̸� ���� ====");
		System.out.println("���̵� �Է����ּ��� : ");
		String id = sc.next();
		System.out.println("������ �̸� �Է����ּ��� : ");
		String name = sc.next();
		
		boolean flag = mc.updateName(id, name);
		System.out.println(flag?"������ ���������� �Ǿ����ϴ�.":"�������� �ʴ� ���̵��Դϴ�.");
	}
	
	public void updateEmail() {
		System.out.println("==== �̸��� ���� ====");
		System.out.println("���̵� �Է����ּ��� : ");
		String id = sc.next();
		System.out.println("�̸����� �Է����ּ��� : ");
		String email = sc.next();
		
		boolean flag = mc.updateEmail(id, email);
		System.out.println(flag?"������ ���������� �Ǿ����ϴ�.":"�������� �ʴ� ���̵��Դϴ�.");
	}
	
	public void deleteMember() {
		System.out.println("==== ȸ�� ���� ���� ====");
		System.out.println("1. Ư�� ȸ�� �����ϱ�");
		System.out.println("2. ��� ȸ�� �����ϱ�");
		
		int cho = sc.nextInt();
		switch(cho) {
			case 1 : deleteOne(); break;
			case 2 : deleteAll(); break;
			default :  System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void deleteOne() {
		System.out.println("==== ȸ�� ���� ���� ====");
		System.out.println("������ ȸ���� id�� �Է����ּ��� : ");
		String id = sc.next();
		System.out.print("���� ���� �Ͻðڽ��ϱ�?(Y/N) : ");
		String cho = sc.next();
		
		if(cho.equals("Y")||cho.equals("y")) {
			boolean flag = mc.delete(id);
			System.out.println(flag?"���������� �����Ͽ����ϴ�.":"�������� �ʴ� ���̵��Դϴ�.");
		}
	}
	
	public void deleteAll() {
		System.out.println("==== ��� ȸ�� ���� ���� ====");
		System.out.print("��� ȸ���� ���� �Ͻðڽ��ϱ�?(Y/N) : ");
		String cho = sc.next();
		if(cho.equals("Y")||cho.equals("y")) {
			mc.delete();
			System.out.println("���������� �����Ͽ����ϴ�.");
		}
	}
	
	public void printAll() {
		System.out.println("==== ��� ȸ�� ��� =====");
		System.out.println("���̵�\t�̸�\t�н�����\t�̸���\t\t����\t����");
		Member[] mem = mc.printAll();
		
		if(mem==null) {
			System.out.println("����� ȸ���� �����ϴ�.");
			return;
		}
		
		for(int i=0;i<mem.length;i++) {
			if(mem[i]!=null)
			System.out.println(mem[i].inform());
		}
			
	}
}
