package workshop5;

public class StudentTest {
	public static void main(String[] args) {
		Student[] studentArray = new Student[3];
		studentArray[0] = new Student("ȫ�浿",15,171,81);
		studentArray[1] = new Student("�ѻ��",13,183,72);
		studentArray[2] = new Student("�Ӱ���",16,175,65);
		
		double avgAge=0.0, avgHeight=0.0, avgWeight=0.0;
		
		System.out.println("�̸�\t����\t����\t������");
		for(int i=0;i<studentArray.length;i++) {
			System.out.println(studentArray[i].getName()+"\t"+studentArray[i].getAge()+"\t"+
					studentArray[i].getHeight()+"\t"+studentArray[i].getWeight());
			
			avgAge+=studentArray[i].getAge();
			avgHeight+=studentArray[i].getHeight();
			avgWeight+=studentArray[i].getWeight();
		}
		System.out.printf("������ ��� : %.2f\n",avgAge/studentArray.length);
		System.out.printf("������ ��� : %.2f\n",avgHeight/studentArray.length);
		System.out.printf("�������� ��� : %.2f\n",avgWeight/studentArray.length);
	}
}
