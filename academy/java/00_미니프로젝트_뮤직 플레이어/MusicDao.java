package music.play.list.model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicDao {
	private static Clip clip = null;	//���� ���� ��Ʈ��
	private static boolean privius = false; //������ ����ǰ� �ִ� �� ����
	private static int current = 0;	//���� ������� �뷡 ����
	private static boolean playState = false; // ���� ��� ������ Ȯ��
	private static boolean loop = false; //���� �Ѱ� �ݺ� ��� ������ Ȯ��
	private static String[] musicList=null;	//���� ���
	private static Timer timer = null;	//���� �� ��� �뵵 ������
	
	public MusicDao() {}
	
	public static Clip getClip() {return clip;}
	public static Timer getTimer() {return timer;}

	//���� ��ü��� ��������
	public String[] musicList(){
		File path = new File("Music\\");
		musicList = path.list();
		return musicList;
	}
	
	// ���� ���
	public static  void play(int input) {
		try {
			if(input<0||input>=musicList.length){
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				return;
			}
			
			stop();		// ���� �뷡 ���� �� �뷡 ���
			current=input;
			privius=true;		
			playState=true;
			
			String path = "Music\\"+musicList[input];
			//������ ����� �Է� ��Ʈ���� ��ȯ�� ����� �Է� ��Ʈ���� ����Ѵ�.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));	
			clip = AudioSystem.getClip();	// ����� ��Ʈ���� ����ϴµ� ����� �� �ִ� ������ �ͼ����� Ŭ���� �����´�.
			clip.open(audioInputStream);	// ������ ����� �Է� ��Ʈ������ ���õǰ� �ִ� ���� �� ����� �����ͷ� Ŭ���� ����. 
			clip.start();
			
			if(loop) {	// ���� �뷡���� �Ѱ� �ݺ� �ɼ��� �����Ǿ� �ִ� ��� �ɼ� ������ ���� ���, clip.loop�� stop�� �ڵ� �����Ǳ� ����.
				loop=false;
				loop();
			}
			
			timer = new Timer();	// ���� ������ �Ѿ�� ���� ������ (���� ������)
			timer.start();
			
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	// ���� �� ���
	public void priviusPlay() {
		stop();
		if(!privius||current==0) {	//������̴� ���� ���ų� ������̴� ���� ó�� ���� ��� ������ �� ���
			play(musicList.length-1);
		} else {		//������̴� ���� �ִ� ��� ���� �� ���
			play(--current);
		}
	}
	
	// ���� �� ���
	public static void nextPlay() {
		stop();
		if(!privius||current==musicList.length-1) {	//������ ������̴� ���� ���ų� ������̴� ���� ������ ���� ��� ������ ù ���
			play(0);
		} else {		//������ ������̴� ���� �ִ� ��� ���� �� ���
			play(++current);
		}
	}
	
	// �뷡 ����
	public static void stop() {	
		try {
			playState = false;
			clip.close();
			timer.finish();
		} catch(NullPointerException e) {	// ��� ���� �ƴҶ� stopȣ�� �� ����ó��
			
		}	
	}
	
	// �Ͻ� ���� / ���
	public void pause() {
		if(playState) {	//���� ��� ���̸� stop
			playState = false;
			clip.stop();
		}
		else { //���� stop ���̸� ���
			playState = true;
			clip.start();	
		}
	}
	
	// �Ѱ� �ݺ� ���
	public static  void loop() {
		try {
			if(loop) {
				clip.stop();	// clip�� �����Ǹ� loop�� �ڵ� �����ȴ�.
				if(playState)	// ��� �� �̿��� ��� start() ȣ�� (�̾ ���)
					clip.start();
				loop=false;
				System.out.println("�Ѱ� �ݺ� ��� ����");
			} else {
				clip.loop(Clip.LOOP_CONTINUOUSLY);	 //������ ��ġ�κ��� ���� ����� �����Ѵ�.
				loop=true;							//clip.loop�� ���� ���� �� �ٸ� loop������ ������ ���õȴ�.
				if(!playState)		//��� ���� �ƴϿ��� ��� stop ȣ��
					clip.stop();	// �뷡 ��� ���� �ƴ� �� loopȣ�� �� �뷡�� ��� ��
				System.out.println("�Ѱ� �ݺ� ��� ���� ��");
			}	
		} catch(NullPointerException e) {
			
		}
	}	
}