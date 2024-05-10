package com.mx.pokeapi.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecordsDTO implements Serializable{

	private static final long serialVersionUID = 1268194562166468413L;
	
	private Long count;
	private String next;
	private String previous;
	private ArrayList<ResultsDTO> results;

}
