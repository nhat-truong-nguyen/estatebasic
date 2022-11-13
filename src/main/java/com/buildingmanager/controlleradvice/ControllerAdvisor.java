package com.buildingmanager.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.buildingmanager.model.response.ErrorResponseModel;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ErrorResponseModel> handleNumberFormatException(NumberFormatException ex, WebRequest request) {
		ErrorResponseModel result = new ErrorResponseModel();
		result.setError(ex.getMessage());
		result.setDetails("Sai dinh dang du lieu");
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);	
	}
	
}