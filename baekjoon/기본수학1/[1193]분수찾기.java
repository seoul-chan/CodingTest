package com.test;

import java.util.Scanner;

public class Main {
	//1193��
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();	// �� ��° ��
		int prev_sum=0, cur=1;	// ���� ���� ������ ��, ���� ���� ����
		while(true) {
			if(x<=prev_sum+cur) {	//����,���� ���� ������ �Է� ������ ū ���
				if(cur%2==1) {
					System.out.println((cur+1-(x-prev_sum))+"/"+(x-prev_sum));
					break;
				}else {
					System.out.println((x-prev_sum)+"/"+(cur+1-(x-prev_sum)));
					break;
				}
			}else {	//����,���� ���� ������ �Է� ������ ���� ���
				prev_sum+=cur;	// ���� ���� �� + ���� ���� ����
				cur++;	// ���� ���� ���� ����
			}
		}
	}	
}