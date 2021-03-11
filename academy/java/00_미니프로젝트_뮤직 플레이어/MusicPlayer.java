package music.play.list.view;

import java.util.ArrayList;
import java.util.Scanner;

import music.play.list.controller.MemberController;
import music.play.list.controller.MusicController;
import music.play.list.model.Member;

public class MusicPlayer {
	private Scanner sc = new Scanner(System.in);
	private MusicController muCon = new MusicController();
	private MemberController meCon = new MemberController();
	private boolean pass = false;	//���� �α��λ��� ����
	
	public void mainMenu(){
		meCon.loadMember();
		
		while(true) {
			System.out.println("\n====== Music Player ======");
			System.out.println("1. �α���");
			System.out.println("2. ȸ�� ����");
			System.out.println("3. ���� ���");
			System.out.println("9. ���α׷� ����");
			System.out.print("����� �����ϼ��� : ");
			
			int input = sc.nextInt();
			switch(input) {
				case 1 : login(); break;
				case 2 : signUp();break;
				case 3 : playList(); break;		
				case 9 : exit(); break;
				default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
	}
	
	public void loginMenu(){		
		while(true) {
			System.out.println("\n====== Music Player ======");
			System.out.println("1. �α׾ƿ�");
			System.out.println("2. ȸ�� ���� ����");
			System.out.println("3. ���� ���");
			System.out.println("7. �� ���� Ȯ��");
			System.out.println("8. ȸ�� Ż��");
			System.out.println("9. ���α׷� ����");
			System.out.print("����� �����ϼ��� : ");
			
			int input = sc.nextInt();
			
			switch(input) {
				case 1 : {
					logout(); 
					if(!pass) return;
					else break;
				}
				case 2 : updateMember(); break;
				case 3 : playList(); break;
				case 7 : myInfo(); break;
				case 8 : {
					signOut();
					if(!pass) return;
					else break;
				}
				case 9 : exit(); break;
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
			loginMenu();
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
		
		String id="";
		while(true) {
			
			System.out.print("���̵� �Է��� �ּ��� : ");
			id = sc.next();
			if(!meCon.dupliId(id)) break;
				else System.out.println("�ߺ��Ǵ� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
		}
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
		meCon.saveMember();
		System.out.println("ȸ�������� ���ϵ帳�ϴ�~!!");
	}
	
	public void myInfo() {
		Member m = meCon.myInfo();
		System.out.println("\n======= �� ���� =======");
		System.out.println("�̸� : "+m.getName());
		System.out.println("���̵� : "+m.getId());
		System.out.println("�ڵ��� ��ȣ : "+m.getPhone());
		System.out.println("�ּ� : "+m.getAddress());
		
	}
	
	public void updateMember() {
		Member mem = new Member();
		
		while(true) {
			System.out.println("\n==== ȸ������ ���� �޴� ====");
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
			meCon.updateMember(mem);
			
			}
	}
	
	public void playList() {
		String[] fileList = muCon.musicList();
		
		while(true) {
			System.out.println("\n===== ��� ��� =====");
			for(int i=0;i<fileList.length;i++) {
				System.out.println(i+1+". "+fileList[i].substring(0, fileList[i].indexOf(".")));
			}			
			
			System.out.println("===== �÷��� �޴� =====");
			System.out.println("6. ���� ��");
			System.out.println("7. ���� ��");
			System.out.println("8. �뷡 ����");
			System.out.println("9. ���� �޴�");
			System.out.print("����Ϸ��� ���� ������ �����ϼ��� : ");
			
			int input = sc.nextInt();
			
			switch(input) {
				case 6 : muCon.priviusPlay();break;
				case 7 : muCon.nextPlay();break;
				case 8 : muCon.stop();break;
				case 9 : {
					System.out.println("���� �޴��� ���ư��ϴ�.");
					return;
				}
				default : {
					if(pass) muCon.play(input);
					else System.out.println("�α����� �ʿ��� �����Դϴ�.");
				}
			}
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
	
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		meCon.saveMember();
		System.exit(0);
	}
}
