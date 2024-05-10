package com.mx.pokeapi.feign.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecordsResponse implements Serializable{

	private static final long serialVersionUID = -2319977738642834460L;
	
	private Long count;
	private String next;
	private String previous;
	private ArrayList<ResultsResponse> results;

}
