package kr.or.ddit.basic;

import javax.print.DocFlavor.STRING;

public class T04ThreadTest {
/*
 * 1~20억까지의 합계를 구하는데 걸린 시간 체크해보기
 * 전체합계를 구하는 작업을 단독스레드로 처리했을때와 
 * 여러스레드로 작업을분할해서 처리했을때의 시간을 확인해보자.
 */
	public static void main(String[] args) {
		//단독처리할때..
		SumThread sm = new SumThread(1, 2000000000L);
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리할때의 처리시간(ms) : "
				+(endTime - startTime));
		System.out.println();
		System.out.println();
		/////////////////////////////
		
		//여러스레드로 협력해서 처리했을때..
		SumThread[]sumThs = new SumThread[] {
				new SumThread(1L, 50000000L),
				new SumThread(500000001L, 100000000L),
				new SumThread(1000000001L, 1500000000L),
				new SumThread(1500000001L, 200000000L),				
		};
		
		startTime = System.currentTimeMillis();
		
		for (Thread th : sumThs) {
			th.start();
		}
		for (Thread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("협력처리했을때의 처리시간(ms): "
				+ (endTime - startTime));
	}
}
class SumThread extends Thread{
	private long min,max;
	
	
	public SumThread(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		long sum = 0;
		for (long i = min; i<=max ; i++) {
			sum += i;
		}
		System.out.println(min+"~"+max+"까지의합:"+sum);
	}
	
}
