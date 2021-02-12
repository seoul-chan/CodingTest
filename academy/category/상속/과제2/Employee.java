package com.kh.hw.person.model.vo;

public class Employee extends Person{
	private int salary;
	private String dept;
	
	public Employee() {}
	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary=salary;
		this.dept=dept;
	}
	public int getSalay() {return salary;}
	public String getDept() {return dept;}
	public void setSalary(int salay) {this.salary=salay;}
	public void setDept(String dept) {this.dept=dept;}
	
	@Override
	public String toString() {
		return super.toString()+", "+salary+", "+dept;
	}
}
