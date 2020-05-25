package br.edu.univas.si7.lab7.rest.support;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //usa web filter do servlet
public class StudentRestGlobalExceptionHandler { //define global exception handling

	// handle generic exceptions
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception ex) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
