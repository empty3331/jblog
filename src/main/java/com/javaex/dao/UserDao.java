package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	//회원가입때 생성되는 유저,블로그,카테고리 정보
	public int insert_user(UserVo userVo) {
		System.out.println("dao:insert");
		System.out.println(userVo.toString());
		return sqlSession.insert("user.insertUser",userVo);
	}
	
	public int insert_blog(BlogVo blogVo) {
		System.out.println("dao:insert");
		System.out.println(blogVo.toString());
		return sqlSession.insert("user.insertblog",blogVo);
	}
	
	
	public int insert_cate(CategoryVo cateVo) {
		System.out.println("dao:insert");
		System.out.println(cateVo.toString());
		return sqlSession.insert("user.insertcate",cateVo);
	}

	
	//중복아이디 체크
	public UserVo checkId(String id) {
		System.out.println("dao:idCheck");
		
		UserVo uVo = sqlSession.selectOne("user.selectId", id);
		
		return uVo;
	}


	//로그인
	public UserVo selectUser(UserVo userVo) {
		System.out.println("dao:selectUser");
		return sqlSession.selectOne("user.selectUser", userVo);
	}
	
	
	
	
	
}
