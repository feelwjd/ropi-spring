package com.ropi.ropispring.Controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FileController {
	@ResponseBody
	@PostMapping(value = "/csvFileUpload")
	public ModelAndView uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Calendar calendar = Calendar.getInstance();
//		String today = sdf.format(calendar.getTime());
		
		//파일명
		String originalFile = file.getOriginalFilename();
//		String originalFile = today.toString();
		
		//확장자
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf(".")); 
		
//		String storeFileName = UUID.randomUUID().toString().replaceAll("-",  "") + originalFileExtension;
//		System.out.println("store File Name : " + storeFileName);
		
		String path = "D:\\JeongWook\\ropi-spring\\src\\main\\webapp\\resource\\file\\" + originalFile + originalFileExtension;
		File dest = new File(path);
		file.transferTo(dest);
		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
}