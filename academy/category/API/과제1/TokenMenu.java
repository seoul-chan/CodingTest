package com.kh.practice.token.view.TokenMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.token.controller.TokenController;

public class TokenMenu {
	private Scanner sc = new Scanner(System.in);
	private TokenController tc = new TokenController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("1.���� ���ڿ�");
			System.out.println("2.�Է� ���ڿ�");
			System.out.println("3.���α׷� ������");
			System.out.print("�Է� : ");

			try {		
				switch(sc.nextInt()) {
				case 1 : tokenMenu(); break;
				case 2 : inputMenu(); break;
				case 3 : System.out.println("���α׷��� �����մϴ�."); return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				}
			}catch(InputMismatchException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine();
				continue;
			}
		}	
	}
	
	public void tokenMenu() {
		String str = "J a v a P r o g r a m";
		String aferStr = tc.afterToken(str);
		System.out.println("��ū ó�� �� ���� : "+str);
		System.out.println("��ū ó�� �� ���� : " + str.length());
		System.out.println("��ū ó�� �� ���� : "+aferStr);
		System.out.println("��ū ó�� �� ���� : "+aferStr.length());
	}
	
	public void inputMenu() {
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String firstUpper = tc.firstCap(sc.next());  
		System.out.println("ù ���� �빮�� : " + firstUpper);
		System.out.println("ã�� ���ڸ� �ϳ� �Է��ϼ��� : ");
		char input = sc.next().charAt(0);
		System.out.println(input+" ���ڰ� �� ���� : "+tc.findChar(firstUpper, input));	
	}
}
