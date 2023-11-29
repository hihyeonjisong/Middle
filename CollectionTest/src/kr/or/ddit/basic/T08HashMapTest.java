package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T08HashMapTest {
	/*
	 * Map => key,value 한쌍으로 관리하는 객체(entry=>key와 value)
	 * 		key 중복을 허용하지 않고 순서가 없다.(set의 특징)
	 * 		value값은 중복을 허용한다.(List의 특징)
	 * 
	 */
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		//데이터 추가=> put (key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1111-2222");
		
		System.out.println("map"+map);
		
		//데이터 수정=>데이터를 저장할때 key값이 같으면 나중에 입력한 값이 저장된다.
		// 		put(수정할key값, 새로운value값)
		map.put("addr", "수정한값이들어감");
		System.out.println("map"+map);
		map.put("addr", "서울");
		
		//자료삭제=> remove(삭제할 데이터key값)
		map.remove("name");
		System.out.println("map"+map);
		//데이터읽기=> get(key값)
		System.out.println("addr= "+ map.get("addr"));
		System.out.println("==========================");
		
	//key값들을 읽어와 데이터를 출력하는 방법
		//방법1,2=>keySet() 이용=>key값만 다 꺼내옴
		//	 =>Map의 key값으로 구성된 Set데이터를 반환함.
		Set<String> keySet =  map.keySet();
		System.out.println("Iterator을 이용한 방법");
		
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key+":"+map.get(key));	
		}
		System.out.println("------------------");
		
		//방법2=>향상된 for 문을 이용
		System.out.println("향상된 for 문을 이용한 방법");
		for (String key : keySet) {
			System.out.println(key+":"+map.get(key));
		}
		System.out.println("---------------------");
		
		//방법3=>values: value값들만 읽어와 출력하기
		System.out.println("values()이용한 방법");
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("------------------------");
		
		//방법4=> Map관련 클래스에는 Map.Entry타입의 내부 class가 만들어져있다.
		//이 내부 클래스는 key와 value라는 멤버변수로 구성되어 있다.
		//이 Map.Entry타입의 객체들을 Set타입으로 가져오기
		System.out.println("entrySet() 이용한 방법");
		//Map안에 Entry클래스가 정의되어있음
		//Entry객체안에 getKey,getValue클래스가 정의되어있음
		//Entry객체로되어있는 Set을 => entrySet
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		//Entry객체들을 iterator를 이용하여 가져오기
		Iterator<Map.Entry<String, String>> entryIt = 
				entrySet.iterator();
		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key값"+entry.getKey());
			System.out.println("value값"+entry.getValue());
			System.out.println();
			
		}
		
	}
}
