package com.mx.pokeapi.feign.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AbilitiesResponse implements Serializable{

	private static final long serialVersionUID = -7391338604164815732L;
	
	private NameUrlResponse ability;
	@JsonAlias("is_hidden")
	private Boolean isHidden;
	private Integer slot;

}
