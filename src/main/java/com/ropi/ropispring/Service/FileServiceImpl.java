package com.ropi.ropispring.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ropi.ropispring.Model.Summary;
import com.ropi.ropispring.util.CSVReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
	CSVReader csvReader = new CSVReader();
	
	@Override
	public List<Summary> uploadFile(MultipartFile file) {
		System.out.println("file upload service start");
		csvReader.csvFileReader(file);
		return null;
	}

}
