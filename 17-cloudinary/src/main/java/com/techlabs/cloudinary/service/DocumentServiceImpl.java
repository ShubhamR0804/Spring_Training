package com.techlabs.cloudinary.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

@Service
public class DocumentServiceImpl implements DocumentService{

	private final Cloudinary cloudinary;

	@Autowired
	public DocumentServiceImpl(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}
	
	@Override
	public String uploadFile(MultipartFile file) {
		try {
			Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), new HashMap<>());
			return (String) uploadResult.get("secure_url"); // Return the URL of the uploaded file
		} catch (IOException e) {
			throw new RuntimeException("Failed to upload file", e);
		} catch (Exception e) {
			throw new RuntimeException("Cloudinary error: " + e.getMessage(), e);
		}
	}

}
