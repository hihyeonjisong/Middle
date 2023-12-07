package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 기본타입 데이터 입출력 보조스트림 예제
 * @author PC-11
 *
 */
public class T13DataIOStreamTest {
	public static void main(String[] args) {
		
		//보조 스트림 선언
		DataOutputStream dos =null;
		
		try {//DataOutputStream 목적: 기본데이터 타입을 잘 변환해서 저장
			dos = new DataOutputStream(new FileOutputStream("d:/D_Other/test.dat"));
			
			dos.writeUTF("홍길동");//문자열 데이터 출력(UTF-8)
			dos.writeInt(17);	//정수형으로 데이터 출력(4바이트로 17이란 인트값을 잘 처리해줌)
			dos.writeFloat(3.14f);//실수형(Float)으로 출력(4바이트로 3.14f이란 플로트값을 )
			dos.writeDouble(3.14);//실수형(Double)으로 출력(8바이트로 )
			dos.writeBoolean(true);//논리형으로 출력 (1바이트로 )
			
			System.out.println("출력완료..");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				dos.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		/////////////////////////////////////////////////////
		//읽기 시작
		
		DataInputStream dis = null;//객체 밖에서 선언하는이유:finally에서도 접근하려고
		try {
			dis = new DataInputStream(new FileInputStream("d:/D_Other/test.dat"));
			
			System.out.println("문자열 자료:"+dis.readUTF());
			System.out.println("정수형 자료:"+dis.readInt());
			System.out.println("실수형(Float)자료 :"+dis.readFloat());
			System.out.println("실수형(Double) 자료:"+dis.readDouble());
			System.out.println("논리형 자료"+dis.readBoolean());
			
			System.out.println("읽기완료..");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
