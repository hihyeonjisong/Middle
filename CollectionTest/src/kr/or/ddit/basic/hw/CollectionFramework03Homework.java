package kr.or.ddit.basic.hw;
import java.io.File;
/**
 * 저장기능 넣은 호텔
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionFramework03Homework {
	static Scanner sc = new Scanner(System.in);
	//Map(key, value)에 담는다
	//Map에 담긴보따리 전체를 File에 저장한다(file은 하나씩만 저장가능,또 저장하려면 덮어씌워짐)
	public static Map<Integer, HotelVo> hotelBookMap = new HashMap<Integer, HotelVo>();
	//												Homework폴더
	public static File hotel = new File("\"d:/D_Other/Homework/hotel.bin\""); 

	public static void main(String[] args) {
		ObjectInputStream ois =null;
		//객체를 읽어올 경로
		try {														
			ois = new ObjectInputStream(new FileInputStream(hotel));
			//readObject 메서드를 사용하여 객체를 읽어와 room hotelBookMap에 저장
			//                   맵을(캐스팅하기)
			hotelBookMap = (Map<Integer, HotelVo>) ois.readObject();//내가만든HotelVo클래스 직렬화해줘야함
		} catch (IOException| ClassNotFoundException e) {
			//예외가 발생하면(읽어올 객체가 없으면)->호텔정보가 없습니다
			System.out.println("호텔정보가 없습니다.");
			new CollectionFramework03Homework().hotelBookStart();
		//finally 블록에서는 파일 입출력이 끝난 후 ObjectInputStream을 닫는다.
		}finally {
			try {//예외가 발생하더라도 close 메서드가 호출되도록 try-catch 블록으로 묶여있다.
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
			//4업무종료 를 누르면 맵정보가 파일로 저장하는 매소드로..
				saveHotel();
				System.exit(0);
				break;
			default:
				System.out.println("없는 번호입니다.");
				break;
			}
		}

	}
	/**
	 * 맵에 저장된 호텔 정보를 파일에 저장하기
	 */
	private void saveHotel() {
		ObjectOutputStream oos =null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(hotel));
			//writeObject 메서드를 사용
			//room맵에 저장된 정보를 파일에 씁니다.
			oos.writeObject(hotelBookMap);
			System.out.println("투숙객 정보를 저장합니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

class HotelVo implements Serializable{//직렬화
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
