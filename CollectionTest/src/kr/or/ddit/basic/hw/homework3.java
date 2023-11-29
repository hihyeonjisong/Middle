package kr.or.ddit.basic.hw;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.HashSet;
	import java.util.Random;
	import java.util.Scanner;
	import java.util.Set;

	public class homework3 {
		/*
		 * 로또를 구매하는 프로그램 작성하기
		 * 
		 * 사용자는 로또를 구매할 때 구매할 금액을 입력하고 입력한 금액에 맞게 로또번호를 출력한다. (단, 로또 한장의 금액은 1000원이고
		 * 거스름돈도 계산하여 출력한다.)
		 * 
		 * ========================== Lotto 프로그램 -------------------------- 1. Lotto 구입
		 * 2. 프로그램 종료 ========================== 메뉴선택 : 1 <-- 입력
		 * 
		 * Lotto 구입 시작
		 * 
		 * (1000원에 로또번호 하나입니다.) 금액 입력 : 2500 <-- 입력
		 * 
		 * 행운의 로또번호는 아래와 같습니다. 로또번호1 : 2,3,4,5,6,7 로또번호2 : 20,21,22,23,24,25
		 * 
		 * 받은 금액은 2500원이고 거스름돈은 500원입니다.
		 * 
		 * ========================== Lotto 프로그램 -------------------------- 1. Lotto 구입
		 * 2. 프로그램 종료 ========================== 메뉴선택 : 2 <-- 입력
		 * 
		 * 감사합니다
		 */
		public static void main(String[] args) {
			new homework3().printLotto();

			Scanner sc = new Scanner(System.in);
			System.out.println("메뉴선택");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				printbuy();
				System.out.println("(1000원에 로또 번호 하나입니다.)");
				System.out.println("지불할 금액을 입력하세요.");
				int price = sc.nextInt();
				if (price < 1000) {
					System.out.println("금액이 너무 적습니다. 다시입력해주세요");
					printbuy();
				} else {
					Lottonum(price);
					System.out.println("받은 금액은" + price + "이고 거스름돈은 " + price % 1000 + "입니다");
				}
				break;
			case 2:
				printend();
				break;
			default:
				System.out.println("올바르지 않은 선택 입니다.");
				break;
			}

		}

		private static void Lottonum(int price) {

			int count = price / 1000;
			Set<Integer> intRnd = new HashSet<Integer>();
			Random rnd = new Random();

			for (int i = 1; i <= count; i++) {

				while (intRnd.size() < 6) {
					intRnd.add(rnd.nextInt(45) + 1); // 1 ~ 45 사이의 난수
				}

				ArrayList<Integer> lottoList = new ArrayList<Integer>(intRnd);
				Collections.sort(lottoList);
				System.out.println("로또번호" + i + " : " + lottoList);
				intRnd.clear();
			}
		}

		public void printLotto() {
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");

		}

		public static void printbuy() {
			System.out.println("==========================");
			System.out.println("Lotto 구입시작");
			System.out.println("--------------------------");
			System.out.println("로또 1줄2에 1000원 입니다.");
			System.out.println("==========================");

		}

		public static void printend() {
			System.out.println("==========================");
			System.out.println("감사합니다.");
			System.out.println("==========================");

		}

	}

