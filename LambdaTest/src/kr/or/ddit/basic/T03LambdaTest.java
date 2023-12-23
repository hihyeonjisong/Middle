package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class T03LambdaTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("권예은");
		list.add("김나혜");
		list.add("김영상");
		list.add("김태원");
		//list에 있는 각 문자열 요소를 순서대로 가져와서 str에 할당하고, 루프 내에서 해당 문자열을 출력
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("---------------------");
		//위의 for문과 같음
		list.forEach(new Consumer<String>() {//Consumer 인터페이스를 구현하는 객체를 생성합니다.
			@Override
			public void accept(String t) {
				
		}
	});
		list.forEach((str)->System.out.println(str));
		
	}
}
