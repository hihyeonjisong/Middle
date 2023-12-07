package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDaoImplForJDBC implements IMemberDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	@Override
	public int insertMemeber(MemberVO mv) {
		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " update mymember " + " set MEM_NAME = ? " + " ,MEM_TEL = ? " + " ,MEM_ADDR = ? "
					+ " where MEM_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}
	@Override
	public int updateMemeber(MemberVO mv) {
		int cnt = 0;

		try {

			conn = JDBCUtil3.getConnection();

			String sql = " insert into mymember\r\n " + "(mem_id,mem_name,mem_tel,mem_addr)\r\n " + "values (?,?,?,?) ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemId());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}
	@Override
	public boolean checkMember(String memId) {
		boolean isExist = false;

		try {
			conn = JDBCUtil3.getConnection();
			String sql = " SELECT COUNT(*) AS CNT FROM MYMEMBER " + " WHERE MEM_ID = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, memId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cnt = rs.getInt("CNT");

				if (cnt > 0) {
					isExist = true;
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return isExist;
	}
	
//	@Override
//	public int deleteMember(String memId) {
//
//		int cnt = 0;
//		try {
//
//			conn = JDBCUtil3.getConnection();
//
//			String sql = "delete from mymember where mem_id = ?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memId);
//
//			cnt = pstmt.executeUpdate();
//
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		} finally {
//			JDBCUtil3.close(conn, stmt, pstmt, rs);
//		}
//		return 0;
//	}
	
	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public int insertMemeber(MemberVO mv) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int updateMemeber(MemberVO mv) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	

}
