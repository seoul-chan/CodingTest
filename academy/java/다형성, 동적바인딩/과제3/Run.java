package com.kh.practice.chap02_abstractNInterface.run;

import com.kh.practice.chap02_abstractNInterface.controller.PhoneController;

public class Run {
	public static void main(String[] args) {
		String[] phone = new PhoneController().method();
		 for(String i : phone)
			 System.out.println(i);
	}
}
