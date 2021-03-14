package music.play.list.controller;

import music.play.list.model.MusicDao;

public class MusicController {
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
		if(input<0||input>=musicList.length){
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				return;
		}
		
		String fileName=musicList[input];
		current=input;		
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
	
	public void priviusPlay() {
		if(!privius||current==0) {	//������̴� ���� ���ų� ������̴� ���� ó�� ���� ��� ������ �� ���
			play(musicList.length-1);
		} else {		//������̴� ���� �ִ� ��� ���� �� ���
			play(--current);
		}
	}
	
	public void nextPlay() {
		if(!privius||current==musicList.length-1) {	//������ ������̴� ���� ���ų� ������̴� ���� ������ ���� ��� ������ ù ���
			play(0);
		} else {		//������ ������̴� ���� �ִ� ��� ���� �� ���
			play(++current);
		}
	}	
	
	public void stop() {
		muDao.mStop();
	}
	
	public void pause() {
		muDao.pause();
	}
	
	public void tempPlay() {
		muDao.tempPlay();
	}
}
