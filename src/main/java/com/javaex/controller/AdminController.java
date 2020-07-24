package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
@RequestMapping("/{id}/admin")
public class AdminController {
	
	@Autowired
	private BlogService blService;
	
	
	//베이직페이지
	@RequestMapping("/basic")
	public String basic(@PathVariable("id") String id, Model model) {
		System.out.println("cont:admin basic");
		
		BlogVo blogVo = blService.blogList(id);
		
		//블로그 정보 받아오기
		model.addAttribute("blogVo", blogVo);
		
		
	return "blog/admin/blog-admin-basic";
	}
	
	//제목,이미지 업로드
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file,
			             @RequestParam("blogTitle") String blogTitle,Model model) {
		System.out.println("cont:admin proupload");
		System.out.println(file.getOriginalFilename());
		System.out.println(blogTitle);
		
		 String saveName= blService.restore(file,blogTitle);
		 model.addAttribute("saveName", saveName);
		
		return"";
	}
	
	
	//카테고리 페이지
	@RequestMapping("/cate")
	public String cate(@PathVariable("id") String id, Model model) {
		System.out.println("cont:admin cate");
		BlogVo blogVo = blService.blogList(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-cate";
	}
	
	
	
	//글작성 페이지
	@RequestMapping("/write")
	public String write(@PathVariable("id") String id, Model model) {
		System.out.println("cont:admin write");
		BlogVo blogVo = blService.blogList(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-write";
	}
	
}
