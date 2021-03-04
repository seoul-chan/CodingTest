package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	// ���� : PI * radius * radius
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return ""+(Math.PI*radius*radius);
	}
	
	// �ѷ� : PI * radius * 2
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return ""+(Math.PI*radius*2); 
	}
	
	public String printCircle() {
		return c.toString();
	}
}
