package com.ropi.ropispring.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ropi.ropispring.Model.Summary;

public class CSVReader {
	public List<Summary> csvFileReader(MultipartFile file){
		List<Summary> csvList = new ArrayList<>();
		try {
			if(!file.isEmpty()) {
				String content = new String(file.getBytes(), StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(new StringReader(content));
				
				String line;
				int count = 0;
				while(true) {
					line = reader.readLine();
					System.out.println("line : " + line);
					count++;
					if(line == null) {
						System.out.println("count : " + count);
						break;
					}
				}

//				System.out.println(content.);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return csvList;
	}
}
