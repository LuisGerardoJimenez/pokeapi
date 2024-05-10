package com.mx.pokeapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class AbilitiesDTO implements Serializable{

	private static final long serialVersionUID = -6082957546092961006L;
	
	private NameUrlDTO ability;
	private Boolean isHidden;
	private Integer slot;

}
