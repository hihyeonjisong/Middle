package kr.or.ddit.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) {
		System.out.println("id값: "+PrintAnnotation.id);
		
		//Reflection을 이용한 메서드 정보 가져오기(방법3)
		Method[] methodArr = Service.class.getDeclaredMethods();
		
		for (Method m: methodArr) {
			System.out.println("메서드명: "+m.getName());
			
			Annotation[] annos = m.getDeclaredAnnotations();
			
			for (Annotation anno : annos) {
				String annoName = 
						anno.annotationType().getSimpleName();
				if(annoName.equals("PrintAnnotation")) {
					PrintAnnotation printAnno = (PrintAnnotation) anno;
					String value = printAnno.value();
					int count = printAnno.count();
					for (int i = 0; i < count; i++) {
						System.out.print(value);
					}
				}
			}
			System.out.println();
		}
	}
}
