package com.test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		int cycle=0,sum=input;
		
		while(true) {
			//(sum%10)*10 : ���� ���� �� ������ �ι�° ����
			//((sum/10)+(sum%10))%10 : ���� �հ��� 1�� �ڸ�
			sum=(sum%10)*10 + ((sum/10)+(sum%10))%10;
			cycle++;
			if(sum==input) break;
		}
		System.out.println(cycle);
	}	
}

/*
public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		int a=input/10,b=input%10,cycle=0;
		int sum,temp;
		
		while(true) {
			temp=a+b;
			a=b;
			b=temp%10;
			sum=a*10+b;
			cycle++;
			if(sum==input) break;
		}
		System.out.println(cycle);
	}	
}
*/