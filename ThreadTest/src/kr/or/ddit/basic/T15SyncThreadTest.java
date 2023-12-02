package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		WorkThread wTh1 = new WorkThread("1번스레드",sObj);
		WorkThread wTh2 = new WorkThread("2번스레드",sObj);
		wTh1.start();
		wTh2.start();
	}
}

//공유객체로 사용할 클래스
class ShareObject {
	private int sum =0;

	//synchronized 동기화 처리방법1 : 메서드 자체에 동기화 설정하기
	//(깔끔하게 교통정리해줌)
	public synchronized void add() {
		
		//동기화 처리방법2: 동기화 블럭 설정하기
		//mutex : Mutual Exclusion Object(상호배제 : 동시접근차단)
		//synchronized (this) {
			
		for (int i = 0; i < 1000000000; i++) {}//시간벌기용
		int n = sum;
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName()
				+"합계: "+sum);
		//}
	}
}

class WorkThread extends Thread {
	private ShareObject sObj;
	
	public WorkThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized (sObj) {
				sObj.add();
			}
		}
	}
}
