package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		while(true) {
			int[] count = pc.personCount();
			System.out.println();
			System.out.println("�л��� �ִ� 3����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� �л��� "+count[0]+"�� �Դϴ�.");
			System.out.println("����� �ִ� 10����� ������ �� �ֽ��ϴ�.");
			System.out.println("���� ����� ����� "+count[1]+"�� �Դϴ�.");
			
			System.out.println("1. �л� �޴�");
			System.out.println("2. ��� �޴�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			
			int cho = sc.nextInt();
			switch(cho) {
				case 1 : studentMenu(); break;
				case 2 : employeeMenu(); break;
				case 9 : System.out.println("�����մϴ�."); return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void studentMenu() {
		while(true) {
			int[] count = pc.personCount();
			System.out.println("\n==== �л� �޴� ====");
			System.out.println((count[0]==3)?"�л��� ���� �� �ִ� ������ �� ã�� ������ "
										+ "�л� �߰� �޴��� �� �̻� Ȱ���� ���� �ʽ��ϴ�.":"1. �л� �߰�");
			System.out.println("2. �л� ����");
			System.out.println("9. ��������");
			System.out.print("�޴� ��ȣ : ");
			
			int cho = sc.nextInt();
			if(count[0]==3&&cho==1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			switch(cho) {
				case 1: insertStudent(); break;
				case 2: printStudent(); break;
				case 9 : System.out.println("�������� ���ư��ϴ�."); return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			int[] count = pc.personCount();
			System.out.println("\n==== ��� �޴� ====");
			System.out.println((count[1]==10)?"����� ���� �� �ִ� ������ �� ã�� ������ "
										+ "��� �߰� �޴��� �� �̻� Ȱ���� ���� �ʽ��ϴ�.":"1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("9. ��������");
			System.out.print("�޴� ��ȣ : ");
			
			int cho = sc.nextInt();
			if(count[1]==10&&cho==1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			switch(cho) {
				case 1: insertEmployee(); break;
				case 2: printEmployee(); break;
				case 9 : System.out.println("�������� ���ư��ϴ�."); return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void insertStudent() {
		while(true) {
			System.out.println("\n==== �л� �߰� �޴� ====");
			System.out.print("�л� �̸� : ");
			String name = sc.next();
			System.out.print("�л� ���� : ");
			int age = sc.nextInt();
			System.out.print("�л� Ű : ");
			double height = sc.nextDouble();
			System.out.print("�л� ������ : ");
			double weight = sc.nextDouble();
			System.out.print("�л� �г� : ");
			int grade = sc.nextInt();
			System.out.print("�л� ���� : ");
			String major = sc.next();
			
			pc.insertStudent(name, age, height, weight, grade, major);
			
			int[] count = pc.personCount();
			if(count[0]<3) {
				System.out.println("�׸� �Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
			} else {
				System.out.println("�л��� ���� �� �ִ� ������ �� ã�� ������ �л� �߰��� �����ϰ� "
						+ "�л� �޴��� ���ư��ϴ�.");
				break;
			}
			
			char conti = sc.next().charAt(0);
			if(conti=='N'||conti=='n') break;
		}
	}
	
	public void printStudent() {
		Student[] s = pc.printStudent();
		
		System.out.println();
		if(s==null) {
			System.out.println("����� �л������� �����ϴ�.");
		} else {
			for(int i=0;i<s.length;i++) {
				if(s[i]!=null) System.out.println(s[i]);
			}
		}
	}
	
	public void insertEmployee() {
		while(true) {
			System.out.println("\n==== ��� �߰� �޴� ====");
			System.out.print("��� �̸� : ");
			String name = sc.next();
			System.out.print("��� ���� : ");
			int age = sc.nextInt();
			System.out.print("��� Ű : ");
			double height = sc.nextDouble();
			System.out.print("��� ������ : ");
			double weight = sc.nextDouble();
			System.out.print("��� �޿� : ");
			int salary = sc.nextInt();
			System.out.print("��� �μ� : ");
			String dept = sc.next();
			
			pc.insertEmployee(name, age, height, weight, salary, dept);
			
			int[] count = pc.personCount();
			if(count[1]<10) {
				System.out.println("�׸� �Ͻ÷��� N(�Ǵ� n), �̾��Ͻ÷��� �ƹ� Ű�� �������� : ");
			} else {
				System.out.println("����� ���� �� �ִ� ������ �� ã�� ������ ��� �߰��� �����ϰ� "
						+ "��� �޴��� ���ư��ϴ�.");
				break;
			}
			
			char conti = sc.next().charAt(0);
			if(conti=='N'||conti=='n') break;
		}
	}
	
	public void printEmployee() {
		Employee[] e = pc.printEmloyee();
		
		System.out.println();
		if(e==null) {
			System.out.println("����� ��������� �����ϴ�.");
		} else {
			for(int i=0;i<e.length;i++) {
				if(e[i]!=null) System.out.println(e[i]);
			}
		}
	}
}
