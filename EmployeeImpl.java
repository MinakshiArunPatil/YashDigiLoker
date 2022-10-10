package com.yash.yash_digiLoker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.yash_digiLoker.Exception.ResourceNotFoundException;
import com.yash.yash_digiLoker.model.Employee;
import com.yash.yash_digiLoker.repository.EmployeeRepository;
import com.yash.yash_digiLoker.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository emprepo;

	@Override
	public Employee saveEmployee(Employee e) {

		Employee save = emprepo.save(e);
		return save;

	}

	@Override
	public List<Employee> getEmployeelist() {

		return emprepo.findAll();

	}

	@Override
	public void deleteEmployee(int regid) {

		//emprepo.deleteById(regid);
		try {
			Employee e=this.emprepo.findById(regid).orElseThrow(()->new ResourceNotFoundException("Employee", regid,"id"));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          emprepo.deleteById(regid);
	}

	public Employee getDataByusernameAndPass(String email, String password) {
		return emprepo.findByEmailAndPassword(email, password);
	}

}
