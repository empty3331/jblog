package com.javaex.vo;

public class CategoryVo {
	
	private String id;
	private int cateNo;
	private String cateName;
	private String description;
	private String regDate;
	
	//
	public CategoryVo() {}
	public CategoryVo( int cateNo,String id, String cateName, String description, String regDate) {
		super();
		this.id = id;
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}
	
	//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "CategoryVo [id=" + id + ", cateNo=" + cateNo + ", cateName=" + cateName + ", description=" + description
				+ ", regDate=" + regDate + "]";
	}
	

}
