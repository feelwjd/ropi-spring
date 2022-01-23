package com.ropi.ropispring.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ropi.ropispring.DAO.FileDAO;
import com.ropi.ropispring.DAO.SummaryDAO;
import com.ropi.ropispring.Model.Summary;
import com.ropi.ropispring.util.TextReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
	@Autowired
	FileDAO fileDAO;
	
	TextReader textReader = new TextReader();
	
	@Override
	public int uploadFile(MultipartFile file) {
		List<Summary> list = new ArrayList<Summary>();
		System.out.println("file upload service start");
		list = textReader.textFileReader(file);
		
		int result = fileDAO.insertSummaryList(list);
		System.out.println("file end result : " + result);
		return result;
	}

}
