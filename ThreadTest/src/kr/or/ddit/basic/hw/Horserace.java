package kr.or.ddit.basic.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Horserace {
	static int strRank = 1;
	public static int RANK;

	public static void main(String[] args) {
		List<MyHorse> hlist = new ArrayList<MyHorse>();

		hlist.add(new MyHorse("제니"));
		hlist.add(new MyHorse("본헤르"));
		hlist.add(new MyHorse("알마니"));
		hlist.add(new MyHorse("샤넬"));
		hlist.add(new MyHorse("디오르"));
		hlist.add(new MyHorse("안토니"));
		hlist.add(new MyHorse("구르찌"));
		hlist.add(new MyHorse("톰포드"));
		hlist.add(new MyHorse("알리"));
		hlist.add(new MyHorse("호올스"));

		for (MyHorse h : hlist) {
			h.start();	
		}
		
		while (true) { // 현재 달리는 위치 표시
			for (int i = 0; i < hlist.size(); i++) { // 말의 수 만큼
				System.out.println( hlist.size());//10
				System.out.print(hlist.get(i).getName2() + " : ");
//				if(list.get(i).getPosition() == 60) {
//					System.out.println();
//					continue;
//				}
				for (int j = 1; j <= 50; j++) {
					if (hlist.get(i).getPosition() == j) { // i번째 위치와 j번째 위치가 같으면
						System.out.print(">"); // 로 변환하고
						continue;// 다시 처음으로 올라가 포문을 돌린다.
					}else {System.out.print("-");} // 아니면 - 표시	
				}
				System.out.println();
			}

			try {
				Thread.sleep((int) (Math.random() * 301 + 200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int cnt = 0; // 말의 수
			for (int i = 0; i < hlist.size(); i++) {
				if (hlist.get(i).getState() == Thread.State.TERMINATED) { // 순서대로 스레드가 종료 되었어을때
					cnt++; // 스레드를 증가시킴
				}
			}
			if (cnt == 10) { // 10번까지 말이 다 들어오면 끝남
				break;
			}
			System.out.println("\n=======================================================================");
		}

		
		
		Collections.sort(hlist);
		System.out.println("경기끝 ....");
		System.out.println("======================================================");
		System.out.println();
		System.out.println(" 경기 결과 ");
		for (MyHorse myHorse : hlist) {
			// to string 으로 출력하면 편함
			System.out.println(myHorse);
		}

	}
}

class MyHorse extends Thread implements Comparable<MyHorse> {
	private String name;
	int rank;
	int position;// 말 위치

	// main에서 이름만 입력받기 때문에 생성자는 name만 만든다
	public MyHorse(String name) {
		super();
		this.name = name;
	}

	// ★왜 2라고 했을까(영상님)
	public String getName2() {
		return name;
	}

	public void setName2(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPosition() {
		return position;
	}

	
	public void setPosition(int position) {
		this.position = position;
	}

	// 말 순위 오름차순하기
	@Override
	public int compareTo(MyHorse mh) {
		return Integer.compare(this.getRank(), mh.getRank());
	}

	@Override
	public String toString() {
		return "MyHorse >>" + name + "/ " + rank+"등"  ;
	}

	@Override
	public void run() {

		for (int i = 0; i < 50; i++) {
			try {
				// 밀리세컨이라서(더 알아보기)
				Thread.sleep((int) (Math.random() * 501 + 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (position < 50) { // 말의 위치가 50보다 작으면 1씩 증가
				position++;

			}
		}
		System.out.println(">>" + name + " 도착!");
		setRank(Horserace.RANK++); // 말 순위를 플러스해서 담아줌

	}

}
