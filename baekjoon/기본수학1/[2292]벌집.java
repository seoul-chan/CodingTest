package com.test;

import java.util.Scanner;

public class Main {
	//2292�� ����
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();	// �� ��° ��
		int count=1, sum=1;	//������, ������ ��
		while(n>sum) {		// ���� �� �պ��� n�� ������ �ݺ��� ����
			sum+=6*count;	//6����� ���� �� ������ ��
			count++;
		}
		System.out.println(count);
	}	
}