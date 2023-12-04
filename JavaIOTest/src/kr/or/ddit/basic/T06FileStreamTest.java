package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 파일출력 예제
 * 
 * @author PC-11
 *
 */
public class T06FileStreamTest {
	public static void main(String[] args) {
		// 파일에 출력하기
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("d:/D_Other/out.txt");

			for (char ch = 'a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}

			System.out.println("파일에 쓰기 작업 완료...");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fos.close();// 작업후 스트림 객체 닫기
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		///////////////////////////////////////
		
		//출력 새로 만들어보기
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(new File("d:/D_Other/out.txt"));
			int data =0;
			while ((data= fis.read()) != -1) {
				System.out.print((char)data);				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
		
		
