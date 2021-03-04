package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("==== �޴� ====");
			System.out.println("1. �� �޴�");
			System.out.println("2. �簢�� �޴�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int cho = sc.nextInt();
			
			switch(cho) {
				case 1 : circleMenu(); break;
				case 2 : rectangleMenu(); break;
				case 9 : return;
				default : System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}	
	}
	
	public void circleMenu() {		
		System.out.println("==== �� �޴� ====");
		System.out.println("1. �� �ѷ�");
		System.out.println("2. �� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");
		int cho = sc.nextInt();
		
		switch(cho) {
			case 1 : calcCircum(); break;
			case 2 : calcCircleArea(); break;
			case 9 : return;
			default : System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
		}
	}
	
	public void rectangleMenu() {
		System.out.println("==== �޴� ====");
		System.out.println("1. �簢�� �ѷ�");
		System.out.println("2. �簢�� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");
		int cho = sc.nextInt();
		
		switch(cho) {
			case 1 : calcPerimeter(); break;
			case 2 : calcRectArea(); break;
			case 9 : return;
			default : System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
		}
	}
	
	// �� �ѷ�
	public void calcCircum() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int radius = sc.nextInt();
		
		String calc = cc.calcCircum(x, y, radius);
		System.out.println("�� �ѷ� : "+cc.printCircle()+" / "+calc);
	}
	
	//�� ����
	public void calcCircleArea() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int radius = sc.nextInt();
		
		String calc = cc.calcArea(x, y, radius);
		System.out.println("�� ���� : "+cc.printCircle()+" / "+calc);
	}
	
	// �簢�� �ѷ�
	public void calcPerimeter() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("���� : ");
		int heigh = sc.nextInt();
		System.out.print("�ʺ� : ");
		int width = sc.nextInt();
		
		String calc = rc.calcPerimeter(x, y, heigh, width);
		System.out.println("�簢�� �ѷ� : "+rc.printRectangle()+" / "+calc);
	}
	// �簢�� ����
	public void calcRectArea() {
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("���� : ");
		int heigh = sc.nextInt();
		System.out.print("�ʺ� : ");
		int width = sc.nextInt();
		
		String calc = rc.calcArea(x, y, heigh, width);
		System.out.println("�簢�� �ѷ� : "+rc.printRectangle()+" / "+calc);
	}
}
