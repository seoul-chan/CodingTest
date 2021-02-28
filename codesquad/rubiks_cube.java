package Codesquad_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.naming.InsufficientResourcesException;

class rubiks{
	String[][][] cube = new String[6][3][3];
	int count=0;	// ���� ���� ��� ���� ī��Ʈ
	
	// ����Ǯ�� - 1
	// ť�� ���� �ʱ�ȭ �� ���� ����
	void init() {
		String[][][] init_cube = {{{"B0","B1","B2"},{"B3","B4","B5"},{"B6","B7","B8"}},{{"W0","W1","W2"},{"W3","W4","W5"},{"W6","W7","W8"}},{{"O0","O1","O2"},{"O3","O4","O5"},{"O6","O7","O8"}},{{"G0","G1","G2"},{"G3","G4","G5"},{"G6","G7","G8"}},{{"Y0","Y1","Y2"},{"Y3","Y4","Y5"},{"Y6","Y7","Y8"}},{{"R0","R1","R2"},{"R3","R4","R5"},{"R6","R7","R8"}}};
		// ť�� ���� ����
		ArrayList<String> random = new ArrayList<String>();
		for(int i=0;i<init_cube.length;i++) {
			for(int j=0;j<init_cube[0].length;j++) {
				for(int k=0;k<init_cube[0][0].length;k++) {
					random.add(init_cube[i][j][k]);		// ť�� ��� ��Ҹ� ArrayList�� ����
				}
			}
		}
		Collections.shuffle(random);	// ����� ����Ʈ�� ����
		int count=0;
		
		for(int i=0;i<init_cube.length;i++) {
			for(int j=0;j<init_cube[0].length;j++) {
				for(int k=0;k<init_cube[0][0].length;k++) {
					cube[i][j][k]=random.get(count);	// ���� �ϰ� ���� ����Ʈ ��Ҹ� ť�� �迭�� ����
					count++;
				}
			}
		}
		print();	// ť�� �ʱ� ���� ���
	}
	
	// ����Ǯ�� - 2
	// ����� �Է°� ���� �� ��ɾ� �� ť�� ȸ�� �޼ҵ� ȣ��
	boolean input(String input){
		String[] input_arr = input.split("");
		String inpstr = "";
		
		for(int i=0;i<input_arr.length;i++) {
			if(input_arr[i].equals("Q")) {	// Q���� �Է� �Ǵ� ��� ť�� ȸ�� ����
				break;
			}
			inpstr=input_arr[i];	// ���� �Է� ���� �� ����
			if(input_arr[i].equals("'")) continue;
			if(input_arr[i]!=input_arr[input_arr.length-1]) {
				if(input_arr[i+1].equals("'")) {
					inpstr+=input_arr[i+1];	// ���� �Է� ���� ���� ���� '�� ��� ���ڿ� ���ϱ�(������)
				}
			}
			order(inpstr);		// ����Ǯ�� - 3 , ť�� ȸ�� �ֹ� �޼ҵ� ȣ��
			print();	// ȸ�� �� ť�� ���� ���
			count++; 
		}
		return finish();	// �޼ҵ� ��ȯ ���� finish()�޼ҵ�� �Ͽ� ť�� ��� �� ���� ���� �Ǵ�
	}
	
	// ����Ǯ�� - 4
	// ����� ��ɾ ���� ȸ�� �޼ҵ� ȣ�� ����
	void order(String input) {
		System.out.println(input);
		if(input.equals("F")) {
			F();
		} else if(input.equals("F'")) {
			rF();
		}else if(input.equals("U")) {
			U();
		} else if(input.equals("U'")) {
			rU();
		} else if(input.equals("R")) {
			R();
		} else if(input.equals("R'")) {
			rR();
		} else if(input.equals("L")) {
			L();
		} else if(input.equals("L'")) {
			rL();
		} else if(input.equals("B")) {
			B();
		} else if(input.equals("B'")) {
			rB();
		} else if(input.equals("D")) {
			D();
		} else if(input.equals("D'")) {
			rD();
		}
	}
	
