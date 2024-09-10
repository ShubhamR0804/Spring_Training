package com.techlabs.cloudinary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.cloudinary.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
