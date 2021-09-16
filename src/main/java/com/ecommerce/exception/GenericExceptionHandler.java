package com.ecommerce.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.utils.GenericResponse;
import com.ecommerce.utils.Global;

@RestControllerAdvice
public class GenericExceptionHandler {
	@ExceptionHandler(Exception.class)
	public GenericResponse genericException(Exception ex) {
		return new GenericResponse("exception", -1, Global.OPERACION_ERRONEA, ex.getMessage());
	}
}
