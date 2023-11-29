package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04ListSortTest {
	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "정동희", "010-1111-1112"));
		memList.add(new Member(9, "송지아", "010-1111-1113"));
		memList.add(new Member(3, "동준아", "010-1111-1114"));
		memList.add(new Member(6, "김아리", "010-1111-1115"));
		System.out.println("정렬전 : ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		Collections.sort(memList);
		System.out.println("정렬후 : ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		Collections.shuffle(memList);
		System.out.println("섞은후 : ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		//외부정렬자를 이용한 정렬
		Collections.sort(memList, new SortNumDesc());
		System.out.println("외부정렬자 이용한 정렬후");
		for (Member mem : memList) {
			System.out.println(mem);
		}
	}
}

//Member객체의 번호를 기준으로 내림차순-인터페이스를 override해줘야함
class SortNumDesc implements Comparator<Member> {//정렬기능을담은 class를 외부에 만들때
//       자식                                        부모         : comparator을 sortNumdesc가 상속받아서 사용한다는뜻

	@Override
	public int compare(Member mem1, Member mem2) {
//		if (mem1.getNum() > mem2.getNum()) {
//			return -1;
//		} else if (mem1.getNum() == mem2.getNum()) {
//			return 0;
//		} else {
//			return 1;
//		}
		return new Integer( //comparator가 만든 integer객체를 사용해서
				mem1.getNum()).compareTo(mem2.getNum())*-1;
	}

}

//회원정보를 담기위한 클래스 정의->vo(value object)
class Member implements Comparable<Member> {
	private int num;// 번호
	private String name;// 이름
	private String tel;// 이름

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// 회원 이름을 기준으로 오름차순 정렬하기
	@Override
	public int compareTo(Member mem) {//클래스 내부에 정렬할때
		return this.getName().compareTo(mem.getName());
	}

}
