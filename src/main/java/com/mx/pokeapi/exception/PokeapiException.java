package com.mx.pokeapi.exception;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PokeapiException extends Exception{
	
	private static final long serialVersionUID = 8665542502366678499L;
	private Date timestamp;
	private int code;
	private String status;

    public PokeapiException (String message) {
        super (message);
    }

    public PokeapiException (Throwable cause) {
        super (cause);
    }

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
