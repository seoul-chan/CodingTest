package workshop5;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account("441-0290-1203",500000,7.3);
		System.out.println("���� ���� : "+account.getAccount()+" "+account.getBalance()+" "+account.getInterestRate());
		try {
			account.deposit(-10);
		} catch(Exception e) {
			System.out.println("�Ա� �ݾ��� 0���� �����ϴ�.");
		}
		
		try {
			account.withdraw(600000);
		} catch(Exception e) {
			System.out.println("�ݾ��� 0���� ���ų� ���� �ܾ׺��� �����ϴ�.");
		}
		System.out.println("���� : "+account.calculateInterest());
	}
}
