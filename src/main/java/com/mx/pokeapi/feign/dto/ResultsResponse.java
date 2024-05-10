package com.mx.pokeapi.feign.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultsResponse implements Serializable{

	private static final long serialVersionUID = -177499161645142857L;
	
	private String name;
	private String url;

}
