package workshop4;

public class Test04 {
	public static void main(String[] args) {
		Calc c = new Calc();
		int sum=0,result=0;
		int data = Integer.valueOf(args[0]);
		String str="";
		
		if(data<5||data>10) {
			System.out.println("�ٽ� �Է����ּ���.");
			return;
		}
		
		for(int i=0;i<=data;i++) {
			result=c.calculate(i);
			if(result!=0) {
				sum+=result;
				str+=result+" ";
			}
		}
		System.out.println("¦�� : "+str);
		System.out.println("��� : "+sum);
	}
}

class Calc {
	public int calculate(int data) {
		if(data%2==0) return data;
		else return 0;
	}
}
