package workshop03;

public class Test02 {
	public static void main(String[] args) {
		Calc c = new Calc();
		int sum=0;
		int data = Integer.valueOf(args[0]);
		if(data<5||data>10) {
			System.out.println("�ٽ� �Է����ּ���.");
			return;
		}
		
		for(int i=0;i<=data;i++) {
			sum+=c.calculate(i);
		}
		System.out.println("��� : "+sum);
	}
}

class Calc {
	public int calculate(int data) {
		if(data%2==0) return data;
		else return 0;
	}
}