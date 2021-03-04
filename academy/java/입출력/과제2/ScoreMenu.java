package com.kh.practice.score.view;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.practice.score.controller.ScoreController;

public class ScoreMenu {
	private Scanner sc = new Scanner(System.in);
	private ScoreController scr = new ScoreController();
	
	public void mainMenu() {
		while(true) {
			try {
				System.out.println("1. ���� ����");
				System.out.println("2. ���� ���");
				System.out.println("9. ������");
				System.out.print("�޴� ��ȣ : ");
				
				switch(sc.nextInt()) {
					case 1 : saveScore(); break;
					case 2 : readScore(); break;
					case 9 : System.out.println("���α׷��� �����մϴ�.");return;
					default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				}
			} catch(InputMismatchException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine();
				continue;
			}
		}
	}
	
	public void saveScore() {
		int num=1;
		
		while(true) {	
			System.out.println(num+"���� �л� ���� ���");
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.print("���� ���� : ");
			int kor = sc.nextInt();
			System.out.print("���� ���� : ");
			int eng = sc.nextInt();
			System.out.print("���� ���� : ");
			int math = sc.nextInt();
			
			int sum = kor + eng + math;
			double avg = sum/3.0;
			
			scr.saveScore(name, kor, eng, math, sum, avg);
			num++;
			
			System.out.print("�׸� �Է��Ͻ÷��� N�Ǵ� n�Է�, ��� �Ͻ÷��� �ƹ� Ű�� �Է��ϼ��� : ");
			if(sc.next().toUpperCase().charAt(0)=='N') break;
		}
	}
	
	public void readScore() {
		int count=0;
		int sumAll=0;
		double avgAll=0.0;
		
		try(DataInputStream data = scr.readScore()) {
			System.out.println("�̸�\t����\t����\t����\t����\t���\t");
			while(true) {
				String name=data.readUTF();
				int kor = data.readInt();
				int eng = data.readInt();
				int math = data.readInt();
				int sum = data.readInt();
				double avg = data.readDouble();
				
				System.out.println(name+"\t"+kor+"\t"+eng+"\t"+	math+"\t"+sum+"\t"+avg);
				count++;
				sumAll+=sum;
				avgAll+=avg;
			}
		} catch (EOFException e) {
			System.out.println("���� Ƚ��\t�հ�\t���");
			System.out.println(count+"\t"+sumAll+"\t"+avgAll);				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
