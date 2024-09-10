package com.techlabs.cloudinary.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {

	@Bean
	public Cloudinary cloudinary() {
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", "dtlcqq9ma");
		config.put("api_key", "787186575596648");
		config.put("api_secret", "Jf3KoVGCpn_gJ-CuA0sZccuitwk");
		return new Cloudinary(config);
	}
	
}
