package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;

	
	//메인화면 블로그 정보 불러오기
	public BlogVo blogList(String id) {
		System.out.println("dao:blogList");
		
		return sqlSession.selectOne("blog.blogList",id);
	}
	
	//메인화면 카테고리 정보 불러오기
	public List<CategoryVo> cateList(String id) {
		System.out.println("dao:cateList");
		
		System.out.println("다오"+id);
		
		return sqlSession.selectList("blog.cateList", id);
	}

	
	//블로그 정보 갱신하기
	public int blogTitleUp(BlogVo blVo) {
		System.out.println("dao:blogTitle");
		System.out.println(blVo.toString());
	
		return sqlSession.update("blog.update",blVo);
	}

	//카테고리 넘버 먹이기
	public int nextSeq() {
		int nextSeq = sqlSession.selectOne("blog.selectNextVal");
		System.out.println(nextSeq);
		return nextSeq;
	}

	//카테고리 추가
	public void catePlus(CategoryVo cateVo) {
		System.out.println("다오:카테고리 플러스");
		
		System.out.println(cateVo.toString());
		sqlSession.insert("blog.insertcate",cateVo);

	}

	//새 카테고리 갱신
	public CategoryVo selectNewCate(int no) {
		System.out.println("다오:셀렉트 뉴 카테");
		
		CategoryVo vo = sqlSession.selectOne("blog.selectNewCate", no);
		System.out.println(no);
		
		return vo;
	}

	//카테고리 삭제
	public int deleteCate(int cateNo) {
		System.out.println("다오:카테 삭제");
		
	
		return sqlSession.delete("blog.deleteCate", cateNo);
	}

	//선택한 카테고리 불러오기
	public CategoryVo selectByNo(int cateNo) {
		
		return sqlSession.selectOne("blog.selectByNo", cateNo);
	}

	
	

	
}
