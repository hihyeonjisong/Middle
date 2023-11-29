package kr.or.ddit.basic;

public class T09ThreadDaemonTest {
	public static void main(String[] args) throws InterruptedException {
		Thread th = new AutoSaveThread();
		
		//데몬 스레드로 설정하기(start()호출하기 전에 설정해야한다.
		th.setDaemon(true);
		
		th.start();
		
		for (int i = 1; i <= 20; i++) {
			System.out.println("작업-"+i);
			Thread.sleep(1000);
		}
		System.out.println("메인스레드 종료..");
	}
}
//자동 저장기능을 제공하는 스레드(3초에 한번씩 저장하기)
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업내용을 저장합니다.");
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);//3초마다 저장
				save();//저장기능 호출
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
