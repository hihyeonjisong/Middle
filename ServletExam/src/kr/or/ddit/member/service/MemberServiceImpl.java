package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	//1
	private static IMemberService memService;
	
	private IMemberDao memDao;
	//2
	private MemberServiceImpl() {
		//스테틱 get instance불러와야함
		//JDBC유틸사용하기
		//memDao = MemberDaoImplForJDBC.getInstance();
		
		//myBatis사용하기
		memDao = MemberDaoImpl.getInstance();
	}
	
	//3
	public static IMemberService getInstance() {
		if(memService == null) {//없으면 만들어줘야하니까
			memService = new MemberServiceImpl(); //나는 내꺼니까 내꺼 쓸수있음
		}
		return memService;
	}
	

	@Override
	public int registMemeber(MemberVO mv) {
		int cnt = memDao.insertMember(mv);
		
		return cnt;
	}

	@Override
	public int modifyMemeber(MemberVO mv) {
		int cnt = memDao.updateMember(mv);
		
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = memDao.checkMember(memId);
		return isExist;
	}

	@Override
	public int removeMember(String memId) {
		int cnt = memDao.deleteMember(memId);
		return cnt;
	}

	@Override
	public List<MemberVO> displayAllMember() {
		List<MemberVO> memList = memDao.selectAll();
		return memList;
	}


	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = memDao.searchMember(mv);
		return memList;
	}

	@Override
	public MemberVO getMember(String memId) {
		MemberVO mv = memDao.getMember(memId);
		return mv;
	}

	


	
	
	
}