	// ����Ǯ�� - 5
	// ������ ȸ�� �޼ҵ�(�� ��), ȣ��� �޼ҵ忡 ���� ť���� �� �̵�
	void F() {
			Turn90(2);	// ������ ȸ�� �� �ش� �� 90�� ȸ��, 	����Ǯ�� - 6
			for(int i=0;i<cube[2].length;i++) {
				String temp = cube[0][2][i];
				cube[0][2][i] = cube[1][cube[2].length-1-i][2];
				cube[1][cube[2].length-1-i][2] = cube[5][0][cube[2].length-1-i];
				cube[5][0][cube[2].length-1-i] = cube [3][i][0];
				cube[3][i][0] = temp;
		}
	}
	// ������ ȸ�� �޼ҵ�(�� ��), ȣ��� �޼ҵ忡 ���� ť���� �� �̵�
	void rF() {
			rTurn90(2);	// ������ ȸ�� �� �ش� �� ������ 90�� ȸ��
			for(int i=0;i<cube[2].length;i++) {
				String temp = cube[0][2][i];
				cube[0][2][i] = cube[3][i][0];
				cube[3][i][0] = cube[5][0][cube[2].length-1-i];
				cube[5][0][cube[2].length-1-i] = cube[1][cube[2].length-1-i][2];
				cube[1][cube[2].length-1-i][2] = temp;
			}
	}
	
	void U() {
		Turn90(0);
		for(int i=0;i<cube[0].length;i++) {
			String temp = cube[1][0][i];
			cube[1][0][i] = cube[2][0][i];
			cube[2][0][i] = cube[3][0][i];
			cube[3][0][i] = cube[4][0][i];
			cube[4][0][i] = temp;
			}
	}
	
	void rU() {
		rTurn90(0);
		for(int i=0;i<cube[0].length;i++) {
			String temp = cube[4][0][i];
			cube[4][0][i] = cube[3][0][i];
			cube[3][0][i] = cube[2][0][i];
			cube[2][0][i] = cube[1][0][i];
			cube[1][0][i] = temp;
			}
	}
	
	void R() {
		Turn90(3);
		for(int i=0;i<cube[3].length;i++) {
			String temp = cube[0][i][2];
			cube[0][i][2] = cube[2][i][2];
			cube[2][i][2] = cube[5][i][2];
			cube[5][i][2] = cube[4][cube[3].length-1-i][0];
			cube[4][cube[3].length-1-i][0] = temp;
			}
	}
	
	void rR() {
		rTurn90(3);
		for(int i=0;i<cube[3].length;i++) {
			String temp = cube[0][i][2];
			cube[0][i][2] = cube[4][cube[3].length-1-i][0];
			cube[4][cube[3].length-1-i][0] = cube[5][i][2];
			cube[5][i][2] = cube[2][i][2];
			cube[2][i][2] = temp;
			}
	}
	
	void L() {
		Turn90(1);
		for(int i=0;i<cube[1].length;i++) {
			String temp = cube[0][i][0];
			cube[0][i][0] = cube[4][cube[1].length-1-i][2];
			cube[4][cube[1].length-1-i][2] = cube[5][i][0];
			cube[5][i][0] = cube[2][i][0];
			cube[2][i][0] = temp;
			}		
	}
	
	void rL() {
		rTurn90(1);
		for(int i=0;i<cube[1].length;i++) {
			String temp = cube[0][i][0];
			cube[0][i][0] = cube[2][i][0];
			cube[2][i][0] = cube[5][i][0];
			cube[5][i][0] = cube[4][cube[1].length-1-i][2];
			cube[4][cube[1].length-1-i][2] = temp;
			}		
	}
	
	void B() {
		Turn90(4);
		for(int i=0;i<cube[4].length;i++) {	
			String temp = cube[0][0][i];
			cube[0][0][i] = cube[3][i][2];
			cube[3][i][2] = cube[5][2][cube[4].length-1-i];
			cube[5][2][cube[4].length-1-i] = cube[1][cube[4].length-1-i][0];
			cube[1][cube[4].length-1-i][0] = temp;
			
			}
	}
	
	void rB() {
		rTurn90(4);
		for(int i=0;i<cube[4].length;i++) {
			String temp = cube[0][0][i];
			cube[0][0][i] = cube[1][cube[4].length-1-i][0];
			cube[1][cube[4].length-1-i][0] = cube[5][2][cube[4].length-1-i];
			cube[5][2][cube[4].length-1-i] = cube[3][i][2];
			cube[3][i][2] = temp;
			}
	}
	
