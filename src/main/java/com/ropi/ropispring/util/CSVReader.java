package com.ropi.ropispring.util;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ropi.ropispring.Model.Summary;

public class CSVReader {
	public List<Summary> csvFileReader(MultipartFile file){
		List<Summary> csvList = new ArrayList<>();
		if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String line = new String(bytes, "UTF-8");
				System.out.println("line : " + line);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return csvList;
	}
}
