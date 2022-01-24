package com.ropi.ropispring.util;

import java.io.BufferedReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ropi.ropispring.Model.Summary;

public class TextReader {
	public List<Summary> textFileReader(MultipartFile file){
		List<Summary> summaryList = new ArrayList<>();
		try {
			if(!file.isEmpty()) {
				String content = new String(file.getBytes(), StandardCharsets.UTF_8);
//				String content = new String(file.getBytes(), StandardCharsets.UTF_16LE);
				BufferedReader reader = new BufferedReader(new StringReader(content));
				String line;
				int count = 0;
				
				while(true) {
					line = reader.readLine();
					int innerCount = 0;
					
					if(line == null) {
						System.out.println("count : " + count);
						break;
					}else {
						int length;
						String[] lineArray = line.split("\t");
						Summary summary = new Summary();
						
						//첫행은 칼럼명
						if(count > 0) {
							for(String value : lineArray) {
								if(value != "") {
									char firstChar = value.charAt(0);
									if(firstChar == '"') {
										length = value.length();
										char lastChar = value.charAt(length - 1);
										if(lastChar == '"') {
											value = value.substring(1, length-1);
										}
									}
								}
								
								if(innerCount == 0) summary.setSymbol(value);
								if(innerCount == 1) summary.setCountrycode(value);
								if(innerCount == 2) summary.setSectorcode(value);
								if(innerCount == 3) summary.setIndustrycode(value);
								if(innerCount == 4) summary.setKoname(value);
								if(innerCount == 5) summary.setEnname(value);
								if(innerCount == 6) summary.setCnname(value);
								if(innerCount == 7) summary.setKosummary(value);
								if(innerCount == 8) summary.setEnsummary(value);
								if(innerCount == 9) summary.setCnsummary(value);
								if(innerCount == 10) summary.setJpsummary(value);
								if(innerCount == 11) summary.setTradunit(Integer.parseInt(value));
								if(innerCount == 12) summary.setNationcode(value);
								if(innerCount == 13) summary.setNationkoname(value);
								if(innerCount == 14) summary.setNationenname(value);
								if(innerCount == 15) summary.setNationcnname(value);
								if(innerCount == 16) summary.setNationjpname(value);
								innerCount++;
								
//								if(summary.getCnname() != null) {
//									if(summary.getCnname().length()>=100) {
//										System.out.println("len : " + summary.getCnname().length() + "/" + summary.getCnname());
//									}
//								}
							}
//							System.out.println(summary.toString());
							summaryList.add(summary);
						}
						count++;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return summaryList;
	}
}
