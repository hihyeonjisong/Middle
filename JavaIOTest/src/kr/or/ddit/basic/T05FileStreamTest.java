package kr.or.ddit.basic;

import java.io.FileInputStream;

/**
 * 파일 읽기 예제
 * @author PC-11
 *
 */
public class T05FileStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try { 				//   d드라이브의 ...
			fis = new FileInputStream("d:/D_Other/test2.txt");
			int data =0;
			while ((data=fis.read()) != -1) {
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
