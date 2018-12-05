package com.br.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.springrest.entity.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {
	// Add an exception handler using @ExceptionHandler

	/**
	 * 
	 * @param exc
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

		// create StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// Return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param exc
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

		// create StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// Return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
