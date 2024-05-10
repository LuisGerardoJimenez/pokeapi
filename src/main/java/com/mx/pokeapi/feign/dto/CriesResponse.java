package com.mx.pokeapi.feign.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriesResponse implements Serializable{

	private static final long serialVersionUID = 8178829281871928065L;
	
	private String latest;
	private String legacy;

}
