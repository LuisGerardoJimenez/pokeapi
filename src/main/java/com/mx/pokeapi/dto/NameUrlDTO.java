package com.mx.pokeapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameUrlDTO implements Serializable{

	private static final long serialVersionUID = 8071101165576064594L;
	
	private String name;
	private String url;

}
