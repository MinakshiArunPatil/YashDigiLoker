package com.yash.yash_digiLoker.Exception;

public class ResourceNotFoundException extends Exception {
	
	String fieldName;
	long fieldId;
	String msg;
	
	
	public ResourceNotFoundException(String fieldName, long fieldId, String msg) {
		super(String.format(fieldName,fieldId,msg));
		this.fieldName = fieldName;
		this.fieldId = fieldId;
		this.msg = msg;
	}
	
	

}
