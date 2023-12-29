package kr.or.ddit.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.MyBatisUtil;

public class MemberDaoImpl implements IMemberDao {

	private static IMemberDao memDao;

	private MemberDaoImpl() {

	}

	public static IMemberDao getInstance() {
		if (memDao == null) {
			memDao = new MemberDaoImpl();
		}
		return memDao;
	}

	@Override
	public int insertMember(MemberVO mv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;
		try {
			cnt = sqlSession.insert("member.insertMember", mv);
			if (cnt > 0) {
				sqlSession.commit();
			}

		} catch (PersistenceException ex) {
			sqlSession.rollback();// commit안되면 rollback하도록
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;
		try {
			cnt = sqlSession.update("member.updateMember", mv);
			if (cnt > 0) {
				sqlSession.commit();
			}

		} catch (PersistenceException ex) {
			sqlSession.rollback();// commit안되면 rollback하도록
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {

		boolean isExist = false;// 기본초기화
		SqlSession sqlSession = MyBatisUtil.getInstance(true);// 자동커밋으로

		try {
			int cnt = sqlSession.selectOne("member.checkMember", memId);

			if (cnt > 0) {
				isExist = true;
			}

		} catch (PersistenceException ex) {
			sqlSession.rollback();// commit안되면 rollback하도록
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return isExist;
	}

	@Override
	public int deleteMember(String memId) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;
		try {
			cnt = sqlSession.delete("member.deleteMember", memId);
			if (cnt > 0) {
				sqlSession.commit();
			}

		} catch (PersistenceException ex) {
			sqlSession.rollback();// commit안되면 rollback하도록
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> memList = new ArrayList<MemberVO>();

		SqlSession sqlSession = MyBatisUtil.getInstance(true);// 자동커밋으로

		try {
			memList = sqlSession.selectList("member.selectAll");

		} catch (PersistenceException ex) {
			
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return memList;

	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<MemberVO>();

		SqlSession sqlSession = MyBatisUtil.getInstance(true);// 자동커밋으로

		try {
			memList = sqlSession.selectList("member.searchMember",mv);

		} catch (PersistenceException ex) {
			sqlSession.rollback();// commit안되면 rollback하도록
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return memList;

	}

	@Override
	public MemberVO getMember(String memId) {
		MemberVO mv = new MemberVO();
		//MemberVO mv = null;

		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		try {
			mv = sqlSession.selectOne("member.getMember",memId);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return mv;
	}

}
