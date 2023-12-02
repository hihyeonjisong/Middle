package kr.or.ddit.basic.practice;

public class T11DisplayCharacter {
	/*
	 3개(명)의 스레드가 각각 알파벳 대문자를 출력하는데...
	 출력을 끝낸 순서대로 결과를 출력하는 프로그램 작성하기
	 */
	public static void main(String[] args) {
		
	}
}

//
class Display {
	private String name;
	private int rank;
	//name이 한 번 설정되면 그 이후에 변경되지 않기 때문에 setter 메서드가 필요하지 않으며, 생성자에서 초기화하는 것으로 충분합니다. 
	//반면에 rank는 중간에 변경될 수 있을 것으로 보이기 때문에 getter와 setter를 통해 값을 읽고 변경할 수 있도록 제공
	public Display(String name) {
		super();
		this.name = name;
	}
	
	
}


