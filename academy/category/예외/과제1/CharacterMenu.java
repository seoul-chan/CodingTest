package com.kh.pratice.charCheck.view;

import java.util.Scanner;

import com.kh.pratice.charCheck.controller.CharacterController;
import com.kh.pratice.charCheck.exception.CharCheckException;

public class CharacterMenu {
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("������ ������ Ȯ�� �� ���ڿ��� �Է����ּ��� : " );
			String input = sc.nextLine();
			int count = new CharacterController().countAlpha(input);
			System.out.println("'"+input+"'�� ���Ե� ������ ���� : "+count);
			
		} catch (CharCheckException e) {
			e.printStackTrace();
		}
	}
}
