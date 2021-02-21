package com.kh.practice.file.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		while(true) {
			try {
				System.out.println("***** My Note *****");
				System.out.println("1. ��Ʈ ���� �����");
				System.out.println("2. ��Ʈ ����");
				System.out.println("3. ��Ʈ ��� �����ϱ�");
				System.out.println("9. ������");
				System.out.print("�޴� ��ȣ : ");
				
				switch(sc.nextInt()) {
					case 1 : fileSave(); break;
					case 2 : fileOpen(); break;
					case 3 : fileEdit(); break;
					case 9 : System.out.println("���α׷��� �����մϴ�."); return;
					default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���.");
				}
			} catch(InputMismatchException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
		System.out.println("ex��it��� �Է��ϸ� ����˴ϴ�.");
		System.out.print("���� : ");
		
		sc.nextLine();
		while(true) {
			String input = sc.nextLine();
			if(input.equals("ex��it")) break;
			
			sb.append(input+"\n");
		}
		
		while(true) {
			System.out.print("������ ���� ���� �Է����ּ���(ex. myFile.txt) : ");
			String fileName = sc.next();

			if(fc.checkName(fileName)) {
				System.out.print("�̹� �����ϴ� �����Դϴ�. ����ðڽ��ϱ�?(y/n)");
				if(sc.next().equals("y")) {
					fc.fileSave(fileName, sb);
					break;
				}
					else continue;
			} else {
				fc.fileSave(fileName, sb);
				break;
			}
		}				
	}
	
	
	public void fileOpen() {
		System.out.print("�� ���� �� : ");
		String file = sc.next();
		System.out.println(fc.checkName(file)?fc.fileOpen(file):"���� �����Դϴ�.");		
	}
	
	
	public void fileEdit() {
		StringBuilder sb = new StringBuilder();
		
		System.out.print("������ ���� �� : ");
		String file = sc.next();
		if(fc.checkName(file)) {
			System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
			System.out.println("ex��it��� �Է��ϸ� ����˴ϴ�.");
			System.out.print("���� : ");
			
			sc.nextLine();
			while(true) {
				String input = sc.nextLine();
				if(input.equals("ex��it")) break;
				
				sb.append(input+"\n");
			}
			
			fc.fileEdit(file, sb);
			
		} else {
			System.out.println("���� �����Դϴ�.");
		}
	}
}
