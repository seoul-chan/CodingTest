package com.kh.practice.set.view;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		System.out.println("============= KH ��÷ ���α׷� =============");
		
		while(true) {
			try {
				System.out.println("****** ���� �޴� ******");
				System.out.println("1. ��÷ ��� �߰�");
				System.out.println("2. ��÷ ��� ����");
				System.out.println("3. ��÷ ��� Ȯ��");
				System.out.println("4. ���ĵ� ��÷ ��� Ȯ��");
				System.out.println("5. ��÷ ��� �˻�");
				System.out.println("9. ����");
				System.out.print("�޴� ��ȣ ���� : ");
				
				switch(sc.nextInt()) {
					case 1 : insertObject(); break;
					case 2 : deleteObject(); break;
					case 3 : winObject(); break;
					case 4 : sortedWinObject(); break;
					case 5 : searchWinner(); break;
					case 9 : System.out.println("���α׷� ����"); return;
					default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}	
			}catch(InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine();
			}
		}
	}
	
	public void insertObject() {
		System.out.println("\n==== ��÷ ��� �߰� ====");
		System.out.print("��÷�� ��÷ ��� ���� �Է��ϼ��� : ");
		int count = sc.nextInt();
		for(int i=1;i<=count;i++) {
			while(true) {
				System.out.print("������ �̸��� �Է��ϼ���"+"("+i+"��°) : ");
				String name = sc.next();
				System.out.print("������ �ڵ��� ��ȣ�� �Է��ϼ��� : ");
				String phone = sc.next();
				
				boolean flag = lc.insertObject(new Lottery(name,phone));
				
				if(flag) {
					System.out.println("�߰� �Ϸ�Ǿ����ϴ�."); 
					break;
				} else {
					System.out.println("�ߺ��� ����Դϴ�. �ٽ� �Է����ּ���.");
				}				
			}//while
		}//for
	}
	
	public void deleteObject() {
		System.out.println("\n==== ��÷ ��� ���� ====");
		System.out.print("������ �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.print("������ �ڵ��� ��ȣ�� �Է��ϼ��� : ");
		String phone = sc.next();
		
		boolean flag = lc.deleteObject(new Lottery(name, phone));
		System.out.println(flag?"���� �Ϸ� �Ǿ����ϴ�.":"�������� �ʴ� ����Դϴ�.");		
	}
	
	public void winObject() {
		System.out.println("\n==== ��÷ ��� Ȯ�� ====");
		System.out.println(lc.winObject());
	}
	
	public void sortedWinObject() {
		System.out.println("\n==== ���ĵ� ��÷ ��� Ȯ�� ====");
		Set<Lottery> set = lc.sortedWinObject();
		Iterator<Lottery> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
	
	public void searchWinner() {
		System.out.println("\n==== ��÷ ��� �˻� ====");
		System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.print("�˻��� �ڵ��� ��ȣ�� �Է��ϼ��� : ");
		String phone = sc.next();
		
		boolean flag = lc.searchWinner(new Lottery(name, phone));
		
		System.out.println(flag?"�����մϴ�. ��÷ ��Ͽ� �����մϴ�.":"��Ÿ������ ��÷ ��Ͽ� �������� �ʽ��ϴ�.");		
	}
}