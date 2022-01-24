package com.ropi.ropispring.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ropi.ropispring.Model.Summary;

@Service
public interface FileService {
	int uploadFile(MultipartFile file);
}
