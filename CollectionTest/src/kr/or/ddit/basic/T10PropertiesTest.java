package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class T10PropertiesTest {
	public static void main(String[] args) throws IOException {
	/*
	 * Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
	 * Map은 모든 타입의 객체데이터를 key와 value값으로 사용할수 있지만,
	 * Properties는 key와 value값으로 String 만 사용할수 있다.
	 */
		Properties prop = new Properties();
		prop.setProperty("name", "홍길동");
		prop.setProperty("tel", "010-1111-2222");
		prop.setProperty("addr", "대전광역시");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		
		System.out.println("이름"+name);
		System.out.println("전화"+tel);
		System.out.println("주소"+prop.getProperty("addr"));
		
		//데이터를 파일로 저장하기 ->위치:project에 저장함 
//		prop.store(new FileOutputStream(
//				
//				"./src/kr/or/ddit/basic/test.properties"), "코멘트(comment)입니다");
		//properties파일 읽어오기
		prop.load(new FileReader(
				"./src/kr/or/ddit/basic/test.properties"));
		System.out.println("읽어온 정보..");
		System.out.println(prop.getProperty("hobby"));
	}
}
