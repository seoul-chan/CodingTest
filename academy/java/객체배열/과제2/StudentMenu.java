package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("======== �л� ���� ��� ========");
		Student[] stu = ssm.printStudent();
		for(int i=0;i<stu.length;i++) {
			System.out.println(stu[i].inform());
		}
		
		System.out.println("\n======== �л� ���� ��� ========");
		double[] avg = ssm.avgScore();
		
		System.out.printf("�л� ���� �հ� : %.0f \n",avg[0]);
		System.out.print("�л� ���� ��� : "+avg[1]+"\n");
		
		System.out.println("\n======== ���� ��� ��� ========");
		for(int i=0;i<stu.length;i++) {
			if(stu[i].getScore()<ssm.CUT_LINE) {
				System.out.println(stu[i].getName()+"�л��� ����� ����Դϴ�.");
			} else {
				System.out.println(stu[i].getName()+"�л��� ����Դϴ�.");
			}
		}
	}
}
