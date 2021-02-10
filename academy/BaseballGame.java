package com.semi.baseball;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] random= new String[4];
		
		//�ߺ� X
		for(int i=0;i<4;i++) {
			random[i]=String.valueOf((int)(Math.random()*9+1));
			for(int j=0;j<i;j++) {
				if(random[i].equals(random[j])) i--;
			}
		}
		System.out.println(random.toString());

		while(true) {
			int strike=0,ball=0;
			
			System.out.println("==== ���� �߱����� ====");	//����� �Է�
			System.out.print("���ڸ� �Է����ּ���(4�ڸ�) : ");
			String[] input = sc.next().split("");
			String[] copyinput = Arrays.copyOf(input, input.length);
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(input[i]==random[i]) {
						strike++;
						continue;
					} else {
						ball++;
					}
				}
			}
			System.out.println("strike : "+strike+", ball : "+ball+"\n");
			if(strike==4) break;
		}
//		while(true) {
//			int strike=0,ball=0;
//			
//			System.out.println("==== ���� �߱����� ====");	//����� �Է�
//			System.out.print("���ڸ� �Է����ּ���(4�ڸ�) : ");
//			String input = sc.next();
//			for(int i=0;i<4;i++) {
//				for(int j=0;j<4;j++) {
//					if(input.charAt(i)==random.charAt(i)) {
//						strike++;
//						continue;
//					}
//					
//					
//				}
//			}
//			System.out.println("strike : "+strike+", ball : "+ball+"\n");
//			if(strike==4) {
//				System.out.println("�ٽ� �Ͻðڽ��ϱ�? (Y/N)");
//				if(sc.next().equals("N")) break;
//			}
//		}
	}
}
