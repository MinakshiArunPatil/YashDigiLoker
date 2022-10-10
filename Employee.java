package com.yash.yash_digiLoker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int regid;
	
	@NotEmpty
	public String fullName;
	
	@NotNull
	public Double empId;
	
	@NotEmpty
	@Email(message="email address is not valid")
	public String email;
	
	@NotEmpty
	//@Range(min = 10,max= 10, message = "phone_no should be exact 10 characters." )
	//@Size(min=10 ,max=10 ,message = "password must be minimum of 6 chars and maximum of 8 chars")
	public String MobileNo;
	
	@NotEmpty
	public String gender;
	
	@NotEmpty
	//@Size(min=6 ,max=8 ,message = "password must be minimum of 6 chars and maximum of 8 chars")
	public String password;
	
	@NotEmpty
	public String confirmpass;
	

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	
	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
		this.regid = regid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getEmpId() {
		return empId;
	}

	public void setEmpId(Double empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

}
