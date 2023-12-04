package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T03ByteArrayIOTest {
	public static void main(String[] args) throws IOException {
		//inSrc에 있는 9개의 데이터를 outSrc에 복사
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];
		
		
		//스트림 객체 생성하기
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int readBytes =0; // 읽어온 바이트 데이터 저장용 변수
		
		//read()매서드 => byte단위로 데이터를 읽어와 int형으로 반환한다.(int는 4바이트)
		//				더이상 읽어올 데이터가 없으면 -1을 반환한다.
		     //n이 저장됌        <--   n바이트면
		while ((readBytes=bais.read(temp)) != -1) {
			
			System.out.println("temp=>"+Arrays.toString(temp));
			                    //읽어온바이트수만큼만 출력..쓰레기 안붙음
			baos.write(temp, 0, readBytes);//출력
		}
		
		outSrc = baos.toByteArray();
		System.out.println("inSrc=>"+Arrays.toString(inSrc));
		System.out.println("outSrc=>"+Arrays.toString(outSrc));
	}
}
