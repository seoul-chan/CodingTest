package workshop03;

public class MonthsTest {
	public static void main(String[] args) {
		int months = Integer.valueOf(args[0]);
		if(months<1||months>12) {
			System.out.println("�Էµ� ���� �߸� �Ǿ����ϴ�.");
			return;
		}
		
		Months m = new Months();
		
		System.out.printf("�Է� ���� �� : %s��\n",months);
		System.out.printf("������ ���� : %s��",m.getDays(months));
	}
}
