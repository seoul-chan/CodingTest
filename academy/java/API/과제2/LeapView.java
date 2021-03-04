package com.kh.practice.leap.view;

import java.util.Calendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	public LeapView() {
		Calendar cal = Calendar.getInstance();
		LeapController lc = new LeapController();
		int year = cal.get(Calendar.YEAR);
		long date = lc.leapDate(cal);

		System.out.println("���� �⵵�� "+year+"���̸� "+((lc.isLeapYear(year))?"����":"���")+"�Դϴ�.");
		System.out.println("1�� 1�� 1�Ϻ��� ���ñ��� �� �ϼ��� "+date+"�� �Դϴ�.");
	}
}
