package music.play.list.model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicDao {
	private static Clip clip = null;
	private static boolean privius = false; //������ ����ǰ� �ִ� �� ����
	private static int current = 0;	//���� ������� �뷡 ����
	private static boolean playState = false; // ���� ��� ������ Ȯ��
	private static String[] musicList=null;
	private static Timer timer = null;
	
	public MusicDao() {}
	
	public static Clip getClip() {return clip;}
	public static Timer getTimer() {return timer;}

	public String[] musicList(){
		//���� ��ü��� ��������
		File path = new File("C:\\Users\\Chan\\Desktop\\Music\\");
		musicList = path.list();
		for(int i=0;i<musicList.length;i++) {
			System.out.println(musicList[i]);
		}
		return musicList;
	}
	
	public static void play(int input) {
		try {
			current=input;
			privius=true;
			
			if(playState) stop();
			playState=true;
			
			if(input<0||input>=musicList.length){
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				return;
			}	
			
			String path = "C:\\Users\\Chan\\Desktop\\Music\\"+musicList[input];
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();	
			clip.open(audioInputStream);
//			clip.loop(Clip.LOOP_CONTINUOUSLY); // ���� �Ѱ� �ݺ� ��� �� ���� ����
			clip.start();
			
			timer = new Timer();
			timer.start();
			
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	public void priviusPlay() {
		stop();
		if(!privius||current==0) {	//������̴� ���� ���ų� ������̴� ���� ó�� ���� ��� ������ �� ���
			play(musicList.length-1);
		} else {		//������̴� ���� �ִ� ��� ���� �� ���
			play(--current);
		}
	}
	
	public static void nextPlay() {
		stop();
		if(!privius||current==musicList.length-1) {	//������ ������̴� ���� ���ų� ������̴� ���� ������ ���� ��� ������ ù ���
			play(0);
		} else {		//������ ������̴� ���� �ִ� ��� ���� �� ���
			play(++current);
		}
	}
	
	public static void stop() {	
		try {
			playState = false;
			clip.close();
			timer.finish();
		} catch(NullPointerException e) {
			
		}
		
	}
	
	// ������ ������̴� ���� ������ ù�� ��� �����ϱ�
	public void pause() {
		if(playState) {
			playState = false;
			clip.stop();
		}
		else {
			playState = true;
			clip.start();	
		}
	}
}