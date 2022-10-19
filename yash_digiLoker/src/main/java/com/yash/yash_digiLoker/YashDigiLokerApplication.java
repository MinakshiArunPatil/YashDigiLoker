package com.yash.yash_digiLoker;

import java.io.Serializable;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yash.yash_digiLoker.model.Employee;
import com.yash.yash_digiLoker.model.File;
import com.yash.yash_digiLoker.repository.EmployeeRepository;

@SpringBootApplication
public  class YashDigiLokerApplication  {
	
	
	@Autowired
	private EmployeeRepository empployeerepository;
	
	public static void main(String[] args) {
		SpringApplication.run(YashDigiLokerApplication.class, args);
		
	}



}
