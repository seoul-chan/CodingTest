package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy {
	public static void main(String[] args) {
		/*
		 * ū ���� ��Ģ
		 * n : �迭�� ũ��
		 * m : ���ڰ� �������� �� Ƚ��
		 * k : ū ���ڰ� �������� Ƚ��
		 * �迭�� ũ�⸸ŭ ���ڰ� �־����� ���� �� ���� ū ���ڸ� m����ŭ �����ش�.
		 * ��, �ѹ��� ���Ҽ� �ִ� Ƚ���� k���̸�
		 * k����ŭ ������ ��� �� ��° ū ���ڸ� ���� �� �ٽ� ���� ū ���ڸ� ���Ҽ� �ִ�.
		 */
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt();	
		int[] arr=new int[n];
		int sum=0;
		
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);		
		for(int i=0;i<m;i++) {
			for(int j=0;j<k;j++) {
				sum+=arr[n-1];
				i++;
			}
			sum+=arr[n-2];
		}
		System.out.println(sum);
	}
	
	
	/*
	
	
	
	public static void main(String[] args) {
		// ���� �Ž��� �ֱ�
		int n = 1260;	//�Ž�����
		int count=0;
		
		int[] coint_type = new int[] {500,100,50,10};
		for(int i : coint_type) {
			count=count+(n/i);
			n%=i;
		}
		System.out.println(count);
	}
	
	*/
}
