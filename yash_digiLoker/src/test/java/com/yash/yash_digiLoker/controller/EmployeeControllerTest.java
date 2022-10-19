package com.yash.yash_digiLoker.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.yash.yash_digiLoker.model.Employee;
import com.yash.yash_digiLoker.service.EmployeeService;
import com.yash.yash_digiLoker.serviceImpl.EmployeeImpl;

@RunWith(MockitoJUnitRunner.class)
class EmployeeControllerTest {
	@InjectMocks
	EmployeeController sut;
	
	@Mock
	EmployeeService empservice;
	
	@Mock
	EmployeeImpl empimpl;
	

	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void savetest()
	{
		ResponseEntity<Employee> emp= new ResponseEntity<Employee>(HttpStatus.OK);
		
		Employee employee= new Employee();
		Mockito.when(sut.saveEmployee(employee)).thenReturn(emp);
		assertEquals(emp, sut.saveEmployee(employee));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void getDataByusernameAndPassTes() {
		String emailId="";
		String pwd="";
		Employee emp= new Employee();
		Mockito.when(sut.getDataByusernameAndPass(emailId, pwd)).thenReturn(emp);
		assertEquals(emp, sut.getDataByusernameAndPass(emailId, pwd));
	}

}
