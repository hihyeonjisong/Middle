package kr.or.ddit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

/**
	db.properties파일의 내용을 이용하여 DB설정정보를 관리하는 방법
	방법2) Resourcebunble 객체 이용하기
 * @author PC-11
 *
 */
public class JDBCUtil3 {
	static ResourceBundle bundle;
	//static블럭 : 딱 1번 (초기화작업같은것할때)
	static {
		try {
			
			
			bundle = ResourceBundle.getBundle("db");
			
			//Class.forName: buildpath가 잘 세팅됐는지 체크(존재하면 ok,없으면 예외)
			Class.forName(bundle.getString("driver"));
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
		try {//property뽑음: 유지보수 
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("username"),
					bundle.getString("password"));
					
			
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
		if(conn!=null)try {rs.close();}catch(SQLException ex) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
	}
}
