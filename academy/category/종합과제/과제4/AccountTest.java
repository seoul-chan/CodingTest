package workshop4;

public class AccountTest {
	public static void main(String[] args) {
		Account ac = new Account("441-0290-1203",500000,7.3);		
		System.out.println("�������� : "+ac.getAccount() + " �����ܾ� : "+ac.getBalance());
		ac.deposit(20000);
		System.out.println("�������� : "+ac.getAccount() + " �����ܾ� : "+ac.getBalance());
		System.out.println(ac.calculateInterest());
	}
}
