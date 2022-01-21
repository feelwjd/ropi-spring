package com.ropi.ropispring.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ch.qos.logback.classic.Logger;

public class FileUtils {
	private static final String filpath = "c:\\desktop\\";

	public Map<String, String> fileUpload(HttpServletRequest request,  MultipartHttpServletRequest mf, String target) {
		String saveFileName = "";
		 //파일이 저장될 path 설정 
        // String path = + "\\resources";    // 웹프로젝트 경로 위치
        String path = request.getSession().getServletContext().getRealPath("/")+"/resources/file/"+target;
        //String path = "/party/webapp/resources/images/profiles/";
        System.out.println("path = "+path);
        
        Map<String, String> names = new HashMap<String, String>();
        
        try {
        	MultipartHttpServletRequest mhsr = mf;
        	Iterator iter = mhsr.getFileNames();
        	MultipartFile mfile = null;
        	String fieldName = "";
        	List resultList = new ArrayList();
        	
        	File dir = new File(path);
        	if(!dir.isDirectory()) {
        		dir.mkdirs();
        	}
        	
        	while(iter.hasNext()) {
        		  fieldName = (String) iter.next(); // 내용을 가져와서 
                  mfile = mhsr.getFile(fieldName); 
                  String origName; 
                  origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8"); //한글꺠짐 방지 
                  
                  System.out.println("origName: " + origName);
                  // 파일명이 없다면 
                  if ("".equals(origName)) {
                      continue; 
                  } 
                  String ext = origName.substring(origName.lastIndexOf('.'));

                  saveFileName = getUuid()+ext;
                  names.put("saved", saveFileName);
                  names.put("original", origName);
                  System.out.println("saveFileName : " + saveFileName);
                  
                  // 설정한 path에 파일저장 
                  File serverFile = new File(path + File.separator + saveFileName);
                  mfile.transferTo(serverFile);

        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return names;
	}

	
	private String getUuid() {
	
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
