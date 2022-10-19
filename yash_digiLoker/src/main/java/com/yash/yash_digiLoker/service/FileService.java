package com.yash.yash_digiLoker.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.yash.yash_digiLoker.model.File;
import com.yash.yash_digiLoker.repository.FileRepository;

@Service
public class FileService {

  @Autowired
  private FileRepository filerepo;

	/*
	 * public File store(MultipartFile file) throws IOException { String fileName =
	 * StringUtils.cleanPath(file.getOriginalFilename()); File File = new
	 * File(fileName, file.getContentType(), file.getBytes());
	 * 
	 * return filerepo.save(File); }
	 */

  public File store(File file) throws IOException {
		/*
		 * String fileName = StringUtils.cleanPath(file.getOriginalFilename()); File
		 * File = new File(fileName, file.getContentType(), file.getBytes());
		 */

	    return filerepo.save(file);
	  }
  
  public File getFile(String id) {
	  System.out.println("id "+id);
    return filerepo.findById(id).get();
  }
  
  public Stream<File> getFileById(int id) {
	  System.out.println("id "+id);
    //return filerepo.findById(id).stream();
	  return filerepo.findByEmpid(id).stream();
  }
  
  public Stream<File> getAllFiles() {
    return filerepo.findAll().stream();
  }
  
 
}

