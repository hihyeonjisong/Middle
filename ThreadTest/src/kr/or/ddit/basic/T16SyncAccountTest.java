package kr.or.ddit.basic;

public class T16SyncAccountTest {
	public static void main(String[] args) {
		SyncAccount sAcc = new SyncAccount();
		sAcc.deposit(10000);
		
		BankThread bth1 = new BankThread(sAcc);
		BankThread bth2 = new BankThread(sAcc);
		bth1.start();
		bth2.start();
	}
}

//은행의 입출금을 관리하기 위한 공유클래스
class SyncAccount {
	private int balance; // 잔액

	synchronized public int getBalance() {
		return balance;
	}

	// 입금처리를 수행하기 위한 메서드
	public void deposit(int money) {
		balance += money;
	}



	// 출금을 처리하기 위한 메서드(출금성공: true, 출금실패:false반환)
	// 동기화 영역에서는 호출하는 메서드도 동기화 처리를 해주어야 한다.
	synchronized public boolean withdraw(int money) {
		if (balance >= money) {
			for (int i = 1; i < 1000000000; i++) {
			}

			balance -= money;
			System.out.println("메서드안에서 balance = " + getBalance());
			return true;
		} else
			return false;
	}
}

//은행업무를 처리하는 스레드
class BankThread extends Thread {
	private SyncAccount sAcc;

	public BankThread(SyncAccount sAcc) {
		super();
		this.sAcc = sAcc;
	}
	
	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000);//6000원인출
		System.out.println("스레드안에서 result = "
				+result + ", balance = "+ sAcc.getBalance());
	}
	
}