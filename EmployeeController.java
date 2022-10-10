package com.yash.yash_digiLoker.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.yash_digiLoker.Exception.ApiResponse;
import com.yash.yash_digiLoker.model.Employee;
import com.yash.yash_digiLoker.service.EmployeeService;
import com.yash.yash_digiLoker.serviceImpl.EmployeeImpl;


@CrossOrigin("*")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@Autowired
	EmployeeImpl esImpl;

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee e) {
		if (!e.fullName.equals(null)) {
			es.saveEmployee(e);
			return new ResponseEntity<Employee>(HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getEmployeelist() {
		List<Employee> employeelist = es.getEmployeelist();
		if (employeelist.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employeelist));
	}
	
	
	@DeleteMapping("/deleteEmployee/{regid}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable int regid) {
		es.deleteEmployee(regid);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/getDatabyusernameAndPass/{email}/{password}")
	public Employee getDataByusernameAndPass(@PathVariable String email,@PathVariable String password)
	{
		return esImpl.getDataByusernameAndPass(email, password);
	}
	


}
