package kr.or.ddit.reflection;

/**
 * Class 오브젝트(클래스정보를 담고있는)를 생성하는 예제
 * @author PC-11
 *
 */
public class T01ClassObjectCreationTest {
/*
 java Reflection에 대하여..
 
 1.리플렉션은 런타임시점에 클래스또는 멤버변수,메서드,생성자 등에 대한 정보를 
 가져오거나 수정할수 있고 새로운 객체를 생성하거나 메서드를 실행할수있다.
 (컴파일 시점에 해당정보를 알수 없는 경우(소스코드부재)에 유용하게 사용될수 있음)
 
 2.Reflection API는 java.lang.reflect패키지와 java.lang.Class를 통해 제공된다
 
 3.java.lang.Class의 주요 메서드
 -getName(), getSuperclass(), getInterfaces(), getModifiers()등
 
 4.java.lang.reflection패키지의 주요 클래스
 -Field, Method, Constructor,Modifier등
 
 */
	public static void main(String[] args) throws ClassNotFoundException {
		//방법1: Class.forName()매서드 이용하기
		Class<?> klass = Class.forName(
				//패키지명                     . 클래스명
				"kr.or.ddit.reflection.T01ClassObjectCreationTest");
		//방법2: getClass(){라는 인스턴스}매서드 이용하기
		T01ClassObjectCreationTest coct = new T01ClassObjectCreationTest();
		klass = coct.getClass(); //객체.클래스이름
		
		//방법3: .class 이용
		klass = kr.or.ddit.reflection.T01ClassObjectCreationTest.class;
	}
}
