package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService usService;
	
	//회원가입창
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("cont:joinForm");
		
		return"user/joinForm";
	}
	
	//회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo,
			@ModelAttribute BlogVo blogVo,@ModelAttribute CategoryVo cateVo) {
		System.out.println("cont:join"); 
		
		usService.join(userVo,blogVo,cateVo);
		
		return "user/joinSuccess";
	}
	
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("cont:loginForm"); 
		
		return "user/loginForm";
	}

	
}
