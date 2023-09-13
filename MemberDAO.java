package edu.web.member;

public interface MemberDAO {
	public int insert(MemberVO vo);
	
	public MemberVO select(String memberId);
	
	public int update(MemberVO vo);
	
	public int delete(String memberId);
}
