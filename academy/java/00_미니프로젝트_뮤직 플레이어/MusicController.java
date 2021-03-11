package music.play.list.controller;

import java.util.Scanner;

import music.play.list.model.Member;
import music.play.list.model.MusicDao;

public class MusicController {
	private Scanner sc = new Scanner(System.in);
	private MusicDao muDao = new MusicDao();	
	private Thread t = null;
	private boolean privius = false; //������ ����ǰ� �ִ� �� ����
	private int current = 0;	//���� ������� �뷡 ����
	private String[] musicList=null;
	
	public String[] musicList(){
		musicList = muDao.musicList();
		return musicList;
	}
	
	public void play(int input) {
		String fileName=musicList[--input];
		current=input;
		
//		switch(input) {
//			case 1 : fileName= "SG Wannabe Brown Eyed Girls - Must Have Love"; break;
//			case 2 : fileName= "test"; break;
//			case 3 : fileName= "test2"; break;
//			case 4 : fileName= "test3"; break;
//			case 5 : fileName= "test4"; break;
////			case 8 : muDao.mStop(); break;
//			default : System.out.println("�߸� �Է��Ͽ����ϴ�.");
//		}
		
		/// ���� �̿��� ���� �Է¹޾� ���� ���� ������ �Ѿ�µ�
		//  ���� ���Ѱ� �ɷ� ���ϴ� ���� ����
		if(input<=0&&input>musicList.length)
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
		
		if(input!=8){
			if(!privius) {
				t = new Thread(muDao,fileName);
				t.start();
				privius = true;
			} else {
				stop();
				t = new Thread(muDao,fileName);
				t.start();
			}
		}
	}
	
	public void priviusPlay() {
		if(!privius) {	//������̴� ���� ���� ��� ������ �� ���
			play(musicList.length);
		} else {		//������̴� ���� �ִ� ��� ���� �� ���
			if(current==1) // ������̴� ���� ó�� ���� ���
				play(musicList.length);
			else
				play(++current);
		}
	}
	
	public void nextPlay() {
		if(!privius) {	//������ ������̴� ���� ���� ��� ������ ù ���
			play(1);
		} else {		//������ ������̴� ���� �ִ� ��� ���� �� ���
			if(current==musicList.length) // ������̴� ���� ������ ���� ���
				play(1);
			else
				play(++current);
		}
	}	
	
	public void stop() {
		muDao.mStop();
	}
}
