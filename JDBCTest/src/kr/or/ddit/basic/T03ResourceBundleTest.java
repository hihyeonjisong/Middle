package kr.or.ddit.basic;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class T03ResourceBundleTest {
	public static void main(String[] args) {
		//ResourceBundle객체를 이용하여 properties파일 읽어오기
		
		//ResourceBundle객체를 생성할때 파일명은 확장자(.properties)를 
		//제외하고 지정한다.
		ResourceBundle bundle = ResourceBundle.getBundle("db",Locale.JAPANESE);
		 							//Locale.JAPANESE :해당Locale에 맞춰서 언어가 출력됌
		//key값들만 읽어오기
		Enumeration<String>keys = bundle.getKeys();
		
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = bundle.getString(key);
			
			System.out.println(key+"=>"+value);
		}
		System.out.println("출력끝..");
	}
}
