package music.play.list.view;

import java.util.Scanner;

import music.play.list.controller.MemberController;
import music.play.list.controller.MusicController;
import music.play.list.model.Member;

public class MusicPlayer {
	Scanner sc = new Scanner(System.in);
	MusicController muCon = new MusicController();
	MemberController meCon = new MemberController();
	boolean pass = false;
	
	public void mainMenu(){
		meCon.loadMember();
		
		while(true) {
			System.out.println("\n====== Music Player ======");
			System.out.println(pass?"1. �α׾ƿ�":"1. �α���");
			System.out.print(pass?"2. ȸ�� ���� ����\n":"2. ȸ�� ����\n");
			System.out.println("3. ���� ���");
			System.out.println("4. ȸ�� Ż��");
			System.out.println("9. ���α׷� ����");
			System.out.print("����� �����ϼ��� : ");
			
			int input = sc.nextInt();
			
			switch(input) {
				case 1 :  {
					if(pass) logout();
					else login();					
					break;
				}
				case 2 :  {
					if(pass) updateMember();
					else signUp();
					break;
				}
				case 3 :  {
					if(pass) {
						playList(); 
						break;
					} else {
						System.out.println("�α����� �ʿ��� ���� �Դϴ�.");
						System.out.println("�α��� �� �̿��� �ּ���.");
						break;
					} //if-else		
				}//case 3
				case 4 :  signOut();break;
				case 9 : {
					System.out.println("���α׷��� �����մϴ�.");
					meCon.saveMember();
					System.exit(0);
				}
				default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
	}
	
	public void login() {
		System.out.println("\n====== Music Player ======");
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("Password : ");
		String password = sc.next();
		
		if(meCon.logIn(id, password)) {
			System.out.println("�������.");
			pass = true;
		} else {
			System.out.println("���̵� �Ǵ� ��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
		}
	}
	
	public void logout() {
		System.out.println("�α� �ƿ��� �Ͻðڽ��ϱ�??(Y/N)");
		String out = sc.next();
		if(out.toUpperCase().equals("Y")) {
			pass = false;
			meCon.logOut();
			System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		}
			
	}
	
	public void signUp() {
		System.out.print("�̸��� �Է��� �ּ��� : ");
		String name = sc.next();
		
		System.out.print("���̵� �Է��� �ּ��� : ");	//ID �ߺ� Ȯ�� ���� �ʿ�
		String id = sc.next();
		
		String password="";
		while(true) {
			System.out.print("�н����带 �Է��� �ּ��� : ");
			String oldPw = sc.next();
			System.out.print("�н����带 �ѹ� �� �Է��� �ּ��� : ");
			password = sc.next();
			if(oldPw.equals(password)) 
				break;
			else
				System.out.println("�н����尡 ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		}
		System.out.print("�ڵ��� ��ȣ�� �Է��� �ּ��� : ");
		String phone = sc.next();
		System.out.print("�ּҸ� �Է��� �ּ��� : ");
		String address = sc.next();
		
		Member m = new Member(name, id, password, phone, address);
		meCon.signUp(m);
		System.out.println("ȸ�������� ���ϵ帳�ϴ�~!!");
	}
	
	public void updateMember() {
		Member mem = new Member();
		
		System.out.println("==== ȸ������ ���� �޴� ====");
		while(true) {
			System.out.println("������ ���ϴ� �׸��� �Է��ϼ���. ");
			System.out.println("1. ���̵�");
			System.out.println("2. ��й�ȣ");
			System.out.println("3. �ڵ�����ȣ");
			System.out.println("4. �ּ�");
			System.out.println("0. ���� ����");
			int cho = sc.nextInt();
			
				switch(cho) {
					case 1 :System.out.print("���̵� �Է��ϼ��� : ");
							mem.setId(sc.next());break;
					case 2 :System.out.print("��й�ȣ�� �Է��ϼ��� : ");
							mem.setPassword(sc.next());break;
					case 3 :System.out.print("�ڵ�����ȣ�� �Է��ϼ��� : ");
							mem.setPhone(sc.next());break;
					case 4 :System.out.print("�ּҸ� �Է��ϼ��� : ");
							mem.setAddress(sc.next()); break; 
					case 0 : return;
				}
			}
	}
	
	public void playList() {		
		while(true) {				
			System.out.println("\n===== ��� ��� =====");
			System.out.println("1. test");
			System.out.println("2. test2");
			System.out.println("3. test3");
			System.out.println("4. test4");
			System.out.println("5. SG Wannabe Brown Eyed Girls - Must Have Love");
			System.out.println("8. �뷡 ����");
			System.out.println("9. ���� �޴�");
			System.out.print("����Ϸ��� ���� ������ �����ϼ��� : ");
			
			int input = sc.nextInt();
			if(input==9) {
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			}
			muCon.play(input);
		}
	}
	
	public void signOut() {
		System.out.println("ȸ�� Ż�� �޴� �Դϴ�.");
		System.out.println("Ż���Ͻðڽ��ϱ�.(Y/N)");
		String out = sc.next();
		
		if(out.toUpperCase().equals("Y")) {
			System.out.println("������ Ż���Ͻðڽ��ϱ�?!!(Y/N)");
			out = sc.next();
			if(out.toUpperCase().equals("Y")) {
				pass = false;
				System.out.println("ȸ�� Ż�� �Ϸ� �Ǿ����ϴ�.");
				System.out.println("�̿��� �ּż� �����մϴ�.");
				meCon.signOut();
			}
		}
	}
}