	void D() {
		Turn90(5);
		for(int i=0;i<cube[5].length;i++) {
			String temp = cube[1][2][i];
			cube[1][2][i] = cube[4][2][i];
			cube[4][2][i] = cube[3][2][i];
			cube[3][2][i] = cube[2][2][i];
			cube[2][2][i] = temp;
			}
	}
	
	void rD() {
		rTurn90(5);
		for(int i=0;i<cube[5].length;i++) {
			String temp = cube[1][2][i];
			cube[1][2][i] = cube[2][2][i];
			cube[2][2][i] = cube[3][2][i];
			cube[3][2][i] = cube[4][2][i];
			cube[4][2][i] = temp;
			}
	}
	
	// ����Ǯ�� - 6
	// �� ������ 90�� ȸ��
	void Turn90(int side) {
		int n = cube[side].length;
		int m = cube[side][0].length;		
		String[][] rotate = new String[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				rotate[i][j] = cube[side][n-1-j][i];
		}
	}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				cube[side][i][j] = rotate[i][j];
			}		
		}
	}
	
	// �� ������ 90�� ȸ��
	void rTurn90(int side) {
		int n = cube[side].length;
		int m = cube[side][0].length;		
		String[][] rotate = new String[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				rotate[i][j] = cube[side][j][n-1-i];
		}
	}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				cube[side][i][j] = rotate[i][j];
			}
		}
	}
	
	// ť�� ���� ��� �޼ҵ�
	void print(){
		System.out.println("            "+Arrays.toString(cube[0][0]));
		System.out.println("            "+Arrays.toString(cube[0][1]));
		System.out.println("            "+Arrays.toString(cube[0][2]));
		
		for(int i=0;i<cube[0].length;i++) {
			for(int j=1;j<cube.length-1;j++) {
				System.out.print(Arrays.toString(cube[j][i]));
			}
			System.out.println();
		}
		System.out.println("            "+Arrays.toString(cube[5][0]));
		System.out.println("            "+Arrays.toString(cube[5][1]));
		System.out.println("            "+Arrays.toString(cube[5][2]));
	}
	
	// ����Ǯ�� - 8
	// ť�갡 �ʱ� ���ĵ� ���¿� ��ġ�ϴ��� ���� Ȯ��
	boolean finish() {
		String[][][] init_cube = {{{"B0","B1","B2"},{"B3","B4","B5"},{"B6","B7","B8"}},{{"W0","W1","W2"},{"W3","W4","W5"},{"W6","W7","W8"}},{{"O0","O1","O2"},{"O3","O4","O5"},{"O6","O7","O8"}},{{"G0","G1","G2"},{"G3","G4","G5"},{"G6","G7","G8"}},{{"Y0","Y1","Y2"},{"Y3","Y4","Y5"},{"Y6","Y7","Y8"}},{{"R0","R1","R2"},{"R3","R4","R5"},{"R6","R7","R8"}}};
		int count=0;
		
		for(int i=0;i<init_cube.length;i++) {
			for(int j=0;j<init_cube[0].length;j++) {
				for(int k=0;k<init_cube[0][0].length;k++) {
					if(init_cube[i][j][k].equals(cube[i][j][k])) {	// �ʱ� ť��� ���� ť�� �� ��
						count++;
					}
				}
			}
		}
		if(count==54) {
			return true;
		} else {
			return false;
		}
	}
}

public class rubiks_cube {

	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();	// ���α׷� ��� �ð� üũ
		rubiks cube = new rubiks();
		Scanner scan = new Scanner(System.in);		// ����� �Է� �� ���� ��ü ����
		
		cube.init();	// ť�� �ʱ�ȭ �� ���� ����
		
		while(true) {
			System.out.print("CUBE> ");
			String input = scan.next();		// ����� �Է� �� ����

			if(cube.input(input)) {		// ��ȯ ���� True�� ��� ����
				System.out.println("�����մϴ� ��� ť�긦 ���߼̽��ϴ�.");
				break;
			} else if(input.contains("Q")) {
				break;
			}
		}
		scan.close();
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;	// ���� Ǯ�� - 8
		System.out.format("��� �ð� : %02d:%02d %n",secDiffTime/60,secDiffTime%60);	// �� : ��
		System.out.println("���� ���� : "+ cube.count);
		System.out.println("�̿��� �ּż� �����մϴ�.");
	}
}

