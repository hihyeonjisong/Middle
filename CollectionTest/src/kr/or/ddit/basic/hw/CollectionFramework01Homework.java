package kr.or.ddit.basic.hw;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionFramework01Homework {
/*
 * 학번(문자로하기), 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
	  Student클래스를 만든다.
	  생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
	  (생성자의 파라미터로 정의할것들)(총점,등수는 계산으로 따로 할거라서 )
	  
	  이 Student객체들은 List에 저장하여 관리한다.
	  List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
	  총점의 역순으로 정렬하는 부분을 프로그램 하시오.
	  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
	  (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,->comparable이용
	   총점 정렬기준은 외부클래스에서 제공하도록 한다.)        ->comparator이용
 */
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("1", "송현지", 70, 90, 80));
		studentList.add(new Student("5", "성이수", 90, 90, 80));
		studentList.add(new Student("2", "선민수", 90, 90, 100));
		studentList.add(new Student("9", "서어진", 90, 70, 80));
		studentList.add(new Student("7", "김나혜", 100, 100, 100));
		
		//studentList에 있는 5명의점수들과 5명의점수를 비교함
		//등수는1부터 시작,student의 점수가 낮을수록 rank++함(꼴지는 1+4해서 5등이됌)
		for (Student student : studentList) {
			int rank=1;
			for (Student student2 : studentList) {
				if (student.getSum()<student2.getSum()) {
					rank++;
				}
			}
			student.setRank(rank);
		}
		System.out.println(studentList);
		
		Collections.sort(studentList);
		System.out.println("학번순으로 정렬");
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		Collections.sort(studentList, new RankDesc());
		System.out.println("총점역순으로정렬");
		for (Student student : studentList) {
			System.out.println(student);
		}
		
	}
	
}

class Student implements Comparable <Student> {
	//필드 만들기
	 String stu_no;//학번
	 String stu_nm;//이름
	 int korean;//국어점수
	 int english;//국어점수
	 int math;//국어점수
	 int sum ;//국어점수
	 int rank;//국어점수
	public Student(String stu_no, String stu_nm, int korean, int english, int math) {
		super();
		this.stu_no = stu_no;
		this.stu_nm = stu_nm;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = korean + english +math;
	}
	
	public String getStu_no() {
		return stu_no;
	}
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_nm() {
		return stu_nm;
	}
	public void setStu_nm(String stu_nm) {
		this.stu_nm = stu_nm;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [stu_no=" + stu_no + ", stu_nm=" + stu_nm + ", korean=" + korean + ", english=" + english
				+ ", math=" + math + ", sum=" + sum + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.getStu_no().compareTo(o.getStu_no());//클래스내부의값과 가져온값
	}
}

class RankDesc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
//		Integer sum = new Integer(o1.getSum())
		int result = Integer.compare(o1.getSum(), o2.getSum())*-1;
		if(result==0) {
			result = o1.getStu_no().compareTo(o2.getStu_no())*-1;//역순
		}
		return result;//역순
	}
	
}
	




