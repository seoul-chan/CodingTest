package com.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.common.Car;

public class SetController {
	public static void main(String[] args) {
		/*
		 * Set : ��ü���� ������ �� �ִ� ������ ������ ������ �ߺ� ���� ���� �� ����
		 * ������ ���⿡ �������� �ڸ��� ������ �߰��ÿ� �ڸ��� �������� ����ȴ�.(������ �߰� �� ���ʸ� ���� ��ġ)  
		 * add() : ���� �����ϴ� �޼���, add()�� �����Ͱ� �߰��Ǹ� �������� ��ġ�� �ٽ� �ѹ� ����ȴ�.
		 * Collection�� ��ӹ��� ��ü��.
		 */
		HashSet set = new HashSet();
		set.add("�����1");
		set.add("�����2");
		set.add("�����3");
		set.add("�����4");

		
		
		/*
		 * set����ҿ� �ִ� ���� �����ö��� ���� ��Ī�ϴ� id���� ���⿡ ��ü�� ��ȸ�ؾ��Ѵ�.
		 * ��ȸ�ϴ� ����� ������ ����.
		 * 1. Iterator��ü�� �̿��ϴ� ���
		 * 2. forEach�� �̿��ϴ� ���
		 * 3. set.interator()�޼��带 �̿��ϴ� ���
		 */
		System.out.println(set);
		Iterator it = set.iterator();
		while(it.hasNext()) {
//			String name = it.next(); ����, set��ȯ���� Object�̱� ������ ����ȯ�� �ʿ��ϴ�.
			String name = (String)it.next();
			System.out.println(name);
		}
		
		it=set.iterator();
		it.next();
		
		for(Object s : set) {
			System.out.println(s);
		}
		
		//set�� ����Ǿ� �ִ� �������� ����
		System.out.println(set.size());
		
		//set�� �����Ͱ� ����ִ��� Ȯ��
		System.out.println(set.isEmpty());
		
		set.add("�����(duplication)");
		set.add("�����(duplication)");
		set.add("�����(duplication)");
		set.add("�����(duplication)");
		System.out.println(set);  //Set�� �ߺ� ���� �������� �ʱ⿡ �ߺ��� ���� �ϳ��� ����ȴ�.
		
		Iterator it2 = set.iterator(); 
		while(it2.hasNext()) 
			System.out.println(it2.next()); //�ߺ� ���� ������� �ʾ� �ϳ��� ��µȴ�.
		
		
		HashSet cars = new HashSet();
		cars.add(new Car("���׽ý�","����",80000000,4));
		cars.add(new Car("Ƽ��","���",800000,2));
		cars.add(new Car("������","����",20000000,4));
		cars.add(new Car("��Ƽ��","Ȳ��",400000,4));
		cars.add(new Car("��Ʋ��","ȸ��",300000000,4));
		
		boolean result=cars.contains(new Car("��Ʋ��","ȸ��",300000000,4));
		System.out.println(result); //equals, hash �������̵� �� -> false
		
		//lotto���� �����
		HashSet lotto = new HashSet();
		while(lotto.size()!=6) {
			int num = (int)(Math.random()*44)+1;
			lotto.add(num);
		}
		for(Object o : lotto)
			System.out.println(o+" ");
		System.out.println();
		
		//Set ��ü ���� 
		cars.remove(new Car("��Ʋ��","ȸ��",300000000,4));
		
		/*
		 * ArrayList�ϰ� ȣȯ��
		 * ArrayList�� �ߺ� ����� ���� HashSet�� �̿��Ͽ� �ߺ��� ���� �� �ٽ� ��ȯ �޴´�.
		 */
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(4);
		System.out.println("�ߺ��� ���� ��(ArrayList)"+list);
		
		HashSet temp = new HashSet(list);
		System.out.println("�ߺ��� ���� �� (Hahset)"+temp);
		
		list=new ArrayList(temp);
		System.out.println("�ߺ��� ���� ��(ArrayList)"+list);
		
		
				
		// ***LinkedHashSet ������ �ִ� set
		LinkedHashSet lSet = new LinkedHashSet();
		lSet.add("�����");
		lSet.add("�����2");
		lSet.add("�����3");
		System.out.println("LinkedHashSet : "+lSet);
		
		
		
		// ***TreeSet() : �ڵ� �������� ����
		TreeSet tSet = new TreeSet();
		tSet.add(1);
		tSet.add(5);
		tSet.add(2);
		tSet.add(3);
		tSet.add(9);
//		tSet.add(4);	//Car��ü�� ���� �ٸ� ��ü�� �ּ������ �Ʒ� Car��ü �߰� �� ������ �߻����� �ʴ´�. (���� �� ���⿡??)
		System.out.println("TreeSet : "+tSet);

		
		/*
		 * TresSet�� ��ü�� add�� ������ �߻��Ѵ�.(ClassCastException)
		 * (���� : Car cannot be cast to class java.lang.Comparable	<- Comparable�� �����ؼ� �ذ��Ѵ�.)
		 * 
		 * Ʈ������ ������ �� ���� �񱳸� �ϸ鼭 ������ �Ѵ�. ���� equals�� ������ �Ǿ����� ���� ��ü�� ������ ���� �ʴ´�. 
		 * (�⺻ Ÿ��, ����Ÿ��, String ���� Comaparable�� ������ �Ǿ��־ �� ����)
		 * 
		 * �����ϴ� ��ü�� Comparable�� ������ �ִ���, �����ϴ� �� ������ Comparator�� ������ Ŭ������ ���� �־�� �Ѵ�.
		 */ 
		
		//Car��ü�� Comparable���� �� �׿� ���� compareTo �������̵� �� add()����
		tSet.add(new Car("���׽ý�","����",80000000,4)); 
		tSet.add(new Car("Ƽ��","���",800000,2));
		tSet.add(new Car("������","����",20000000,4));
		tSet.add(new Car("��Ƽ��","Ȳ��",400000,4));
		tSet.add(new Car("��Ʋ��","ȸ��",300000000,4));
		System.out.println("TreeSet : "+tSet);
		
		Iterator it3 = tSet.descendingIterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		
		//tSet�� ������ �� ��Ʋ���� ã�Ƽ� �̸�, ����, ���� ����ϱ�.
		Iterator carIt = tSet.iterator();
		while(carIt.hasNext()) {
			Car c = (Car)carIt.next();
			if(c.getName().contains("��Ʋ��")) //equals()��� ����
				System.out.println(c.getName()+" "+c.getColor()+" "+c.getPrice());
		}
		
		
		
		
		
		
		
	}
}
