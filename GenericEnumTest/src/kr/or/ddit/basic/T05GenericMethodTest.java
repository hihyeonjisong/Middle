package kr.or.ddit.basic;

class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
	}
}

/**
 * 제한된 타입 파라미터 예제
 * (Bounded Parameter)
 * @author PC-10
 *
 */

public class T05GenericMethodTest {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3);
		System.out.println(result2);
		
//		Flyable f = new MyPlane();
//		f.fly();
		
		
	}
}
interface Flyable {
	public void fly();
}

class MyPlane implements Flyable {

	@Override
	public void fly() {
		System.out.println("비행기가 날아다니고 있어요.");
	}
	
}