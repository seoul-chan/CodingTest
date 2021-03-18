package music.play.list.controller;

import music.play.list.model.MusicDao;

public class MusicController {
	private MusicDao muDao = new MusicDao();	
	
	public String[] musicList(){
		return muDao.musicList();
	}
	
	// �뷡 ���
	public void play(int input) {
		muDao.play(input);
	}
	
	// ���� �� ���
	public void priviusPlay() {
		muDao.priviusPlay();
	}
	
	// ���� �� ���
	public void nextPlay() {
		muDao.nextPlay();
	}	
	
	// ���� ����
	public void stop() {
		muDao.stop();
	}
	
	// �Ͻ����� �Ǵ� �ٽ� ���
	public void pause() {
		muDao.pause();
	}
	
	// �Ѱ� �ݺ� ���
	public void loop() {
		muDao.loop();
	}
}
