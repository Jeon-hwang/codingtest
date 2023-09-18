package edu.web.ajaxquiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class searchDAOImple implements searchDAO, QuizQuery{
	private static searchDAOImple instance = null;
	
	private searchDAOImple() {}
	
	public static searchDAOImple getInstance() {
		if(instance == null) {
			instance = new searchDAOImple();
		}
		return instance;
	}
	@Override
	public ArrayList<String> search(String keyword) {
		ArrayList<String> list = new ArrayList<>();
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt = conn.prepareStatement(SEARCH);
			
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			//System.out.println("임플에서"+list.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
