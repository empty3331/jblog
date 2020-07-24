package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller

public class BlogController {
	
	@Autowired
	private BlogService blService;
	
	//메인페이지
	@RequestMapping("/{id}")
	public String main(@PathVariable("id") String id,Model model) {
		System.out.println("cont:blog main");
		//아이디로 주소값 받아졌는지 확인
		System.out.println(id);
		
		BlogVo blogVo = blService.blogList(id);
		
		//블로그 정보 받아오기
		model.addAttribute("blogVo", blogVo);
		
		System.out.println(blogVo.toString());
		
		//카테고리 정보 받아오기
		//포스트 정보 받아오기
		return "blog/blog-main";
	}
	
	
	

}
