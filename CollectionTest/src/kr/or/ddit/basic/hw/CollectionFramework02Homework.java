package kr.or.ddit.basic.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CollectionFramework02Homework {
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
		Scanner sc = new Scanner(System.in);
		printLottoHome();
		System.out.println("메뉴를 선택해주세요.");
		int selectNo = sc.nextInt();
		
		if (selectNo == 1) {
			System.out.println("Lotto 구입시작");
			System.out.println("가격:1000원에 로또한장");
			System.out.println("금액을 입력해주세요");
			int money = sc.nextInt();
			int getlotto = money / 1000;
			int change = money - getlotto * 1000;
			// int change = money%1000;
			System.out.println("받은금액:" + money + "\t" + "거스름돈" + change);

			Set<Integer> lottoNum = new HashSet<Integer>();
			Random rd = new Random();
			for (int num = 1; num <= getlotto; num++) {
				System.out.print("로또번호" + num + ":");
				while (lottoNum.size() < 6) {
					lottoNum.add(rd.nextInt(45) + 1);
				}
				ArrayList<Integer> lottoList = new ArrayList<Integer>(lottoNum);
				Collections.sort(lottoNum);
				System.out.println("로또번호" + num + ":" + lottoList);
				lottoNum.clear();
			}
		}
		
	}
	private static void Lottonum(int price) {
		
	}

	public static void printLottoHome() {
		System.out.println("=================");
		System.out.println("Lotto 프로그램");
		System.out.println("-----------------");
		System.out.println("1.Lotto 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("=================");

	}
}
