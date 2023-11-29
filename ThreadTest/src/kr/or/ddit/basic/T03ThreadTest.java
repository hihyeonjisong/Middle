package kr.or.ddit.basic;

/**
 * 스레드 수행시간 체크해보기(방법2)
 * @author PC-11
 *
 */
public class T03ThreadTest {
	public static void main(String[] args) {
		//1.Thread객체를 만든다
		Thread th1 = new Thread(new MyRunner());
		//UTC(Universal Time Coordinated 협정세계 표준시)를 사용하여
		//1970년 1월1일0시0분0초를 기준으로 경과한 시간을 밀리세컨드 단위로 나타낸다.
		long startTime = System.currentTimeMillis();
		th1.start();
		try {
			//현재 실행중인 스레드에서 작업중인 스레드가 종료될때까지 기다린다
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간(ms): "
				+ (endTime-startTime));
	}
}

//1~1000000000까지의 합계를 구하는 스레드
class MyRunner implements Runnable {
	@Override
	public void run() {
		long sum=0;
		for (int i = 0; i < 1000000000; i++) {
			sum+=i;
		}
		System.out.println("합계: "+sum);
		
	}
	
}
