package com.test;

import java.util.Scanner;

public class Main {
	//10250��
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int h=sc.nextInt();
			int w=sc.nextInt();
			int n=sc.nextInt();
			if(n%h==0)
				System.out.println(h*100+(n/h));
			else 
				System.out.println(n%h*100+(n/h+1));
		}
	}	
}

/*
	
	//10250��
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int h=sc.nextInt();
			int w=sc.nextInt();
			int n=sc.nextInt();
			if(n%h==0)
				System.out.println(h*100+(n/h));
			else 
				System.out.println(n%h*100+(n/h+1));
		}
	}
	
	//10757��
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		System.out.println(a.add(b));
	}
	
	//1712��
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		long a=sc.nextInt(); // �������
		long b=sc.nextInt();	// �������
		long c=sc.nextInt();	// ��ǰ����
		
		if(b>=c) {
			System.out.println(-1);
			return;
		}		
		System.out.println(a/(c-b)+1);
	}
*/