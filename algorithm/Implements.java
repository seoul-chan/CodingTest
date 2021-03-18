package com.algorithm;

import java.util.Scanner;

public class Implements {
	static int d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a=sc.nextInt(),b=sc.nextInt();
		int x=sc.nextInt(),y=sc.nextInt();
		d=sc.nextInt();
		int[][] arr=new int[a][b];
		int[][] load=new int[a][b];
		load[x][y]=1;
		int nx,ny,count=1,tern=0;
		
		int[] dx={-1,0,1,0};
		int[] dy= {0,1,0,-1};
		
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		while(true) {
			left();
			nx=x+dx[d];
			ny=y+dy[d];
			if(arr[nx][ny]==0&&load[nx][ny]==0) {
				load[nx][ny]=1;
				x=nx; y=ny;
				count++;
				tern=0;
				continue;
			}else {
				tern++;
			}
			
			if(tern==4) {
				nx=x-dx[d];
				ny=y-dy[d];
				if(arr[nx][ny]==0) {
					x=nx; y=ny;					
					tern=0;
				} else {
					break;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void left() {
		d-=1;
		if(d==-1) d=3;
	}
	
	
	
	/*
	 	
	 	
	 	
	 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(), b=sc.nextInt();
		int[][] arr = new int[a][b];
		int[][] load = new int[a][b];
		
		int x=sc.nextInt(), y=sc.nextInt();	//�ɸ��� ��ǥ
		d=sc.nextInt();
		load[x][y]=1;
		int nx=0,ny=0; //�ӽ� �̵� ��ǥ
		
		int count=1,tern_time=0;
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};
				
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		while(true) {
			left();
			nx=x+dx[d];
			ny=y+dy[d];
			if(arr[nx][ny]==0&&load[nx][ny]==0) {
				load[nx][ny]=1;
				count++;
				x=nx; y=ny;
				tern_time=0;
				continue;
			} else {
				tern_time+=1;
			}
			
			if(tern_time==4) {
				nx=x-dx[d];
				ny=y-dx[d];
				if(arr[nx][ny]==0) {
					x=nx;
					y=ny;
				} else {
					break;
				}
				tern_time=0;
			}
		}
		System.out.println(count);
	}
	
	public static void left() {
		d-=1;
		if(d==-1) d=3;
	}
	
	 
	 	public static void main(String[] args) {
		// ü������ �־��� ��ġ���� �̵��� ������ Ƚ�� ���
		// x�� 2ĭ y�� 1ĭ or y�� 2ĭ x�� 1ĭ �̵� ����
		// x=1~8, y=a~h ������ ü������ ����
		Scanner sc = new Scanner(System.in);
		
		int[][] move=new int[][] {{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{-1,-2},{1,2},{-1,2}};
		String input = sc.next();
		int x=input.charAt(1)-'0', y=input.charAt(0)-'a'+1;
		
		int count=0;
		
		for(int[] i : move) {
			int row = x+i[0];
			int col = y+i[1];
			
			if(!(row<1||row>8||col<1||col>8)) count++;
		}
		System.out.println(count);
	}
	 
	 // �Է� ���� n�ð� ���� 3�� ���ԵǴ� ���� ���
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count=0;
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					if((""+i+j+k).contains("3")) count++;
					//if(i%10==3||j/10==0||j%10==3||k/10==0||k%10==3) count++;
				}
			}
		}
		System.out.println(count);
	 
	 public static void main(String[] args) {
		// �Է� ���� n�ð� ���� 3�� ���ԵǴ� ���� ���
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int count=0;
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					if((""+i+j+k).contains("3")) count++;
				}
			}
		}
		System.out.println(count);
	}
	 
	// �������� �̵��� ���� ���� ��ǥ�� ���϶�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int x=1,y=1;		
		
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		char[] move = {'L','R','U','D'};
		
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
		while(st.hasMoreTokens()) {
			char c = st.nextToken().charAt(0);
			
			int i;
			for(i=0;i<move.length;i++)
				if(c==move[i]) break;
			
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<1||nx>n||ny<1||ny>n) continue;
			x=nx;
			y=ny;
		}
		System.out.println(x+" "+y);
	}
	*/
}
