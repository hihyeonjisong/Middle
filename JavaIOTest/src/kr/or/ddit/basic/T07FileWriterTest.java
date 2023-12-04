package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FileWriter(문자기반스트림) 테스트
 * @author PC-11
 *
 */
public class T07FileWriterTest {
	public static void main(String[] args) {
		
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//콘솔(표준입출력장치)과 연결된 입력용 문자 스트림 생성
		//InputStreamreader 스트림 => 바이트기반 스트림(인풋스트림)을 문자기반 스트림(리더)으로 
		//							변환해주는 보조스트림.(재사용 가능)
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null;//파일 출력용 문자기반 스트림
		
		try {
			//파일 출력용 문자기반 스트림 객체 생성
			fw = new FileWriter("d:/D_Other/out.txt");
			
			System.out.println("아무거나 입려갛세요.(종료시 Ctrl+z 키 누르세요.)");
			
			int data =0;
			
			while((data = isr.read())!=-1) {
				fw.write(data);//콘솔에서 입력받은 데이터 파일에 저장하기
			}
			System.out.println("작업끝...");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				isr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
