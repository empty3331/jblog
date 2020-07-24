package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;

	public BlogVo blogList(String id) {
		System.out.println("dao:blogList");
		
		return sqlSession.selectOne("blog.blogList",id);
	}

	public CategoryVo cateList(String id) {
		System.out.println("dao:cateList");
		
		return sqlSession.selectOne("blog.cateList", id);
	}

	
	//
	public void blogTitleUp(String blogTitle) {
		// TODO Auto-generated method stub
		
	}
	
	
    //프사 갱신하기
	public void logofileUp(String saveName) {
		// TODO Auto-generated method stub
		
	}

	

}
