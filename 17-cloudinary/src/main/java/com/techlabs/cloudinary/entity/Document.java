package com.techlabs.cloudinary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="document")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Document {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docid;

    private String url;


}
