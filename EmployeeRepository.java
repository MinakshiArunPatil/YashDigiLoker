package com.yash.yash_digiLoker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.yash_digiLoker.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	public Employee findByEmailAndPassword(String email,String password);
	

}
