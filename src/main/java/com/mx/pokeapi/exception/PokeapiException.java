package com.mx.pokeapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokeapiException extends Exception{
	
	private static final long serialVersionUID = 8665542502366678499L;
	// customizing timestamp serialization format
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
	private int code;
	private String status;
//	private String message;
//	private String stackTrace;
//	private Object data;
//
//	public PokeapiException() {
//		timestamp = new Date();
//	}
//
//	public PokeapiException(HttpStatus httpStatus, String message) {
//		this();
//		this.code = httpStatus.value();
//		this.status = httpStatus.name();
//		this.message = message;
//	}
//
//	public PokeapiException(HttpStatus httpStatus, String message, String stackTrace) {
//		this(httpStatus, message);
//		this.stackTrace = stackTrace;
//	}
//
//	public PokeapiException(HttpStatus httpStatus, String message, String stackTrace, Object data) {
//		this(httpStatus, message, stackTrace);
//		this.data = data;
//	}
//	
//	public PokeapiException () {
//
//    }

    public PokeapiException (String message) {
        super (message);
    }

    public PokeapiException (Throwable cause) {
        super (cause);
    }
    
//    public PokeapiException (HttpStatus httpStatus, String message, Throwable cause) {
//        super (message, cause);
//    }

    public PokeapiException (String message, Throwable cause) {
        super (message, cause);
        this.timestamp = new Date();
    }
    
    public PokeapiException (String message, Throwable cause, int code) {
        super (message, cause);
        this.code=code;
        this.timestamp = new Date();
    }
    
    public PokeapiException (int code, String status, String message) {
        super (message,null,false,false);
    	this.status=status;
        this.code=code;
        this.timestamp = new Date();
    }
}
