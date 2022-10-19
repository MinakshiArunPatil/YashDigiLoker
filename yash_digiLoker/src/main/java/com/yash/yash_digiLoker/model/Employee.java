package com.yash.yash_digiLoker.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int regid;
	public String fullName;
	public String email;
	public Double MobileNo;
	public String gender;
	public String password;
	public String confirmpass;
	
	
	public Double empId;
	
	
	public Employee(){}
	
	public Double getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(Double mobileNo) {
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

	@Override
	public String toString() {
		return "Employee [regid=" + regid + ", fullName=" + fullName + ", email=" + email + ", MobileNo=" + MobileNo
				+ ", gender=" + gender + ", password=" + password + ", confirmpass=" + confirmpass + ", empId=" + empId
				+ "]";
	}

	


		
}
