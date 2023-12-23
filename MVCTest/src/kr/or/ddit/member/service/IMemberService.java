package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 회원정보 관련 서비스의 인터페이스
 * @author PC-11
 *
 */
public interface IMemberService {
	/**
	 * 회원등록을 위한 메서드
	 * @param mv 등록할 회원정보를 담은 VO
	 * @return 등록이 성공하면 1, 실패하면 0이 반환된다.
	 */
	public int registMemeber(MemberVO mv);//회원등록
	
	
	/**
	 * 회원정보를수정하기 위한 메서드
	 * @param mv  수정할 회원정보를 담은 VO객체
	 * @return 수정이 성공하면 1, 실패하면 0이 반환된다.
	 */
	public int modifyMemeber(MemberVO mv);
	
	
	/**
	 * 회원이 존재하는지 체크하기 위한 메서드
	 * @param memId 삭제할회원ID
	 * @return 회원이존재하면 성공하면 1, 실패하면 0이 반환된다.
	 */
	public boolean checkMember(String memId);
	
	
	
	/**
	 * 회원정보를 삭제위한 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공시1, 실패시0
	 */
	public int removeMember(String memId);
	
	
	/**
	 * DB에 존재하는 모든 회원정보를 조회하기 위한 메서드
	 * @return
	 */
	public List<MemberVO> displayAllMember();
	
	/**
	 * 회원정보를 검색하기 위한 메서드
	 * @param mv 검색정보를 담은 MemberVO 객체
	 * @return 검색된 회원정보를 담은 List
	 */
	public List<MemberVO> searchMember(MemberVO mv);
}
