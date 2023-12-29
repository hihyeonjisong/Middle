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
	public int insertMember(MemberVO mv);
	
	
	/**
	 * MemberVO에 담긴 데이터를 update하기 위한 메서드
	 * @param mv  수정할 회원정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0이 반환된다.
	 */
	public int updateMember(MemberVO mv);
	
	
	/**
	 * 회원이 존재하는지 체크하기 위한 메서드
	 * @param    memId  삭제할회원ID
	 * @return DB작업이 성공하면 1, 실패하면 0이 반환된다.
	 */
	public boolean checkMember(String memId);
	
	
	
	/**
	 * 회원정보를 삭제위한 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공시1, 실패시0
	 */
	public int deleteMember(String memId);
	
	
	
	/**
	 * DB에 존재하는 모든 회원정보를 조회하기 위한 메서드
	 * @return
	 */
	public List<MemberVO> selectAll();
	
	
	/**
	 * 회원정보를 검색하기 위한 메서드
	 * @param mv 검색조건을 담은 MemberVO객체
	 * @return 검색된 회원정보를 담은 List
	 */
	public List<MemberVO> searchMember(MemberVO mv);

	/**
	 * 상세회원정보를 가져오기 위한 메서드 
	 * @param    memId  상세회원정보를 가져오기 위한 회원ID
	 * @return 상세 회원정보를 담은 MemberVO객체
	 */
	public MemberVO getMember(String memId);
}
