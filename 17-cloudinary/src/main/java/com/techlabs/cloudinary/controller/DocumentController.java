package com.techlabs.cloudinary.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techlabs.cloudinary.service.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentController {
	
	private final DocumentService documentService;

	@Autowired
	public DocumentController(DocumentService documentService) {
		this.documentService = documentService;
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		return documentService.uploadFile(file);
	}

}
