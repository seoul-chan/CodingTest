package com.test;

import java.util.Scanner;

public class Main {
	//2775��
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();	//Ƚ��

		int[][] arr=new int[15][15];
		for(int i=1;i<15;i++) {	//�� �� 1ȣ, 0�� �ʱ�ȭ
			arr[i][1]=1;
			arr[0][i]=i;
		}
		
		for(int i=1;i<15;i++) { //��� ȣ�� �ʱ�ȭ
			for(int j=1;j<15;j++) {
				arr[i][j]=arr[i][j-1]+arr[i-1][j];
			}
		}
		
		for(int i=0;i<t;i++) {
			int k=sc.nextInt();	//����
			int n=sc.nextInt();	//ȣ��
			System.out.println(arr[k][n]);
		}
	}	
}