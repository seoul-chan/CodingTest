package com.kh.practice.numRange.view;

import java.util.Scanner;

import com.kh.practice.numRange.controller.NumberController;
import com.kh.practice.numRange.exception.NumRangeException;

public class NumberMenu {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� 1 : ");
		int num1 = sc.nextInt();
		System.out.print("���� 2 : ");
		int num2 = sc.nextInt();
		
		try {
			boolean flag = new NumberController().checkDouble(num1, num2);
			System.out.println(num1+"��(��) "+num2+"�� ����ΰ� ? "+flag);
		} catch (NumRangeException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
