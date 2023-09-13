package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements MemberDAO, DBconnecionQuery {
	private static MemberDAOImple instance=null;
	
	private MemberDAOImple() {}
	
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}
	
	@Override
	public int insert(MemberVO vo) {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				DriverManager.registerDriver(new OracleDriver());
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				pstmt = conn.prepareStatement(INSERT);
				
				pstmt.setString(1, vo.getMemberId());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getEmail());
				pstmt.setString(4, vo.getEmailAgree());
				pstmt.setString(5, vo.joinInterest());
				pstmt.setString(6, vo.getPhone());
				pstmt.setString(7, vo.getIntroduce());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		return result;
	}

	@Override
	public MemberVO select(String memberId) {
		MemberVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt = conn.prepareStatement(SELECT);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String password = rs.getString(2);
				String email = rs.getString(3);
				String emailAgree = rs.getString(4);
				String joinInterest = rs.getString(5);
				String phone = rs.getString(6);
				String introduce = rs.getString(7);
				String[] interest = joinInterest.split(",");
				
				vo= new MemberVO(memberId, password, email, emailAgree, interest, phone, introduce);
				
			}
//			System.out.println("vo 일치?"+vo.toString());
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
		return vo;
	}

	@Override
	public int update(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt = conn.prepareStatement(UPDATE);
			
			
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getEmailAgree());
			pstmt.setString(4, vo.joinInterest());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getIntroduce());
			pstmt.setString(7, vo.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int delete(String memberId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt = conn.prepareStatement(DELETE);
			
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	

}
