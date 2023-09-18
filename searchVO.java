package edu.web.ajaxquiz;

public class searchVO {
	private int SNO;
	private String title;
	
	public searchVO() {}
	
	public searchVO(int sNO, String title) {
		SNO = sNO;
		this.title = title;
	}
	public int getSNO() {
		return SNO;
	}
	public void setSNO(int sNO) {
		SNO = sNO;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "searchVO [SNO=" + SNO + ", title=" + title + "]";
	}
	
	
}
