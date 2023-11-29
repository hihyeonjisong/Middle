package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class T05HashSetTest {
	public static void main(String[] args) {
		Set hs1 = new HashSet();
		//Set에 데이터를 추가할때도 add()를 사용한다
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);//2라는 integer객체로 들어감
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터 : "+ hs1);
		System.out.println();
		
		//Set은 순서개념(인덱스를  통한 접근)이 없고,
		//데이터 중복을 허용하지 않는다.
		//그래서 이미 있는 데이터를 add하면 false를 반환하고
		//데이터는 추가되지 않는다.
		boolean isAdded = hs1.add("FF"); 
		System.out.println("중복되지 않을때 : "+ isAdded);
		System.out.println("Set 데이터 : "+hs1);
		System.out.println();
		
		isAdded = hs1.add("CC");
		System.out.println("중복될때: "+ isAdded);
		System.out.println("Set 데이터: " + hs1);
		System.out.println();
		
		//Set의 데이터를 수정하려면 수정하는 메서드가 없기 때문에 
		//해당 데이터를 삭제 후 새로운 데이터를 추가해주어야 한다.
		
		//삭제하는 메서드
		//1) clear() => 모든 데이터 삭제
		//2) remove(삭제할데이터) => 해당 데이터 삭제
		
		//예)'FF'를 'EE'로 수정하기
		hs1.remove("FF");
		System.out.println("FF삭제 후 데이터: "+hs1);
		System.out.println();
		
		hs1.add("EE");
		System.out.println("EE추가 후 데이터: "+hs1);
		System.out.println();
		
		//hs1.clear();
		System.out.println("Set의데이터 개수: "+hs1.size());
		
		//Set은 데이터의 인덱스 개념이 없기 때문에 List처럼 인덱스를 이용한 접근이 불가능하다. 
		//그래서 데이터를 꺼내기 위해 Iterator객체를 사용한다.(반복자)객체
		//Set타입의 컬랙션 객체는 iterator메소드(추상)를 반드시 가지고 있음
		//iterator객체는 hasnext와 next 객체를 가지고 있음(hasnext는 t/f반환, next로 값꺼냄)
		// (왜? index라는 개념이 없기때문에)
		
		Iterator it = hs1.iterator();//set데이터를 받으려면 iterator 필요함
		//hasNext() => 다음 위치에 데이터가 있는지 확인하고 있으면 true,
		//                                      없으면 false를 반환한다.
		while(it.hasNext()) {
			//next() =>다음 위치의 데이터를 반환한다.
			System.out.println(it.next());
		}
		
		//1~100사이의 중복되지 않는 정수 5개 만들기
		Set<Integer> intRnd = new HashSet<Integer>();
		
		while(intRnd.size()<5) {//중복되지 않는다면 5번 돌것임
			int num = (int) (Math.random()*100 +1);
			intRnd.add(num);
		}
		
		System.out.println("만들어진 난수들:" + intRnd);
		
		//Collection유형의 객체들은(set,list) 서로 다른 자료구조로 쉽게 변경해서
		//사용할수있다. 다른 종류의 객체를 생성할때 변경할 데이터를 넣어주면된다.
		List<Integer>intRndList = new ArrayList<Integer>(intRnd);//set객체를 list객체로 자유자재로 바꿀수있다.
		System.out.println("List 데이터 출력...");
		for (Integer i : intRndList) {
			System.out.println(i +" ");
		}
		System.out.println();
		
	}
}
