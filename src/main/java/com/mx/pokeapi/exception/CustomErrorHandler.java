package com.mx.pokeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorHandler {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handleCustomErrorExceptions(Exception e) {
		if(e instanceof PokeapiException) {
			PokeapiException customErrorException = (PokeapiException) e;
			return new ResponseEntity<>(
	                new PokeapiException(
	                		HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                		HttpStatus.INTERNAL_SERVER_ERROR.name(),
	                        customErrorException.getMessage()
	                        
	                ),
	                HttpStatus.INTERNAL_SERVER_ERROR
	        );
		} else {
			return new ResponseEntity<>(e, HttpStatus.FORBIDDEN);
		}
		
    }

}
