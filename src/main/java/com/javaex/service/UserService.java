package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao usDao;

	//회원가입
	public int join(UserVo userVo,BlogVo blogVo,CategoryVo cateVo) {
		System.out.println("ser:join");
		
		usDao.insert_user(userVo);
		usDao.insert_blog(blogVo);
		usDao.insert_cate(cateVo);
		
		System.out.println(userVo.toString()+blogVo.toString()+cateVo.toString());
		
		return 1;
		
	}
	
	// 아이디체크
	public boolean checkId(String id) {
		System.out.println("ser:checkId");
		UserVo uVo = usDao.checkId(id);

		boolean result = true;

		if (uVo == null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	
	//로그인
		public UserVo login(UserVo userVo) {
			System.out.println("ser:login");
			return usDao.selectUser(userVo);
		}

}
