package kr.or.ddit.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.util.MyBatisUtil;

public class AtchfileDaoImpl implements IAtchfileDao {
	private static IAtchfileDao fileDao;
	
	private AtchfileDaoImpl() {
		
	}
	public static IAtchfileDao getInstance() {
		if(fileDao==null) {
			fileDao = new AtchfileDaoImpl();
		}
		return fileDao;
	}
	

	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt=0;
		try {
			cnt = session.insert("atchFile.insertAtchFile",atchFileVO);
			if(cnt>0) {
				session.commit();
			}
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt=0;
		try {
			cnt = session.insert("atchFile.insertAtchFileDetail",atchFileVO);
			if(cnt>0) {
				session.commit();
			}
			
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		List<AtchFileVO> atchFileList =  new ArrayList<AtchFileVO>();
		SqlSession session = MyBatisUtil.getInstance();
		try {
			atchFileList = session.selectList("atchFile.getAtchFileList",atchFileVO);
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return atchFileList;
	}

	@Override //첨부파일 상세정보 가져옴
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		AtchFileVO atchFileDetail =  null;
		SqlSession session = MyBatisUtil.getInstance(true);
		try {
			atchFileDetail = session.selectOne("atchFile.getAtchFileDetail",atchFileVO);
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return atchFileDetail;
	}
	public static void main(String[] args) {
		IAtchfileDao fileDao = AtchfileDaoImpl.getInstance();
		AtchFileVO atchFileVO = new AtchFileVO();
		int cnt = fileDao.insertAtchFile(atchFileVO);
		if(cnt>0) {
			System.out.println("등록성공!!");
			System.out.println(atchFileVO.getAtchFileId());
			
			//////////////////////////////////
			atchFileVO.setFileStreCours("/aaa/bbb/ccc.jpg");
			atchFileVO.setStreFileNm("aaaabbbbb.jpg");
			atchFileVO.setOrignlFileNm("ccc.jpg");
			atchFileVO.setFileExtsn("jpg");
			atchFileVO.setFileCn("");
			atchFileVO.setFileSize(10);
			cnt = fileDao.insertAtchFileDetail(atchFileVO);
			if(cnt>0) {
				System.out.println("detail등록도 성공!!");
			}
			
		}
	}

}
