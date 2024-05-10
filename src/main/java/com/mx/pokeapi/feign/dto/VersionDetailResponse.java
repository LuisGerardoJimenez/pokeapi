package com.mx.pokeapi.feign.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VersionDetailResponse implements Serializable{

	private static final long serialVersionUID = 4653447708046747672L;
	
	private Integer rarity;
	private NameUrlResponse version;

}
