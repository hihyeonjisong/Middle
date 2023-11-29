package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T07game {
	public static void main(String[] args) {
		Thread th1 = new DataInput1();
		Thread th2 = new CountDown1();
		Thread th3 = new Chk();
		
		th1.start();
		th2.start();
		th3.start();
	}

}

class DataInput1 extends Thread{
	@Override
	public void run() {
		String str =JOptionPane.showInputDialog("아무거나 입력하세요.");
		System.out.println("컴퓨터는 보를 입력했습니다");
		System.out.println("입력한 값은 " + str + "입니다.");
	}
}
class Chk extends Thread{
	@Override
	public void run() {
		if(new DataInput1().equals("보")) {
			System.out.println("결과:비겼습니다");
		}else if(new DataInput1().equals("가위")) {
			System.out.println("결과:당신이이겼습니다");	
		}else if(new DataInput1().equals("주먹")) {
			System.out.println("결과:당신이졌습니다");			
		}
	}
}

class CountDown1 extends Thread{
	@Override
	public void run() {
		for (int i = 5; i >=1; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
