package workshop02.com.Test3;

public class StudentTest {
	public static void main(String[] args) {
		Student[] studentArray = new Student[3];
		studentArray[0] = new Student("ȫ�浿",15,170,80);
		studentArray[1] = new Student("�ѻ��",13,180,70);
		studentArray[2] = new Student("�Ӱ���",16,175,65);
		
		double ageAvg=0.0, heightAvg=0.0, weightAvg=0.0;
		int minAge=0,minHeight=0,minWeight=0;
		int maxAge=0,maxHeight=0,maxWeight=0;
		
		System.out.println("�̸�\t����\t����\t������");
		for(int i=0;i<studentArray.length;i++) {
			System.out.println(studentArray[i].studentInfo());
			ageAvg+=studentArray[i].getAge();
			heightAvg+=studentArray[i].getHeight();
			weightAvg+=studentArray[i].getWeight();
			
			if(studentArray[i].getAge() < studentArray[minAge].getAge()) minAge=i;
			if(studentArray[i].getHeight() < studentArray[minHeight].getHeight()) minHeight=i;
			if(studentArray[i].getWeight() < studentArray[minWeight].getWeight()) minWeight=i;
			if(studentArray[i].getAge() > studentArray[maxAge].getAge()) maxAge=i;
			if(studentArray[i].getHeight() > studentArray[maxHeight].getHeight()) maxHeight=i;
			if(studentArray[i].getWeight() > studentArray[maxWeight].getWeight()) maxWeight=i;
			
		}		
		System.out.printf("���� ��� : %.3f\n",ageAvg/studentArray.length);
		System.out.printf("���� ��� : %.3f\n",heightAvg/studentArray.length);
		System.out.printf("���� ��� : %.3f\n",weightAvg/studentArray.length);
		System.out.println();
		
		System.out.println("���̰� ���� ���� �л� : "+studentArray[maxAge].getName());
		System.out.println("���̰� ���� ���� �л� : "+studentArray[minAge].getName());
		
		System.out.println("������ ���� ū �л� : "+studentArray[maxHeight].getName());
		System.out.println("������ ���� ���� �л� : "+studentArray[minHeight].getName());
		
		System.out.println("�����԰� ���� ���� ������ �л� : "+studentArray[maxWeight].getName());
		System.out.println("�����԰� ���� ���� �л� : "+studentArray[minWeight].getName());
	}
}
