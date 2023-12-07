package kr.or.ddit.basic;

import java.io.FileInputStream;

/**
 * 객체 입출력 스트림 예제(직렬화와 역직렬화)
 * @author PC-11
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class T15ObjectStreamTest {
	public static void main(String[] args) {
		// Member 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("성이수", 30, "경기");
		Member mem3 = new Member("서어진", 40, "광주");
		Member mem4 = new Member("선민수", 50, "강원");

		ObjectOutputStream oos = null;

		try {// 객체 출력용 스트림 객체 생성
			oos = new ObjectOutputStream(new FileOutputStream("d:/D_Other/memObj.bin"));

			// 객체저장
			oos.writeObject(mem1);// 직렬화
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);

			System.out.println("객체저장작업 완료...");
		} catch (IOException ex) {

		} finally {
			try {
				oos.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//////////////////////////////////
		//읽기
		ObjectInputStream ois =null;
		try {//객체를 읽기위한 스트림 객체 생성하기
			ois = new ObjectInputStream(new FileInputStream("d:/D_Other/memobj.bin"));
			
			Object obj = null;
			while ((obj = ois.readObject())!=null) {//역직렬화 ..
			//읽어온 데이터를 원래의 객체타입으로 캐스팅 후 사용한다.
				Member mem = (Member) obj;
				
				System.out.println("이름: "+mem.getName());
				System.out.println("나이: "+mem.getAge());
				System.out.println("주소: "+mem.getAddr());
				System.out.println("------------------------");
			}
		
		}catch (IOException ex) {
			//ex.printStackTrace();
			//더이상 읽어올 객체(데이터)가 없으면 예외발생함.
			System.out.println("읽기 작업 끝...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

/**
 * 회원정보를 담기위한 VO클래스
 * 
 * @author PC-11
 *
 */
class Member implements Serializable {
	//transient(일시적인, 데이터 소멸한다는뜻) => 직렬화가 되지 않게 할 멤버변수에 지정한다.-보여주고싶지않은 정보,보안(주민번호)
	//									(static변수도 직력화 대상이 아니다)
	//									직렬화 되지 않은 멤버변수는 기본값으로 처리된다.
	//									(참조변수: null, 숫자형변수:0)
	private transient String name;
	private transient int age;//0 int의 기본값으로 된다
	private String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}
;
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
