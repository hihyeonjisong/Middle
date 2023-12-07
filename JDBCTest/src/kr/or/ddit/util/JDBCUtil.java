package kr.or.ddit.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * bulidpath체크->커넥션객체생성->sql생성
 * @author PC-11
 *
 */
public class JDBCUtil {
	//static블럭 : 딱 1번 (초기화작업같은것할때)
	static {
		try {//Class.forName: buildpath가 잘 세팅됐는지 체크(존재하면 ok,없으면 예외)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 커넥션 객체 생성하기 :DriverManager.getConnection
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","pcteam5_train","java");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
//		Connection conn;
//		Statement stmt;
//		PreparedStatement pstmt;
//		ResultSet rs;
		
		if(rs!=null)try {rs.close();}catch(SQLException ex) {}
		if(stmt!=null)try {stmt.close();}catch(SQLException ex) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
		if(rs!=null)try {rs.close();}catch(SQLException ex) {}
	}
}
