package com.techlabs.cloudinary.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
	
	String uploadFile(MultipartFile file);
	
}
