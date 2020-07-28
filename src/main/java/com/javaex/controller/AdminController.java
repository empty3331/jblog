package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

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
			             @RequestParam("blogTitle") String blogTitle,
			             @RequestParam("id") String id,Model model) {
		System.out.println("cont:admin proupload");
		
		 String saveName= blService.restore(id,file,blogTitle);
		 model.addAttribute("saveName", saveName);
		 
		 System.out.println(saveName);
		
		return"redirect:/{id}";
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	//카테고리  어드민 메인
	@RequestMapping("/category")
	public String cate(@PathVariable("id") String id, Model model) {
		System.out.println("cont:admin cate");
		BlogVo blogVo = blService.blogList(id);
		model.addAttribute("blogVo", blogVo);
		
		
		return "blog/admin/blog-admin-cate";
	}
	
	//카테고리 목록보기
	@ResponseBody
	@RequestMapping("/list")
	public List<CategoryVo> list(@PathVariable("id") String id,Model model){
		System.out.println("admin:cate list");
		
		List<CategoryVo> caVo = blService.cateList(id); 
		
		
		System.out.println(caVo.toString());
		return caVo;
	}
	
	//카테고리 추가하기
	@ResponseBody
	@RequestMapping("/catewrite")
	public CategoryVo catewrite(@PathVariable String id,@ModelAttribute CategoryVo cateVo) {
		System.out.println("admin:cate write");
		return blService.addCate(cateVo);
	}
	
	//카테고리 삭제
	@ResponseBody
	@RequestMapping("/delCategory")
	public int delCategory(@RequestParam("cateNo") int cateNo) {
		System.out.println("admin:cate delete");
		System.out.println(cateNo);
		
		int cnt = blService.delCategory(cateNo);
		return cnt;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////	
	//글작성 페이지
	@RequestMapping("/write")
	public String write(@PathVariable("id") String id, Model model) {
		System.out.println("cont:admin write");
		BlogVo blogVo = blService.blogList(id);
		model.addAttribute("blogVo", blogVo);
		
		return "blog/admin/blog-admin-write";
	}
	
}
