package com.javatechie.crud.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ImageController {

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = "getImage/{photo}",method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo){
		if(!photo.equals("") || photo!=null) {
			try {
				Path filename = Paths.get("uploads",photo);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource  = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length).
						contentType(MediaType.parseMediaType("image/png")).
						body(byteArrayResource);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	@RequestMapping(value = "getImages/{photo}",method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImageAsByteArray(@PathVariable("photo") String photo) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream("uploads/"+photo);
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);
	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	}
}