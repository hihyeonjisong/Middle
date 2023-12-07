package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 입출력 성능향상을 위한 보조스트림예제
 * (바이트기반의 Buffered스트림 예제)
 * @author PC-11
 *
 */
public class T11BufferedIOtest {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;//버퍼를 이용하면 더 빠르게 할수있다.
		
		try {
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			//버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192byte(8KB)로 설정됨.
			
			//버퍼크기가 5byte인 보조스트림 생성
			//  문자기반이면 이름을 ~writer
			//  바이트기반이라서 이름을 ~outputstream   
			bos = new BufferedOutputStream(fos,5);//5바이트확보했다 □□□□□
			for (char ch = '1'; ch <= '9'; ch++) {//(문자)1~9까지 
				bos.write(ch);//보조스트림의 write 12345/6789ㅁ(빈네모)
			}
			//bos.flush();//방출하다
			System.out.println("작업끝...");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//보조스트림만 닫아도된다.
		}
	}
}
