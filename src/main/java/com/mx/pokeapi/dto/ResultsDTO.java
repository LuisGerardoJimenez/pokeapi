package com.mx.pokeapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultsDTO implements Serializable{

	private static final long serialVersionUID = 3753673734095679749L;
	
	private String name;
	private String url;

}
