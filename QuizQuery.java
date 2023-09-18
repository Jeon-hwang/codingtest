package edu.web.ajaxquiz;

public interface QuizQuery {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "SEARCH";
	public static final String COL_SNO = "SNO";
	public static final String COL_TITLE = "TITLE";
	
	public static final String SEARCH = "SELECT "+COL_TITLE+" FROM "+TABLE_NAME+" WHERE "+COL_TITLE+" LIKE ?";
}
