package kr.or.ddit.basic;

public class T01ThreadTest {
	public static void main(String[] args) {
		
		//싱글스레드 프로그램..
		for (int i = 0; i < 200; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i  = 0; i < 200; i++) {
			System.out.print("$");
		}
	}
}
