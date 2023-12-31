package kr.or.ddit.reflection;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Modifier;

public class T02ClassMetadataTest {
	public static void main(String[] args) throws ClassNotFoundException {
		//클래스 오브젝트 생성하기..+던지기
		Class<?> clazz = Class.forName("kr.or.ddit.reflection.SampleVO");
		
		System.out.println("심플클래스명: "+ clazz.getSimpleName());
		System.out.println("클래스명: "+clazz.getName());
		System.out.println("상위클래스명: "+clazz.getName());
		
		//패키지정보 가져오기
		Package pkg = clazz.getPackage();
		System.out.println("패키지정보: "+pkg.getName());
		
		//해당 클래스에서 구현하고 있는 인터페이스 목록 가져오기
		Class<?>[] interfaces = clazz.getInterfaces();
		System.out.println("인터페이스목록: ");
		for (Class<?> inf : interfaces) {
			System.out.print(inf.getName()+"|");
		}
		System.out.println();
		
		//클래스의 접근제어자 정보 가져오기
		int modFlag = clazz.getModifiers();
		System.out.println("접근제어자: "+Modifier.toString(modFlag));
	}
}
