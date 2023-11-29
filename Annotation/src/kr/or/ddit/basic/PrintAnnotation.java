package kr.or.ddit.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
Annotation에 대하여..

프로그램 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨것
(JDK1.5부터 지원함)
주석처럼 프로그램에 영향을 미치지 않으면서도 다른 누군가에게는 유용한 정보를 제공할수있다

종류 : 1.표준(일반) 어노테이션
	 2.메타 어노테이션 (어놑을 위한 어놑, 즉 어노테이션을 정의할때 사용하는 어노테이션)
	 
어노테이션 정의하기
@interface 어노테이션이름 {
	요소타입 타입요소이름(); //반환타입이 있고, 매개변수는 없는 추상매서드형태
	...
}

어노테이션요소의 규칙
	1.요소타입은 기본형,String, enum, annotation, Class만 허용된다.
	2.()안에 매개변수를 선언할수 없다.
	3.예외를 선언할수 없다.
	4.요소타입에 제너릭타입글자를 사용할수 없다.
*/
@Target(ElementType.METHOD)      //적용대상
@Retention(RetentionPolicy.RUNTIME)//유지기간
public @interface PrintAnnotation {
	int id=100;// 상수선언가능
	String value() default "-"; //기본값을 '-'로 지정
	int count() default 20;
}
