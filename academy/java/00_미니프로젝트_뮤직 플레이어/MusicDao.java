package music.play.list.model;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicDao implements Runnable{
	private Scanner sc = new Scanner(System.in);
	private Clip clip = null;
	
	public MusicDao() {}
	
	@Override
	public void run() {	
		play(Thread.currentThread().getName());
	}
	
	public String[] musicList(){
		//���� ��ü��� ��������
		File path = new File("C:\\Users\\Chan\\Desktop\\Music\\");
		String[] fileList = path.list();
		for(int i=0;i<fileList.length;i++) {
			System.out.println(fileList[i]);
		}
		return fileList;
	}
	
	public void play(String fileName) {
		try {
			String path = "C:\\Users\\Chan\\Desktop\\Music\\"+fileName;
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
//			clip.loop(Clip.LOOP_CONTINUOUSLY);
			Thread.sleep((clip.getMicrosecondLength()/1000)); //�����带 �뷡 �ð����� ���߰� �����ν� �뷡 ���
							
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		} finally {
			mStop();
		}
	}
	
	public void mStop() {
		clip.stop();				
		clip.close();
		Thread.currentThread().interrupt();
	}
	
}