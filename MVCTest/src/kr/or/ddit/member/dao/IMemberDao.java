package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 
 * 받아와 서비스에 전달하는 DAO의 인터페이스
 * @author PC-11
 *
 */
public interface IMemberDao {
	/**
	 * MemberVO에 담긴 데이터를 insert하기 위한 메서드
	 * @param mv 등록할 회원정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0이 반환된다.
	 */
	public int insertMemeber(MemberVO mv);
	
	
	/**
	 * MemberVO에 담긴 데이터를 update하기 위한 메서드
	 * @param mv  수정할 회원정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0이 반환된다.
	 */
	public int updateMemeber(MemberVO mv);
	
	
	/**
	 * 회원이 존재하는지 체크하기 위한 메서드
	 * @param mv   memId삭제할회원ID
	 * @return DB작업이 성공하면 1, 실패하면 0이 반환된다.
	 */
	public boolean checkMember(String memId);
	
	
	/**
	 * DB에 존재하는 모든 회원정보를 조회하기 위한 메서드
	 * @return
	 */
	public List<MemberVO> selectAll();
}
