package com.yash.yash_digiLoker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.yash_digiLoker.Message.Response;
import com.yash.yash_digiLoker.Message.ResponseFile;
import com.yash.yash_digiLoker.model.File;
import com.yash.yash_digiLoker.service.FileService;

import antlr.StringUtils;

@RestController
@CrossOrigin("*")
public class FileController {
	
	 private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	  @Autowired
	  private FileService fileService;

	  @PostMapping("/upload")
	  public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("emp") String emp) throws IOException {
	    String message = "";
	    File f=new ObjectMapper().readValue(emp, File.class);
	    System.out.println("id is "+f.getId());
	    f.setData(file.getBytes());
	    f.setType(file.getContentType());
	    f.setName(file.getOriginalFilename());
	    try {
	    	fileService.store(f);

	    	
	    	
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new Response(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
		  log.info("Inside files: ");
	    List<ResponseFile> files = fileService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/file/")
	          .path(""+dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

		
		  @GetMapping("/file/{id}") public ResponseEntity<byte[]>
		  getFile(@PathVariable String id) {
		  
		  System.out.println("Inside Files by id"); 
		  File file =fileService.getFile(id);
		  
		  return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
		  "attachment; filename=\"" + file.getName() + "\"") .body(file.getData()); }
		 
	  
	  @GetMapping("/files/{id}")
	  public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable int id) {
		  System.out.println("Inside Files");
	    List<ResponseFile> files = fileService.getFileById(id).map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/file/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
}
