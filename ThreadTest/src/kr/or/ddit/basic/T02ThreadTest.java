package kr.or.ddit.basic;

public class T02ThreadTest {
	public static void main(String[] args) {
		
		//멀티스레드 프로그램방식...(start메서드가 호출:중요한역할)
		//context switching : cpu(리소스)가 1대라면 오히려 퍼포먼스가 느려질수있는 단점
	//방법1: Thread클래스를 상속한 클래스의 인스턴스를 생성한후
		//     이 인스턴스의 start()매서드를 호출한다.
		MyThread1 th1 = new MyThread1();//main스레드, mythread1스레드 
		th1.start();                    // 총 두개의 멀티스레드
		

		
		
		
	//방법2 : Runnable인터페이스를 구현한 클래스의 인스턴스를 생성한 후 
		//		이 인스턴스를 Thread클래스의 생성자 매개변수로 넘겨준다.
		//		이렇게 생성된 Thread객체의 start()매서드를 호출한다. -재사용 할수 있음
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();
	//방법3: 익명클래스를 이용하는 방법(클래스로 만들지 않고 인터페이스로 객체만든방법)
		//		Runnable인터페이스를 구현한 익명클래스를 이용하는 방법 -일회성 사용함
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					System.out.print("★");
					/*Thread.sleep(시간)=>주어진 시간동안 작업을 잠시 멈춘다
					시간은 밀리세컨드 단위를 사용한다
					즉, 1000은 1초를 의미한다.*/
					try {
						Thread.sleep(100); //0.1초
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		th3.start();
		
		
	}
}

//Thread를 상속한 MyThread1클래스
class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.print("*");
			/*Thread.sleep(시간)=>주어진 시간동안 작업을 잠시 멈춘다
			시간은 밀리세컨드 단위를 사용한다
			즉, 1000은 1초를 의미한다.*/
			try {
				Thread.sleep(100); //0.1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//인터페이스를 이용(Runnable은 run이란 추상메서드를 가짐)
class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.print("$");
			/*Thread.sleep(시간)=>주어진 시간동안 작업을 잠시 멈춘다
			시간은 밀리세컨드 단위를 사용한다
			즉, 1000은 1초를 의미한다.*/
			try {
				Thread.sleep(100); //0.1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
