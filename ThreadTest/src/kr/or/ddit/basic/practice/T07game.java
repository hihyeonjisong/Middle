package kr.or.ddit.basic.practice;

import javax.swing.JOptionPane;

public class T07game {
	public static boolean inputCheck = false;
	public static String man ="";
	
	public static void main(String[] args) {
		
		DataInput1 input = new DataInput1();
		
//		Runnable c = new Chk();
//		Thread chk = new Thread(c);
		
		Runnable cd = new CountDown1();
		Thread countdown = new Thread(cd);
		
		String[] data = {"가위","바위", "보"};
		int index =(int) (Math.random()*3);
		//컴퓨터 랜덤 가위바위보 설정
		String com = data[index];
		
		//카운트다운 Thread 시작
		countdown.start();
		
		//사용자 가위바위보 입력 Thread시작
		input.start();
		try {
			input.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//결과 판정하기
		String result = "";
		if(man.equals(com)) {
			result = "비겼습니다.";
		}else if((man.equals("가위")&& com.equals("보"))
				||(man.equals("바위") && com.equals("가위"))
				||(man.equals("보") && com.equals("바위"))) {
			result = "당신이 이겼습니다.";
		}else {
			result = "당신이 졌습니다.";
		}
		
		System.out.println("===결과===");
		System.out.println("컴퓨터 : " + com);
		System.out.println("당  신 : " + man);
		System.out.println("결  과 : " + result);

	}
}

//사용자 입력처리
class DataInput1 extends Thread{
	@Override
	public void run() {
		String inputData ="";
		do {//JOptionPane.showInputDialog 메서드는 다이얼로그 상자를 통해 사용자로부터 문자열 입력을 받습니다
			inputData = JOptionPane.showInputDialog("가위, 바위, 보를 입력하세요");
		} while (!inputData.equals("가위") && !inputData.equals("바위") && !inputData.equals("보"));
		T07game.inputCheck = true;// 입력이 완료됨을 알려주는 변수값을 변경한다.
		T07game.man = inputData;//  입력값 설정
	}
}


//카운트다운
class CountDown1 implements Runnable {

	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if(T07game.inputCheck==true) {
				return;
			}
			//5.4.3.2.1...초 출력
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("시간이 초과되어 당신이 졌습니다.");
		
		System.exit(0);//일반적으로 정상 종료일 경우 0으로 지정
		
	}
	
}
