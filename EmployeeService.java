package com.yash.yash_digiLoker.service;

import java.util.List;

import com.yash.yash_digiLoker.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee e);

	public List<Employee> getEmployeelist();

	public void deleteEmployee(int regid);

}
