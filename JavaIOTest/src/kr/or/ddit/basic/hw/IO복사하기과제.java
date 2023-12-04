package kr.or.ddit.basic.hw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO복사하기과제 {
/**
 * 'd:/D_Other/'에 있는 'Tulips.jpg'파일을
	'복사본_Tulips.jpg'로 복사하는 프로그램을
	작성하시오.
	
 */public static void main(String[] args) {
	FileInputStream fis =null;
	FileOutputStream fos =null;
	
	try {
		
		//파일 읽어서 fis에 저장
		fis = new FileInputStream("d:/D_Other/Tulips.jpg");
		fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
		int data =0;//읽어온 데이터 저장용 
		
		while ((data=fis.read()) != -1) {//읽어온 데이터가 null이 아니면!
			fos.write(data); //복사경로인 fos에 넣어라
			
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {//close 메소드는 IOException을 던질 수 있으므로, close도 예외 처리가 필요하다
			fis.close();// 스트림을 더 이상 사용하지 않을 때 명시적으로 닫는 것이 좋다.
			fos.close();
			System.out.println("파일 복사 완료..");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	
 }
}
