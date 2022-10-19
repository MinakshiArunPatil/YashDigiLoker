package com.yash.yash_digiLoker.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourseNotFoundExcpetion(ResourceNotFoundException ex)
	{
		String msg=ex.getMessage();
		 ApiResponse api=new ApiResponse(msg,false);
		 return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
		 
	}
	
   
	

}
