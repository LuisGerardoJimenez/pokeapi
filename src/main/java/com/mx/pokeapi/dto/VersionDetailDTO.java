package com.mx.pokeapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersionDetailDTO implements Serializable{

	private static final long serialVersionUID = 7237768588837723026L;
	
	private Integer rarity;
	private NameUrlDTO version;

}
