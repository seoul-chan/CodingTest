package workshop5;

public class Test02 {
	public static void main(String[] args) {
		Company c = new Company(100);
		System.out.printf("�� �⺻�� �� : %.1f ���� : %.1f\n",c.getIncome(),c.getAfterTaxIncome());
		System.out.printf("�� ���ʽ� �� : %.1f ���� : %.1f\n",c.getBonus(),c.getAfterTaxBonus());
		System.out.println("�� ���޾� �� : "+(c.getAfterTaxIncome()+c.getAfterTaxBonus()));
	}	
}
