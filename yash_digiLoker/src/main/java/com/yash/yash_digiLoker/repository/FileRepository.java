package com.yash.yash_digiLoker.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.yash_digiLoker.model.File;

@Repository
public interface FileRepository  extends JpaRepository<File,String>{

	public List<File> findByEmpid(int id);

	
}
