package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//아이디 중복확인(ajax)
	@ResponseBody
	@RequestMapping("/idcheck")
	public boolean idcheck(@RequestParam("userId") String id) {
		System.out.println("cont:loginForm"); 
		
		boolean result = usService.checkId(id);
		
		return result;
	}
	
	///////////////////////////////////////////////////////
	
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("cont:loginForm"); 
		
		return "user/loginForm";
	}

	//로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo,HttpSession session) {
		System.out.println("cont:login");
		
		UserVo authUser = usService.login(userVo);
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			System.out.println("성공");
			return "redirect:/";
		} else {
			System.out.println("실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("cont:logout");
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
}
