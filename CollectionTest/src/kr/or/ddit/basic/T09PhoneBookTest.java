package kr.or.ddit.basic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.crypto.interfaces.PBEKey;

/*
문제) 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고, 이 Phone클래스를 이용하여 
	  전화번호 정보를 관리하는 프로그램을 완성하시오.
	  이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	  
	  전체의 전화번호 정보는 Map을 이용하여 관리한다.
	  (key는 '이름'으로 하고 value는 'Phone클래스의 인스턴스'로 한다.)


실행예시)
===============================================
   전화번호 관리 프로그램(파일로 저장되지 않음)
===============================================

  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 1  <-- 직접 입력
  
  새롭게 등록할 전화번호 정보를 입력하세요.
  이름 >> 홍길동  <-- 직접 입력
  전화번호 >> 010-1234-5678  <-- 직접 입력
  주소 >> 대전시 중구 대흥동 111  <-- 직접 입력
  
  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 5  <-- 직접 입력
  
  =======================================
  번호   이름       전화번호         주소
  =======================================
   1    홍길동   010-1234-5678    대전시
   ~~~~~
   
  =======================================
  출력완료...
  
  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 0  <-- 직접 입력
  
  프로그램을 종료합니다...
  
*/
public class T09PhoneBookTest {
	private Scanner scan;
	private Map<String, PhoneVO> phoneBookMap;
	
	public static void main(String[] args) {
		new T09PhoneBookTest().phoneBookStart();
	}
	
	public T09PhoneBookTest() {
		scan = new Scanner(System.in);
		
		//            HashMap은<키를 String(문자열)으로, PhoneVo객체를 값으로 가짐>
		phoneBookMap = new HashMap<String, PhoneVO>();
	}
	
	// 메뉴를 출력하는 메서드
	public void displayMenu(){
		System.out.println();
		System.out.println("메뉴를 선택하세요.");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 0. 프로그램 종료");
		System.out.print(" 번호입력 >> ");		
	}
	
	// 프로그램을 시작하는 메서드
	public void phoneBookStart(){
		System.out.println("===============================================");
		System.out.println("   전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("===============================================");
		
		while(true){
			
			displayMenu();  // 메뉴 출력
			
			int menuNum = scan.nextInt();   // 메뉴 번호 입력
			
			switch(menuNum){
				case 1 : insert();		// 등록
					break;
				case 2 : update();		// 수정
					break;
				case 3 : delete();		// 삭제
					break;
				case 4 : search();		// 검색
					break;
				case 5 : displayAll();	// 전체 출력
					break;
				case 0 :
					System.out.println("프로그램을 종료합니다...");
					return;
				default :
					System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}
	private void displayAll() {
		System.out.println("==============================");
		System.out.println("번호\t이름\t전화번호\t주 소");
		System.out.println("==============================");
		Set<String> keySet = phoneBookMap.keySet();//키 값만 가져옴
		Iterator<String> it = keySet.iterator();
		int cnt =1;
		while (it.hasNext()) {
			String name = it.next();
			PhoneVO pvo = phoneBookMap.get(name);
			
			System.out.println(" "+ cnt+"\t" + pvo.getName()+"\t" +pvo.getTel()+"\t" +pvo.getAddr());
			cnt++;
		}
		System.out.println("==============================");
		System.out.println("전체출력완료");
		
	}

	/*
	 * 회원정보를 검색하기 위한 메서드
	 */
	private void search() {
		System.out.println(" 검색할 전화번호를 입력하세요.");
		System.out.println("이 름 >> ");
		String name = scan.next();
		
		PhoneVO pvo = phoneBookMap.get(name);
		
		if(pvo==null) {
			System.out.println(name+"씨의 전화번호 정보가 없습니다.");
		}else {
			System.out.println(name+"씨의 전화번호 정보");
			System.out.println("이름 :"+pvo.getName());
			System.out.println("이름 :"+pvo.getTel());
			System.out.println("이름 :"+pvo.getAddr());
		}
		System.out.println(name+"씨 정보수정 완료..");
		
	}

	/*
	 * 회원정보를 삭제하기위한 메서드 :remove
	 */
	private void delete() {
		System.out.println(" 삭제할 전화번호를 입력하세요.");
		System.out.println("이 름 >> ");
		String name = scan.next();
		
		if(phoneBookMap.remove(name)==null) {
			System.out.println(name+"씨는 등록된 사람이 아닙니다");
		}else {
			System.out.println(name+"씨 정보를 정상적으로 삭제했습니다.");
		}
		System.out.println("삭제 작업 완료..");
		
	}

	/**
	 * 전화번호 정보를 수정하기 위한 메서드
	 */
	private void update() {
		System.out.println(" 수정할 전화번호를 입력하세요.");
		System.out.println("이 름 >> ");
		String name = scan.next();
		
		//이미 등록된사람인지체크
		//map에서 가져온 데이타가 있으면 등록/ 없으면 등록하면안됌
		if(phoneBookMap.get(name) ==null) {
			System.out.println(name+"씨는 없는사람입니다.");
			return;//메서드종료
		}
		//if절을 무사히 통과한 사람은 등록되지않은사람
		//신규등록해야함
		System.out.println("전화번호 >> ");
		String tel = scan.next();
		
		scan.nextLine();//버퍼에 남아있는 엔터키를 비우기 위해
		
		
		System.out.println("주소 >> ");
		String addr = scan.nextLine();
		//                                쓰기 쉽게 하려고 파람 있는 것으로부름
		phoneBookMap.put(name, new PhoneVO(name, tel, addr));
		//map은 key값이 이미 있는사람은 value값이 입력되면 수정됌.
		System.out.println(name+"씨 수정완료...");
	
		
	}

	/**
	 *새로운 전화번호 등록, 이미 있으면 등록되지않음 
	 */
	private void insert() {
		System.out.println("새롭게 등록할 전화번호를 입력하세요.");
		System.out.println("이름 >> ");
		String name = scan.next();
		
		//이미 등록된사람인지체크
		//map에서 가져온 데이타가 있으면 등록/ 없으면 등록하면안됌
		if(phoneBookMap.get(name) !=null) {
			System.out.println(name+"씨는 이미 등록된 사람입니다.");
			return;//메서드종료
		}
		//if절을 무사히 통과한 사람은 등록되지않은사람
		//신규등록해야함
		System.out.println("전화번호 >> ");
		String tel = scan.next();
		
		scan.nextLine();//버퍼에 남아있는 엔터키를 비우기 위해
		
		
		System.out.println("주소 >> ");
		String addr = scan.nextLine();
		//                                쓰기 쉽게 하려고 파람 있는 것으로부름
		phoneBookMap.put(name, new PhoneVO(name, tel, addr));
		System.out.println(name+"씨 등록완료....");
	
		
	}

		

}


class PhoneVO {
	private String name;
	private String tel;
	private String addr;
	
	
	//default생성자는 기본으로 있음(파라미터 없는)
	//생성자 만들고 기본생성자도 꼭 만들어야 오류없음
	public PhoneVO() {
		super();
	}


	public PhoneVO(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "PhoneVO [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneVO other = (PhoneVO) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
	
	
}



