package com.algorithm;

public class Greedy {
	public static void main(String[] args) {
		// ���ϱ� Ȥ�� ���ϱ�
		// �־��� ���ڿ��� ���� ���ϱ� Ȥ�� ���ϱ⸦ �Ͽ� �ִ밪�� ����Ͻÿ�
		String s= "02984";
		
		long result=s.charAt(0)-'0';
		for(int i=1;i<s.length();i++) {
			int num=s.charAt(i)-'0';
			if(num<=1 || result<=1) result+=num;
			else result*=num;
		}
		System.out.println(result);
	}	
	
	/*
	
	public static void main(String[] args) {
		//1�� �� ������
		// n�� k�� ������ �������� k�� ���� �� �ְ�
		// �׷��� ���� ��� 1�� �� �� ������ n�� 1�� �Ǳ���� �ּ� Ƚ���� ���Ͻÿ� 
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), k=sc.nextInt();
		int count=0;
		while(n!=1) {
			if(n%k==0) n/=k;
			else n-=1;
			count++;
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		/*
		 * ���� ī�����
		 * N : ��, M : ��
		 * �ະ ���� ���� �� ���ϰ� �� �� ���� ū �� ���ϱ�
		 *
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		int[][] arr = new int[n][m];
		int[] min = new int[n];
		for(int i=0;i<n;i++) {
			int temp=10001;
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]<temp) temp=arr[i][j];
			}
			min[i]=temp;			
		}
		
		int max=0;
		for(int i=0;i<n;i++)
			if(min[i]>max) max=min[i];
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		/*
		 * ū ���� ��Ģ
		 * n : �迭�� ũ��
		 * m : ���ڰ� �������� �� Ƚ��
		 * k : ū ���ڰ� �������� Ƚ��
		 * �迭�� ũ�⸸ŭ ���ڰ� �־����� ���� �� ���� ū ���ڸ� m����ŭ �����ش�.
		 * ��, �ѹ��� ���Ҽ� �ִ� Ƚ���� k���̸�
		 * k����ŭ ������ ��� �� ��° ū ���ڸ� ���� �� �ٽ� ���� ū ���ڸ� ���Ҽ� �ִ�.
		 *
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt();	
		int[] arr=new int[n];
		int sum=0;
		
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);		
		for(int i=0;i<m;i++) {
			for(int j=0;j<k;j++) {
				sum+=arr[n-1];
				i++;
			}
			sum+=arr[n-2];
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		// ���� �Ž��� �ֱ�
		int n = 1260;	//�Ž�����
		int count=0;
		
		int[] coint_type = new int[] {500,100,50,10};
		for(int i : coint_type) {
			count=count+(n/i);
			n%=i;
		}
		System.out.println(count);
	}
	
	*/
}
