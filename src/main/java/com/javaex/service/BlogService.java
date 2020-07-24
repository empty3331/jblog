package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

	public CategoryVo cateList(String id) {
		System.out.println("ser:cateList");
		return blDao.cateList(id);
	}

	
	//프로필 파일올리기
	public String restore(MultipartFile file, String blogTitle) {
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
				

		//텍스트 확인
		System.out.println(blogTitle.toString());
		
		
		blDao.blogTitleUp(blogTitle);
		blDao.logofileUp(saveName);
		
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
			

		
		return saveName;
	}

	

}
