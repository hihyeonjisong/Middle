package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	/*
	 * 와일드카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의 인수(Argument)로서, 변수 선언, 객체 생성
	 * 및 메서드 정의할때 사용된다. (제너릭 타입 선언시에는 사용할 수 없다.)
	 * 
	 * <? extends T> => 와일드 카드의 상한 제한, T와 그 자손들만 가능 <? super T> => 와일드 카드의 하한 제한, T와
	 * 그 조상들만 가능 <?> => 모든 가능한 타입
	 */
	public static void main(String[] args) {

		// List<?> strList = new ArrayList<String>();

		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<String> stringBox = new FruitBox<String>();

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
		//Juicer.makeJuice(stringBox);

	}
}

class Juicer {
	//static <T extends Fruit> void makeJuice(FruitBox<T> box) {
		static void makeJuice(FruitBox<? extends Fruit> box) {
			
		String fruitListStr = ""; // 과일목록

		int cnt = 0;
		for (Object f : box.getFruiteList()) {
			if(cnt == 0) {
				fruitListStr += f;
			}else {
				fruitListStr += ", " + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + " => 쥬스 완성!!");
	}
}

class Fruit {
	private String name; // 과일이름

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일 (" + name + ")";
	}
}

class Apple extends Fruit {

	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {
	public Grape() {
		super("포도");
	}
}

class FruitBox<T> {
	private List<T> fruiteList;

	public FruitBox() {
		fruiteList = new ArrayList<T>();
	}

	public List<T> getFruiteList() {
		return fruiteList;
	}

	public void add(T fruit) {
		fruiteList.add(fruit);
	}

}