package com.kh.practice.map.view;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========== KH ����Ʈ ==========");
		while(true) {
			System.out.println("======**** ���θ޴� ****=====");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("3. ���� �̸� ȸ�� ã��");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			
			try {
				switch(sc.nextInt()) {
				case 1 : joinMembership(); break;
				case 2 : login(); break;
				case 3 : sameName(); break;
				case 9 : System.out.println("���α׷� ����"); return;
				default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}
			}catch(InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine();
			}
		}
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("\n ****** ȸ�� �޴� ******");
			System.out.println("1. ��й�ȣ �ٲٱ�");
			System.out.println("2. �̸� �ٲٱ�");
			System.out.println("3. �α׾ƿ�");
			System.out.print("�޴� ��ȣ ���� : ");
			try {
				switch(sc.nextInt()) {
					case 1 : changePassword(); break;
					case 2 : changeName(); break;
					case 3 : System.out.println("�α׾ƿ� �Ǿ����ϴ�."); return;
					default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}
			}catch(InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine();
			}
		}
	}
	
	public void joinMembership() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.next();
			System.out.print("��й�ȣ : ");
			String password = sc.next();
			System.out.print("�̸� : ");
			String name = sc.next();
			
			boolean flag = mc.joinMembership(id, new Member(password, name));
			if(flag) {
				System.out.println("���������� ȸ�������� �Ϸ��Ͽ����ϴ�.");
				break;
			} else {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			}	
		}
	}
	
	public void login() {
		System.out.print("���̵� : ");
		String id = sc.next();
		System.out.print("��й�ȣ : ");
		String password = sc.next();
		
		String name = mc.login(id, password);
		if(name.equals("")){
			System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
		} else {
			System.out.println(name+"�� ȯ���մϴ�.");
			memberMenu();
		}
	}
	
	public void changePassword() {
		System.out.print("���̵� : ");
		String id = sc.next();
		System.out.print("��й�ȣ : ");
		String oldPw = sc.next();
		System.out.print("������ ��й�ȣ : ");
		String newPw = sc.next();
		
		boolean flag = mc.changePassword(id, oldPw, newPw);
		System.out.println(flag?"��й�ȣ ���濡 �����߽��ϴ�.":"��й�ȣ ���濡 �����߽��ϴ�.");
	}
	
	public void changeName() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.next();
			System.out.print("��й�ȣ : ");
			String password = sc.next();
			
			String name = mc.login(id, password);
			
			if(name.equals("")) {
				System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			} else {
				System.out.println("���� ����Ǿ� �ִ� �̸� : "+name);
				
				System.out.print("������ �̸� : ");
				mc.changeName(id, sc.next());
				System.out.println("�̸� ���濡 �����Ͽ����ϴ�.");
				break;
			}
		}
	}
	
	public void sameName() {
		System.out.print("�̸� : ");
		String name = sc.next();
		
		Set set = mc.sameName(name).entrySet();
		Iterator<Member> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(e.getValue()+"-"+e.getKey());
		}
	}
}
