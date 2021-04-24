package com.semi.baseball;

import java.util.Scanner;

public class BaseballGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] random= new String[4];
		
		//�ߺ� ���� ���� �� ����
		for(int i=0;i<4;i++) {
			random[i]=String.valueOf((int)(Math.random()*9+1));
			for(int j=0;j<i;j++) {
				if(random[i].equals(random[j])) i--;
			}
//			System.out.print(random[i]+" ");  �ּ� ���� �� ��ǻ�� �Է� �� Ȯ��
		}
		
		System.out.println("==== ���� �߱����� ====");

		while(true) {
			int strike=0,ball=0;
			System.out.print("���ڸ� �Է����ּ���(4�ڸ�) : ");
			String[] input = sc.next().split("");	//����� �Է�

			boolean b =false;
			for(int i=0;i<4;i++) {	//�ߺ� ���� �Է� Ȯ��
				for(int j=0;j<i;j++) {
					if(input[i].equals(input[j])) {
						b=true;
					}
				}
			}
			if(b) {
				System.out.println("�ߺ� �Էµ� ���ڰ� �ֽ��ϴ�.");
				System.out.println("�ٽ� �Է��� �ּ���.");
				continue;
			}
			
			//��Ʈ����ũ
			for(int i=0;i<4;i++) {
				if(input[i].equals(random[i])) {
					strike++;
					input[i]="0";
				}
			}
			//��
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(input[i].equals(random[j])) {
						ball++;
					}
				}
			}
			System.out.println("strike : "+strike+", ball : "+ball+"\n");
			if(strike==4) break;
		}
	}
}
