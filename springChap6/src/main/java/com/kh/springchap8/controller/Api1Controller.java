package com.kh.springchap8.controller;

import java.io.FileInputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/csv-data1")
@RestController
public class Api1Controller {
	
	
	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<InputStreamResource> csvData() {
		
		try {
			String csvFilePath = "C:\\Users\\user1\\Downloads\\Map1.csv";
			InputStreamResource resource = new InputStreamResource(new FileInputStream(csvFilePath));

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Map1.csv");

            return ResponseEntity.ok().headers(headers).body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
	
	
	

}
