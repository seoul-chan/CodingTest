package music.play.list.model;

public class Timer extends Thread{
	boolean interruptFlag = false;
	
	@Override
	public void run() {
		while(true) {
			try {
				//���� Ŭ�� ��ġ, �� Ŭ�� ����(��ġ) ���Ͽ� ���� ��� ���� �� ���
				if(MusicDao.getClip().getMicrosecondPosition()==MusicDao.getClip().getMicrosecondLength()) {
					MusicDao.nextPlay();
				}
				if(interruptFlag==true) return;		//������ ����
				Thread.sleep(2000);	//1000ms : 1�� ���� 
			} catch (InterruptedException e) {
				MusicDao.getTimer().interrupt();
			}
		}
	}
	
	public void finish() {
		this.interruptFlag = true;
	}
}
