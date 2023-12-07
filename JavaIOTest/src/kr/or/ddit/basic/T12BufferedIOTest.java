package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 성능향상을 위한 보조스트림 예제
 * (문자기반 스트림을 위한 보조스트림)
 * @author PC-11
 *
 */
public class T12BufferedIOTest {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			
			fr= new FileReader("src/kr/or/ddit/basic/T11BufferedIOTest.java");
			//BufferedReader: 문자기반을 읽기위해   
			br = new BufferedReader(fr);//(파일리더를 통해)
			
			
			String tempStr ="";
			
			int cnt = 1;//줄번호
			//읽어온 문자열은 tempStr에 저장, null이 아닌동안반복
			while((tempStr = br.readLine())!=null){//String이라서 비었으면=null로 함
				System.out.printf("%d: %s\n",cnt++, tempStr);
			}
//			while ((data = fr.read()) != -1) {//int라서 비었으면=-1로 함
//				System.out.print((char)data);//이 class내용을 파일로 읽어들임
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//.close()예외가 발생해도 잡고싶어서 try-catch-finally함
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
