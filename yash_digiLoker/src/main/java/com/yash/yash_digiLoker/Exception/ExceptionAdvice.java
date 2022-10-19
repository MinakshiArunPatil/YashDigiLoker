package com.yash.yash_digiLoker.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yash.yash_digiLoker.Message.Response;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
	
	  @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<Response> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response("File too large!"));
	  }
	
}
