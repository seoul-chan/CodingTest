package com.semi.rsp_game;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean b;
		System.out.println("===== ���� ���� �� ���� ===== ");
		
		do {	
			System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ��� : ");
			String input = sc.next();
			
			int computer = (int)(Math.random()*3+1); // 1:����, 2:����, 3:��; 
			b=false;
			
			switch(input) {
				case "����" : {
					if(computer==1) {
						System.out.println("�����ϴ�."); 
						b=true; 
					}
					else if(computer==2) System.out.println("�����ϴ�.");
					else System.out.println("�̰���ϴ�."); break;
				}
				case "����" : {
					if(computer==1) System.out.println("�̰���ϴ�.");
					else if(computer==2) {
						System.out.println("�����ϴ�.");
						b=true;
					}
					else System.out.println("�����ϴ�."); break;
				}
				case "��" : {
					if(computer==1) System.out.println("�����ϴ�.");
					else if(computer==2) System.out.println("�̰���ϴ�.");
					else {
						System.out.println("�����ϴ�."); 
						b=true;
						break;
					}
				}
				default : {
					System.out.println("�߸� �Է��Ͽ����ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					b=true;
				}
			}
			
			if(computer==1) System.out.println("��ǻ�� : ����" +  " �� : " + input);
			if(computer==2) System.out.println("��ǻ�� : ����" +  " �� : " + input);
			if(computer==3) System.out.println("��ǻ�� : ��" +  " �� : " + input);
		
		} while(b);
	}
}