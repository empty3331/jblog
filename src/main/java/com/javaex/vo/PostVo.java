package com.javaex.vo;

public class PostVo {
	
	private int postNo;
	private int cateNo;
	private String postTitle;
	private String psotContent;
	private String regDate;
	
	//
	public PostVo() {}
	public PostVo(int postNo, int cateNo, String postTitle, String psotContent, String regDate) {
		this.postNo = postNo;
		this.cateNo = cateNo;
		this.postTitle = postTitle;
		this.psotContent = psotContent;
		this.regDate = regDate;
	}
	
	
	//
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPsotContent() {
		return psotContent;
	}
	public void setPsotContent(String psotContent) {
		this.psotContent = psotContent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	//
	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", cateNo=" + cateNo + ", postTitle=" + postTitle + ", psotContent="
				+ psotContent + ", regDate=" + regDate + "]";
	}

}
