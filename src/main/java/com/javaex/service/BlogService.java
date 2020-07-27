package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Service
public class BlogService {
	@Autowired
	private BlogDao blDao;
	
	//블로그 메인화면
	public BlogVo blogList(String id) {
		System.out.println("ser:blogList");
		
		return blDao.blogList(id);
	}

	//카테고리
	public List<CategoryVo> cateList(String id) {
		System.out.println("ser:cateList");
		
		System.out.println(id);
		
		List<CategoryVo> caVo = blDao.cateList(id);

		return caVo;
	}

	
	//프로필 파일올리기
	public String restore(String id,MultipartFile file, String blogTitle) {
		System.out.println("서비스:프로필갱신");
		
		if(file.getOriginalFilename() != "" ) {
		//////////////파일카피////////
		String saveDir = "C:\\javaStudy\\upload";
		
		
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("확장자"+exName);
		
		//저장파일이름
		String saveName = System.currentTimeMillis()+ UUID.randomUUID().toString() + exName; 
		System.out.println("저장이름"+saveName);
		
		//파일경로
		String filePath = saveDir+"\\"+saveName;
		System.out.println("파일경로"+filePath);
				

		System.out.println(saveName);
		
		BlogVo blvo = new BlogVo(id,blogTitle,saveName);
		///////////////파일서버에 복사////////////////////////////
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//텍스트 확인
	    System.out.println(blogTitle.toString());
			
		
		blDao.blogTitleUp(blvo);
		}
		
		else {
			//텍스트 확인
		    System.out.println(blogTitle.toString());
		    BlogVo blvo = new BlogVo(id,blogTitle,"");
		    blDao.blogTitleUp(blvo);
		}
		
		
		return id;
	}

	
	//카테고리 추가
	public CategoryVo addCate(CategoryVo cateVo) {
		System.out.println("서비스:카테고리 추가");
		
		int nextSeq = blDao.nextSeq();
		cateVo.setCateNo(nextSeq);
		
		
		blDao.catePlus(cateVo);
		
		
		
		CategoryVo newCate = blDao.selectNewCate(nextSeq);
		
		return newCate;
	}


	

}
