package edu.web.homework;

public class MemberVO {
	private String userid;
	private String password;
	private String email;
	private String emailAgree;
	private String[] interest;
	private String phone;
	private String introduce;
	
	
	public MemberVO() {}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmailAgree() {
		return emailAgree;
	}


	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}


	public String[] getInterest() {
		System.out.println("interest ? "+interest.toString());
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
