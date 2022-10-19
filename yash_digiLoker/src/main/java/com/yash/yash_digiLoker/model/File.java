package com.yash.yash_digiLoker.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class File {

@Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")

  private String id;

 
  
  private String name;

  private String type;

  @Lob
  private byte[] data;
  
  private int empid;
 
  
  public File() {
		super();
		// TODO Auto-generated constructor stub
	}

 
  public File(String name, String type, byte[] data ) {
    this.name = name;
    this.type = type;
    this.data = data;
    
  }



public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }


public int getEmpid() {
	return empid;
}


public void setEmpid(int empid) {
	this.empid = empid;
}






}
