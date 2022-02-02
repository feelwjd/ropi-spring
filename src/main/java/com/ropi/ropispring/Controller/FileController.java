package com.ropi.ropispring.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ropi.ropispring.Service.FileService;


@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	
	@ResponseBody
	@PostMapping(value = "/csvFileUpload")
	public ModelAndView uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
		if(file == null) {
			System.out.println("NULL ");
		}else {
			int result = fileService.uploadFile(file);
			System.out.println("result : " + result);
		}
		ModelAndView mv = new ModelAndView("redirect:/1");
		return mv;
	}
}