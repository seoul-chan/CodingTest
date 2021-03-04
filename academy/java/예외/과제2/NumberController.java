package com.kh.practice.numRange.controller;

import com.kh.practice.numRange.exception.NumRangeException;

public class NumberController {
	
	public NumberController() {}
	public boolean checkDouble(int num1, int num2) throws NumRangeException{
		
		if( !(((1<=num1)&&(num1<=100)) && 
				((1<=num2)&&(num2<=100))) ) throw new NumRangeException("1���� 100������ ���� �ƴմϴ�.");
				
		return (num1%num2==0)?true:false;
	}
}
