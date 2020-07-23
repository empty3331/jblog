package com.javaex.vo;

public class BlogVo {
	
	private String id;
	private String blogTitle;
	private String logofile;
	private String userName;
	
	//
	public BlogVo() {}
	public BlogVo(String id, String blogTitle, String logofile,String userName) {
		this.id = id;
		this.blogTitle = blogTitle;
		this.logofile = logofile;
		this.userName = userName;
	}
	
	//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getLogofile() {
		return logofile;
	}
	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//
	
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogTitle=" + blogTitle + ", logofile=" + logofile + ", userName=" + userName
				+ "]";
	}
	
	

}
