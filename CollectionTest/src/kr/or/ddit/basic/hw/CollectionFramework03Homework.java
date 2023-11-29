package kr.or.ddit.basic.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionFramework03Homework {
	Scanner sc = new Scanner(System.in);
	Map<Integer, HotelVo> hotelBookMap = new HashMap<Integer, HotelVo>();

	public static void main(String[] args) {
		new CollectionFramework03Homework().hotelBookStart();
	}

	private void hotelBookStart() {
		printHome();
		while (true) {
			displayMenu();
			int select = sc.nextInt();
			switch (select) {
			case 1:chkIn();
				break;
			case 2:chkOut();
				break;
			case 3:roomnow();
				break;
			case 4:finish();
				break;
			default:
				System.out.println("없는 번호입니다.");
				break;
			}
		}

	}

	private void finish() {
		System.out.println("**************************");
		System.out.println("호텔 문을 닫았습니다.");
		System.out.println("**************************");
		
	}

	private void roomnow() {
		Set<Integer> keySet= hotelBookMap.keySet();
		for (Integer key : keySet) {
			HotelVo hvo = hotelBookMap.get(key);
			
			System.out.println("방번호: "+hvo.getRoomno()+
					"투숙객: "+hvo.getName());
		}
		
	}

	private void chkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 => ");
		int roomno = sc.nextInt();
		
		if(hotelBookMap.remove(roomno)==null) {
			System.out.println(roomno+"에는 체크인한 사람이 없습니다.");
		}else {
			System.out.println(roomno+"체크아웃을 합니다");
		}System.out.println("체크아웃 되었습니다.");
		
		
	}

	private void chkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.println("방번호 입력 =>");
		int roomno = sc.nextInt();
		if(hotelBookMap.get(roomno)!=null) {
			System.out.println(roomno+"이미 예약되었습니다");
			return;
		}
		//nextint가 enter를 인식함 
		//비워주는 작업해야함
		sc.nextLine();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 =>");
		String name = sc.nextLine();
		hotelBookMap.put(roomno, new HotelVo(roomno, name));
		System.out.println(name+"님 체크인 되었습니다.");
		
		
	}

	public void displayMenu() {
		System.out.println("**************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("**************************");

	}

	public void printHome() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
	}

}

class HotelVo {
	private int roomno;
	private String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roomno;
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
		HotelVo other = (HotelVo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roomno != other.roomno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HotelVo [roomno=" + roomno + ", name=" + name + "]";
	}

	public HotelVo() {
		super();
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HotelVo(int roomno, String name) {
		super();
		this.roomno = roomno;
		this.name = name;
	}
}
