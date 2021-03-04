package com.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.common.FoodCalAsc;
import com.common.FoodCalDesc;
import com.common.FoodNameAsc;
import com.common.FoodNameDesc;
import com.common.IntegerOrderAsc;
import com.common.IntegerOrderDesc;
import com.common.TestLambda;
import com.model.vo.Food;




public class ListController {
	public static void main(String[] args) {
		/*
		 * List, Set�� �������̽��̱⿡ ���� ����� �Ұ��ϴ�.
		 * 
		 * ArrayListŬ���� �̿��ϱ�
		 * ArrayList �迭�� ������ ���������� ������, �迭�� ������ ������ �ڷᱸ������
		 * ArrayList�� Ŭ������ �����ؼ� �̿��� ��.
		 * Ŭ���� ������ ��ü�� �޼ҵ带 �̿��ؼ� ������ ��(����, �߰�, ����, ����...)
		 * ArrayList�� List�������̽�, Collection�������̽��� �����߱⿡ List ����, Collection������ ���Ե� �� �ִ�.
		 * �⺻������ list��ü�� 10�� ������ �� �ִ� ������ ���� -> �迭���� �ε����� ���� ������
		 * �迭�� �����ϴ� ������ ����(�ε��� ����). �׷��� ������ ������ ������ ������ �ִ�.
		*/
		
		
		ArrayList list = new ArrayList(); //10�� ����Ȯ��
		ArrayList<Integer> list2 = new ArrayList<Integer>(20); //20�� ����Ȯ��
		List l = new ArrayList();
		Collection c = new ArrayList();
		
		
		//*** add()�� �̿��ؼ� ArrayList�� ��ü�����ϱ�
		list.add(true); //���ڷ� ������Ʈ ��ü�� ����, ����Ŭ������ ���� �ڵ����� ����ڽ�
		list.add(19);
		list.add("�����");
		list.add(new Date());
		System.out.println(list);
		System.out.println(list.size());
		
		ArrayList foods=new ArrayList();
		foods.add(new Food("����",7000,"����",500,null));
		foods.add(new Food("������",1000,"��",800,new Date(new GregorianCalendar(2021,02,20).getTimeInMillis())));
		foods.add(new Food("����ʹ�",800,"�ʹ�",200,null));
		
		System.out.println(foods);
		
		
		
		// ***get()�޼ҵ� �� index���� �������� ������.
		Food f = (Food)foods.get(0); //���� �� ObjectŸ������ ����Ǳ⿡ ����ȯ�� ���־�� �Ѵ�.
		System.out.println(f.getName()+" "+f.getPrice());
		System.out.println(((Food)foods.get(1)).getName()+ " "+((Food)foods.get(1)).getPrice());
		
		//foods ��� 1
		for(int i=0;i<foods.size();i++) {
			Food temp = (Food)foods.get(i);
			System.out.println(temp.getName()+" "+temp.getPrice());
		}
		//foods ��� 2		
		for(Object f1 : foods) {
			Food temp = (Food)f1;
			System.out.println(temp.getName()+" "+temp.getPrice());
		}
		//500Į�θ� �̻� ������ ��� �հ�
		int money=0;
		for(Object f1 : foods) {
			Food temp = (Food)f1;
			if(temp.getCalorie()>=500) {
				System.out.println(temp);
				money+=temp.getPrice();
			}
		}
		System.out.println("500Į�θ� �̻� ������ ��� �հ� : "+money);

		
		
		// ***remove() �� �ε����� �̿��ؼ� ������ ����
//		foods.remove(1);
//		foods.remove(1);
		foods.remove(new Food("����ʹ�",800,"�ʹ�",200,null));
		System.out.println(foods);
		
		
		
		// ***set()�޼ҵ带 �̿��Ͽ� �� �����ϱ�
		foods.set(1, new Food("���",1200,"��",480,null));
		System.out.println(foods);
		
		
		
		// ***add(index, ��) ���ϴ� ��ġ�� �� �߰��ϱ�
		foods.add(0, new Food("����",28000,"��",1368,null));
		System.out.println(foods);
		
		
		
		// ***clear() ����Ʈ ��ü ����
		System.out.println("���� �� : "+list);
		list.clear();
		System.out.println("���� �� : "+list);
		
		
		
		// ***�߰� ������ �޼���
		//contain() - ����Ʈ�� ���� �ִ��� ���� Ȯ��
		//������ ��ü�� �ִ��� Ȯ���̱⿡ equals()�޼ҵ尡 �������̵� �Ǿ� �־���Ѵ�.
			if(foods.contains(new Food("���",1200,"��",480,null))) 
				System.out.println("�ִ� �����Դϴ�.");
			
			if(!foods.contains(new Food("���",1200,"��",480,null)))
				foods.add(new Food("���",1200,"��",480,null));
			
		
		//isEmpty() - ����Ʈ�� ���� ����ִ��� ���� Ȯ��	
		System.out.println(foods.isEmpty());
		System.out.println(list.isEmpty());
		
		if(!foods.isEmpty()) { // foods.size()==0�� ���� �ǹ�
			for(Object t : foods) {
				System.out.println(t);
			}
		}
			
			
		//indexOf(��ü) : �Ű������� ��ġ�ϴ� ���� �ε�����ȭ ��ȯ
		System.out.println(foods.indexOf(new Food("���",1200,"��",480,null)));
		
		
		//toArray() : list����� ��ü�� Objects�迭�� ��ȯ���ִ� �޼ҵ�
		Object[] objFood=foods.toArray();
		for(int i=0;i<objFood.length;i++)
			System.out.println(objFood[i]);
		
		
		//list�� �ߺ������͵� ������ ������
		foods.add(new Food("������",2500,"�丮",1300,null));
		foods.add(new Food("����Ƽ",2000,"��",100,null));
		foods.add(new Food("������Ľ�Ÿ",3400,"��",9500,null));
		foods.add(new Food("�ܹ���",6700,"��",700,null));
		foods.add(new Food("������",9000,"��",780,null));
		
		for(int i=0;i<foods.size();i++) {
			System.out.println(foods.get(i));
		}
		
		
		//����Ʈ�� ������ �ִ�. ��, ������ �����ϴ�
		ArrayList numbers = new ArrayList();
		for(int i=0;i<10;i++) {
			numbers.add((int)(Math.random()*10));
		}
		System.out.println(numbers);
//		Collections.sort(numbers); //�������� ����
		Collections.sort(numbers,new IntegerOrderAsc()); //�������� ����
		System.out.println(numbers);
		
		Collections.sort(numbers,new IntegerOrderDesc()); //�������� ����
		System.out.println(numbers);
		
		
		
		//foods�� �ִ� ���� ���ǿ� ���� �����غ���.
		//1. Į�θ��� �������� �������� ����
		for(Object f1 : foods)
			System.out.println(f1);
		
		Collections.sort(foods,new FoodCalAsc());
		System.out.println("===================�������� ������(Calorie) ===================");
		for(Object f1 : foods)
			System.out.println(f1);
		
		System.out.println("===================�������� ������(Calorie) ===================");
		Collections.sort(foods,new FoodCalDesc());
		for(Object f1 : foods)
			System.out.println(f1);
		
		
		//2. �������� �����ϱ� �����̸����� �����ϱ�
		/*
		 * �������� �����ϱ�
		 * ��Ʈ�� ��ü���� ���ڿ��� �����ִ� �޼ҵ带 ��������
		 * compareTo() -> str1.compareTo(str2) -> str1 str2 ��, return -, +, 0
		 */
		Collections.sort(foods,new FoodNameAsc());
		System.out.println("===================�������� ������(Name) ===================");
		for(Object f1 : foods)
			System.out.println(f1);
		
		foods.sort(new FoodNameDesc());
		System.out.println("===================�������� ������(Name) ===================");
		for(Object f1 : foods)
			System.out.println(f1);
		
		
		// �͸�Ŭ������ �̿��Ͽ� ���� �� ���� �ִ�.
		Collections.sort(foods,new Comparator<Food>() {	
			@Override
			public int compare(Food f1, Food f2) {
				return f1.getPrice()-f2.getPrice(); //Ŭ���� ���� ���� ���� �͸�Ŭ������ ��� ����
			}
		});

		System.out.println();
		for(Object f1 : foods) {
			System.out.println(f1);
		}
		
		
		
		/* �Ű������� ������ �ȴٸ� Ŭ���� �̸�, �޼ҵ� �̸��� �ʿ䰡 ���� -> ���ٽ� ����!!
		 * ���ٴ� @FunctionalInterface��.(�߻�޼ҵ尡 �Ѱ��� ����� �������̽�)
		 * lambda ��� �� : (�Ű�����, .. , ...)  -> { ���� �ۼ� (+return)}
		 * ���ٸ� ����ϱ� ���� �⺻������ Interface���� �����ؾ� �ϴ� �޼ҵ� ������ �˾ƾ��Ѵ�. 
		 */

		//int compare(Object o1, Object o2)�κ��� ���ٽ����� ���
		Collections.sort(foods,(Object o1, Object o2) -> {
			return ((Food)o1).getCategory().compareTo(((Food)o2).getCategory());
		});
		
		TestLambda testfilter=(Food temp) -> temp.getPrice()>20000;
		
		List result = filter(foods, (Food temp) -> temp.getPrice()>8000);	//������ 8õ�� �̻��� ��ü ���
		
		System.out.println("========== ���� =============");
		result = filter(foods,(Food temp) -> temp.getCategory().contains("��"));	//ī�װ��� ���� ��ü ���
		for(Object o : result) {
			System.out.println(o);
		}
		
	}
	
	public static List filter(List list, TestLambda filter) {	//TestLambda filter�ڸ����� ���ٸ� ������ ���� �;��Ѵ�??
		List result = new ArrayList();
		for(Object o : list) {
			if(filter.test((Food)o)) {
				result.add(o);
			}
		}
		return result;
	}
	
}
