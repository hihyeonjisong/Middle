package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 * 멀티스레드를 활용한 사용자 입력처리
 * 
 * @author PC-11
 *
 */
public class T06ThreadTest {
	//사용자 입력여부 체크용 변수
	public static boolean Input_Chk = false;
	
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
	}
}

/**
 * 사용자 입력을 받기위한 스레드
 * 
 * @author PC-11
 *
 */
class DataInput extends Thread {
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		//클래스명 . 사용자입력체크 =>true로 바꿔줌
		T06ThreadTest.Input_Chk = true;
		
		System.out.println("입력한 값은 " + str + "입니다.");
	}
}

/**
 * 카운트다운처리를 위한 스레드
 * @author PC-11
 *
 */
class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			//입력이 완료되었는지 여부를 검사하고 완료되면
			//run()메서드를 종료시킨다.
			if(T06ThreadTest.Input_Chk) {
				//메서드가 종료되면 해당 스레드로 종료된다.
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//10초가 경과되었는데도 입력이 없으면 프로그램을 종료한다.
		System.out.println("10초가 지났습니다.프로그램을 종료합니다.");
		//프로그램을 종료시키는 명령
		System.exit(0);
	}
}
