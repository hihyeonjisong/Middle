package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class T07EqualsHashCodeTest {
/*
 * 해시함수(hash function)는 임이의길이의 데이터를 
 * 고정된 길이의 데이터로 매핑하는 함수이다.
 * 해시함수에 의해 얻어지는 값을 해시값,해시코드 또는 간단히 해시라고 한다.
 * 
 * HashSet, HashMap, Hashtable과 같은 객체를 사용할경우
 * 객체가 서로 같은지를 비교하기 위해 hashCode() 와 equals()메서드를 사용한다.
 * 그래서 객체가 서로 같은지 여부를 체크하기 위해 두 매서드를 재정의해줘야한다.
 * 객체가 갗은지 여부는 데이터를 추가할때 검사한다.
 * 
 * 	-equals()는 두객체의 내용값이 같은지 비교하는메서드이고,
 *  hashCode() 는 객체에 대한 해시코드값을 가져오기 위한 메서드이다.
 *  
 *  -equals()와 hashCode()메서드에 관한 규칙
 *  1.두 객체가 같으면 반드시 같은 해시코드를 가져야 한다.
 *  2.두 객체가 같으면 equals()메서드를 호출했을때 true를 반환해야 한다.
 *  즉, 객체a,b가 같다면 a.equals(b)와 b.equals(a)모두 true여야한다.
 *  3.두 객체의 해시값이 같다고 해서 두 객체가 반드시 같은 객체라고 할수 없다.
 *  하지만, 두 객체가 같으면 반드시 해시값이 가아야 한다.
 *  4.equals()를 재정의 해야 한다면, hashCode()도 재정의 해주어야 한다.
 *  (equals를 override해줘야한다면 hashcode도 override해줘야함)
 *  5.hashCode()는 기본적으로 힙메모리에 존재하는 각 객체에 대한 메모리 주소를
 *  기반으로 한 정수값을 반환한다.그러므로, 클래스에서 hashCode()메서드를
 *  재정의하지 않으면 절대로 두 객체가 같은 객체로 간주될 수 없다.
 *  
 */
	
	
	
	public static void main(String[] args) {
		System.out.println("abcd".hashCode());//hashcode는 int객체값을 출력함
		System.out.println("Aa".hashCode());//hashcode 값 충돌함 2112로 같음
		System.out.println("BB".hashCode());//ㄴ>충돌가능성 있기때문에 위에4번하기.
		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");
		
		//object의 안에있는 클래스인 equals는 같은 객체인지 확인한다(다른위치에 별도로 만들어진 객체라서)
		//equals를 우리입맞에맞게 오버라이드 해서 true나왔음
		//(equals는 두 객체의 값이 같은지 비교함
		//밑에는 p1객체에대한 메모리주소를 기반으로한 정수값을 비교해서 다를수밖에없음)
		System.out.println("p1.equals(p2) :" + p1.equals(p2));
		System.out.println("p1==p2 :" + (p1==p2));
		
		Set<Person> pSet = new HashSet<Person>();
		System.out.println("add(p1)성공여부 : "+ pSet.add(p1));
		System.out.println("add(p2)성공여부 : "+ pSet.add(p2));//hashcode오버라이드 하고나서 같은지 인식함-false로 뜸
		
		System.out.println("p1,p2등록 후 데이터");
		for (Person p : pSet) {
			System.out.println(p.getId() + ":"+ p.getName());
		}
		System.out.println("add(p3)성공여부 : "+ pSet.add(p3));
		System.out.println("p3등록 후 데이터");
		for (Person p : pSet) {
			System.out.println(p.getId() + ":"+ p.getName());
		}
		
		System.out.println("remove(p2) 성공여부: "+ pSet.remove(p2));
		System.out.println("p2삭제 후 데이터");
		for (Person p : pSet) {
			System.out.println(p.getId() + ":"+ p.getName());
		}
	}
}

class Person{
	private int id;
	private String name;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	//equals와 hashcode를 오버라이드 해주는 버튼누르기
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.getId()== p.getId()
				&&(this.getName().equals(p.getName()));
	}
	
	@Override
	public int hashCode() {
		return (name+id).hashCode();
	}
	*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
}
