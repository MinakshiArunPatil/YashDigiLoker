package com.yash.yash_digiLoker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.yash_digiLoker.model.File;

@Repository
public interface FileRepository  extends JpaRepository<File,String>{

	

	
}
