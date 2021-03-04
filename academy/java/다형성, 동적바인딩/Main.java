package com.poly.run;

import com.poly.controller.AnimalFunction;
import com.poly.model.vo.Animal;
import com.poly.model.vo.Cat;
import com.poly.model.vo.Dog;
import com.poly.model.vo.Mouse;
import com.poly.model.vo.Rabbit;

public class Main {
	public static void main(String[] args) {
		//�������� ��Ӱ��迡 �ִ� ��ü�鿡�� ����Ǵ� ���
		//��Ӱ��迡 �ִ� ��ü �� �θ�Ŭ���� Ÿ���� ������ �ڽİ�ü��
		//������ �� �ִ°��� �ǹ��Ѵ�.
		Animal a1 = new Animal();
		Animal a2 = new Dog(); //��Ӱ���
		
		// �� ��ü�� ��Ӱ��踦 �����ϸ� ���������� -> ������
		a2=new Dog();
//		a2=new Cat();
		
		// �ڽİ�ü�� �θ�Ŭ������ �ڷ��������� ���ԵǸ�
		// �θ��� ���븸 Ȯ���� �� �ְ� �ȴ�. -> �ڽ��� ������ �̿��� �Ұ�����.
		
		//�θ�Ŭ���� �ڷ��������� �ڽİ�ü�� �����ϰ� �ڽĿ� �ִ�
		//���뿡 �����Ϸ��� ������ ����ȯ�� �ؼ� �̿��� ��
		
//		(Dog)a2.darkDog(); // ����, (Dog)����ȯ ���� .�� ���� �켱������ ����.
							//a2���� .(��������)�� ���� �����ϱ⿡ Dog�� ��� �̿� �Ұ��ϴ�. 
		((Dog)a2).barkDog();
		
		a2=new Cat();
		((Cat)a2).barkCat();
		
		AnimalFunction af = new AnimalFunction();
		af.bark(new Dog());
		af.bark(new Cat());
		af.bark(new Rabbit());
		af.bark(new Mouse());
		
		//�Ѱ�Ÿ������ ���� Ÿ���� ���� �� ����
		//�迭 ��ü�迭! -> �Ѱ�����(type) ����� ����!
		//�θ��� Ÿ������ �����ϸ� 4���� �ڽ� Ÿ���� �Ѱ��� �迭�� �� ����!
		Animal[] animals = new Animal[5];
		animals[0]=new Dog();
		animals[1]=new Dog();
		animals[2]=new Rabbit();
		animals[3]=new Rabbit();
		animals[4]=new Rabbit();
		
		int dogCount=0;
		int catCount=0;
		int rabbitCount=0;
		for(int i=0;i<animals.length;i++) {
			if(animals[i] instanceof Dog) {
				dogCount++;
				((Dog)animals[i]).barkDog();
			} else if(animals[i] instanceof Cat) {
				catCount++;
				((Cat)animals[i]).barkCat();
			} else if(animals[i] instanceof Rabbit) {
				rabbitCount++;
				((Rabbit)animals[i]).barkRabbit();
			}
		}
		System.out.println("���� : "+dogCount);
		System.out.println("����̴� : "+catCount);
		System.out.println("�䳢��  : "+rabbitCount);
		
		//�������ε�
		for(int i=0;i<animals.length;i++) {
			animals[i].bark();		// DogŬ�������� bark()�������̵� �� Dog.bark() ����(animals[i]=Dog��ü�� ���)
									// CatŬ�������� bark()�������̵� �� Cat.bark() ����(animals[i]=Cat��ü�� ���)
									// �ڽ� Ŭ������ �������̵��� ���ٸ� ���� �θ� Ŭ������ �޼��� ����
									// ����ȯ �� �ʿ䰡 ���� -> �������ε�
		}
		
	}
}
