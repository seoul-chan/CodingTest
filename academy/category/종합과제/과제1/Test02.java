package workshop1;

public class Test02 {
	public static void main(String[] args) {
		int intArgs = Integer.valueOf(args[0]);
		
		if(intArgs<5||intArgs>10) {
			System.out.println("�ٽ� �Է��ϼ���"); 
			return;
		}
		
		double sum=0.0,multi=1.0,aver=0.0;
		for(int i=1;i<=intArgs;i++) {
			sum+=i;
			multi*=i;
		}
		aver=sum/intArgs;
		System.out.println("�� : "+sum);
		System.out.println("�� : "+multi);
		System.out.println("��� : "+aver);		
	}
}
