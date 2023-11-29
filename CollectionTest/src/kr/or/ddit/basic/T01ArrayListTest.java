package kr.or.ddit.basic;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {
		//기본 용량은 (default Capacity)10이다.
		List list1 = new ArrayList();
//		//list기반의 메서드여서 같이 사용할수 있음-코드유지보수가 좋아짐
//		List list1 = new LinkedList();
		
		//add()매서드를 사용하여 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
//		list1.add(new Integer(111)); //같음
		
		list1.add("K");
		list1.add("true");
		list1.add("12.34");
		
		//size() =>데이터 개수
		System.out.println("size =>"+list1.size());
		System.out.println("list1 =>"+ list1);
		
		//get()으로 데이터 꺼내오기
		System.out.println("1번째 자료=>"+ list1.get(0));
		
		//데이터 끼워넣기도 add()사용
		list1.add(0,"zzz");
		System.out.println("zzz끼워넣은 후 =>"+list1);
		
		//데이터 수정(set메서드사용-파라미터2개:바구고싶은개수
		String temp = (String) list1.set(0,"YYY");
		System.out.println("temp => "+temp);
		System.out.println("데이터 변경후 list1 =>" +list1);
		
		//데이터 삭제하기(remove메서드이용)
		list1.remove(0);
		System.out.println("첫번째 데이터 삭제 후 =>" +list1);
		
		list1.remove("bbb");
		System.out.println("bbb삭제 후 =>"+list1);
		System.out.println("--------------");
		
//		list1.remove(1); 똑같음
		list1.remove(new Integer(111));
		System.out.println("111삭제후 =<" +list1);
		
		List<String> list2  =new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("ccc");
		list2.add("DDD");
		list2.add("EEE");
		
		for (String str: list2) {
			System.out.println(str);
		}
		
//		contains(비교객체)=>리스트에 비교객체가 있으면 true
//							없으면 false를 반환함
							
		System.out.println(list2.contains("DDD"));//true
		System.out.println(list2.contains("ZZZ"));//false
		
		//indexOf(비교객체)=> 리스트에서 '비교객체를 찾아 비교객체가 존재하는 index값을 반환함.
		//                  없으면 -1반환함.
		System.out.println("DDD의 index값 :"+ list2.indexOf("DDD"));
		System.out.println("DDD의 index값 :"+ list2.indexOf("ZZZ"));
		System.out.println("------------------------");
		
		//이러면 2개가남음
		for (int i = 0; i < list2.size(); i++) {
			list2.remove(i);
			System.out.println(i+"삭제함");
		}
		System.out.println("list2의크기 =>" + list2.size());
		
		//거꾸로 지우면 차례로 다 지워짐 -정답 확인해보기 아직안함!!!!
		for (int i = list2.size(); i > 0; i++) {
			list2.remove(i);
			System.out.println(i+"삭제함");
		}
	
		
	}
}
