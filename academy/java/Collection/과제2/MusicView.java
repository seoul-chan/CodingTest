package com.kh.practice.list.music.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.model.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("****** ���� �޴� *****");
			System.out.println("1. ������ ��ġ�� �� �߰�");
			System.out.println("2. ù ��ġ�� �� �߰�");
			System.out.println("3. ��ü �� ��� ���");
			System.out.println("4. Ư�� �� �˻�");
			System.out.println("5. Ư�� �� ����");
			System.out.println("6. Ư�� �� ���� ����");
			System.out.println("7. ��� �������� ����");
			System.out.println("8. ������ �������� ����");
			System.out.println("9. ����");
			System.out.print("�޴� ���� : ");
			try {
				switch(sc.nextInt()) {
				case 1: addList(); break;
				case 2: addAtZero(); break;
				case 3: printAll(); break;
				case 4: searchMusic(); break;
				case 5: removeMusic(); break;
				case 6: setMusic(); break;
				case 7: ascTitle(); break;
				case 8: descSinger(); break;
				case 9: System.out.println("����"); return;
				default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}
			} catch(InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				sc.nextLine();
			}
		}				
	}
	
	public void addList() {
		System.out.println("\n****** ������ ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.next();
		System.out.print("���� �� : ");
		String singer = sc.next();
		
		Music music = new Music(title, singer);		
		System.out.println(mc.addList(music)==1?"�߰� ����":"�߰� ����");
	}
	
	public void addAtZero() {
		System.out.println("\n****** ù ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.next();
		System.out.print("���� �� : ");
		String singer = sc.next();
		
		Music music = new Music(title, singer);		
		System.out.println(mc.addAtZero(music)==1?"�߰� ����":"�߰� ����");
	}
	
	public void printAll() {
		System.out.println("\n****** ��ü �� ��� ��� ******");
		List<Music> list = mc.printAll();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void searchMusic() {
		System.out.println("\n****** Ư�� �� �˻� ******");
		System.out.print("�� �� : ");
		String title = sc.next();
		Music m = mc.searchMusic(title); 
		if(m!=null)
			System.out.println("�˻��� ���� "+m.getTitle()+", "+m.getSinger()+"�Դϴ�.");
		else
			System.out.println("�˻��� ���� �����ϴ�.");		
	}
	
	public void removeMusic() {
		System.out.println("\n****** Ư�� �� ���� ******");
		System.out.print("�� �� : ");
		String title = sc.next();
		Music m = mc.removeMusic(title);
		if(m!=null)
			System.out.println(m.getTitle()+", "+m.getSinger()+"�� ���� �߽��ϴ�.");
		else
			System.out.println("������ ���� �����ϴ�.");	
	}
	
	public void setMusic() {
		System.out.println("\n****** Ư�� �� ���� ���� ******");
		System.out.print("������ �� �� : ");
		String title = sc.next();
		System.out.print("������ ���� �� : ");
		String singer = sc.next();
		
		Music m = mc.setMusic(title, singer);
		if(m!=null)
			System.out.println(m.getTitle()+", "+m.getSinger()+"�� ���� ���� �Ǿ����ϴ�.");
		else
			System.out.println("������ ���� �����ϴ�.");	
	}
	
	public void ascTitle() {
		System.out.println(mc.ascTitle()==1?"���ļ���":"���� ����");
	}
	
	public void descSinger() {
		System.out.println(mc.descSinger()==1?"���ļ���":"���� ����");
	}
	
}
