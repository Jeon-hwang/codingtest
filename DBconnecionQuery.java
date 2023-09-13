package edu.web.member;

public interface DBconnecionQuery {
	public final static String URL = "jdbc:oracle:thin:@172.16.3.12:1521:xe";
	public final static String USER = "scott";
	public final static String PASSWORD = "tiger";
	
	public final static String TABLE_NAME = "HW_MEMBER";
	public final static String COL_MEMBER_ID = "MEMBER_ID";
	public final static String COL_PASSWORD = "PASSWORD";
	public final static String COL_EMAIL = "EMAIL";
	public final static String COL_EMAIL_AGREE = "EMAIL_AGREE";
	public final static String COL_INTEREST = "INTEREST";
	public final static String COL_PHONE = "PHONE";
	public final static String COL_INTRODUCE = "INTRODUCE";
	
	public final static String INSERT = "INSERT INTO "+ TABLE_NAME 
										+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	public final static String SELECT = "SELECT * FROM " + TABLE_NAME + " WHERE "+COL_MEMBER_ID+" = ? ";
	
	public final static String UPDATE = "UPDATE "+ TABLE_NAME + " SET "+COL_PASSWORD+ " = ?, "
										+COL_EMAIL+" =?, "+COL_EMAIL_AGREE+" =?, "
										+COL_INTEREST+" =?, "+COL_PHONE+" =?, "
										+COL_INTRODUCE+" =? WHERE "+COL_MEMBER_ID+ " = ?";
	
	public static final String DELETE = "DELETE " + TABLE_NAME + " WHERE " + COL_MEMBER_ID + " = ?";
}
