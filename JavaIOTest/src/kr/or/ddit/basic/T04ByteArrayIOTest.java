package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class T04ByteArrayIOTest {
	public static void main(String[] args) {
		//inSrc에 있는 9개의 데이터를 outSrc에 복사
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		/*//직접복사하는방법
		outSrc = new byte[inSrc.length];//공간 확보
		
		for (int i = 0; i < inSrc.length; i++) {
			outSrc[i] = inSrc[i];
		}*/
		
		//arraycopy()메서드 이용
//		outSrc = new byte[inSrc.length];
//		//System.arraycopy(src, srcPos, dest, destPos, length);
//		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length);
//		System.out
//				.println(/* "직접복사 후 outSrc => " */"arraycopy()메서드 이용후 outSrc=>"
//				+Arrays.toString(outSrc));
		
		//스트림 객체 생성하기
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data =0; // 읽어온 바이트 데이터 저장용 변수
		
		//read()매서드 => byte단위로 데이터를 읽어와 int형으로 반환한다.(int는 4바이트)
		//				더이상 읽어올 데이터가 없으면 -1을 반환한다.
		while ((data=bais.read()) != -1) {
			baos.write(data);//출력
		}
		
		outSrc = baos.toByteArray();
		System.out.println("inSrc=>"+Arrays.toString(inSrc));
		System.out.println("outSrc=>"+Arrays.toString(outSrc));
	}
}
