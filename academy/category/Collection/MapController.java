package com.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.common.Car;

public class MapController {
	public static void main(String[] args) {
		/*
		 * Map
		 * Map�� ������ �̷���� �ִ� ���� -> key : value
		 * key�� �ϳ��� index�� ���� �ߺ� ���� ���� �� ������ value�� �ߺ����� ���� �� �ִ�.
		 * key, value type -> �Ѵ� ObjectŸ���� ����Ѵ�.
		 * ��� key���� String��ü�� ���� ����Ѵ�.
		 * value�� ��ü�� ����Ѵ�.
		 * Map�� Collection�� ��ӹ��� �ʾҴ�.
		 * List, Set���� �޼ҵ��� ��Ī�̳� Ȱ���� �ణ �ٸ���. 
		 */
		
		HashMap map = new HashMap();
		// ���ֱ� -> put(key,value);
		map.put("��","A");
		map.put("��","B");
		map.put("��","C");
		System.out.println(map);
		
		//get(key) -> ����� �� ��������
		//����� ���� key���ؼ� ������
		System.out.println(map.get("��"));
		System.out.println(map.get("��"));
		
		// key���� �ߺ��� �Ұ�����.
		// �ߺ��� Ű ������ �Է��� ������ ���� ���� ����� ��
		map.put("��", "����");
		System.out.println(map.get("��")); //����
		
		map.remove("��");
		System.out.println(map);
		System.out.println(map.get("��")); //null
		
		
		/*
		 * map�� �ִ� ������ ��ü�� ��ȸ�ϴ� 2���� ���
		 * 1. key���� ��°�� ������ key�� �����ϴ� ���
		 * keySet() -> map�� key�� Set������� ��ȯ�ϴ� �޼ҵ�
		 * 
		 * 2. key,value ��� ������ �����ϴ� ���
		 * key, value ��� �����ϴ� Ŭ������ �̿��� -> Map.Entry Ŭ����
		 * */

		// ��� 1.
		Set keys=map.keySet(); //key���� ��ȯ��.
		Iterator it = keys.iterator();
		
		while(it.hasNext()) {
			Object key = it.next(); //key��
//			String key = (String)it.next();  ����ȯ�� ����ؼ��� �� �� �ִ�.
			System.out.println(map.get(key));
		}
		
		
		// ��� 2. 
		Set entrySets = map.entrySet();
		Iterator entryIt=entrySets.iterator();
		while(entryIt.hasNext()) {
			Map.Entry en = (Map.Entry)entryIt.next();
			System.out.println(en.getKey()+" : "+en.getValue());
		}
		
		//isEmpty() - �����Ͱ� ��� �ִ��� Ȯ��
		System.out.println(map.isEmpty());
		
		//key, value�� ���ԵǾ� �ִ��� Ȯ��
		System.out.println(map.containsKey("��")); //��ü�� �� �ִ� ��� equals, hashcode �������̵� �ʼ�
		System.out.println(map.containsValue("A"));
		
		//�������� ������ Ȯ��
		System.out.println(map.size());

		//������ ��ü �����
		map.clear();
		
		/*
		 * map�� �����ؼ� key�� String(����), value Car��ü
		 * 1 : ��� ��� 5000 4
		 * 2 : �׷��� ������ 8000 4
		 * 3 : ī�Ϲ� ȸ�� 6000 5
		 * 4 : �׽��� ���� 1�� 3õ 5
		 */
		
		//1. ��ü �����͸� ����ϱ� (����, ���� ����)
		//2. ������ 7õ���� �̻��� ���� ��� (����, ����, �ο���)
		HashMap cars = new HashMap();
		cars.put(1, new Car("���","���",5000,4));
		cars.put(2, new Car("�׷���","������",8000,4));
		cars.put(3, new Car("ī�Ϲ�","ȸ��",6000,5));
		cars.put(4, new Car("�׽���","����",13000,5));
		
		System.out.println(cars);
		
		//��� 1
		Set carKey = cars.keySet();
		Iterator carIt = carKey.iterator();
		
		while(carIt.hasNext()) {
			Car cc = (Car)cars.get(carIt.next());
			if(cc.getPrice()>=7000)
				System.out.println(cc.getName()+" "+cc.getPrice()+" "+cc.getPerson());
		}
		
		//��� 2		
		Set entryCar=cars.entrySet();
		Iterator entryit = entryCar.iterator();
		
		while(entryit.hasNext()) {
			Map.Entry entry = (Map.Entry)entryit.next();
			Car c = (Car)entry.getValue();
			
			if(c.getPrice()>7000)
				System.out.println(c.getName()+" "+c.getPrice()+" "+c.getPerson());
			
		}	
	}
}
