package com.mx.pokeapi.feign.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VersionGroupDetailResponse implements Serializable{

	private static final long serialVersionUID = -7116405752086150938L;
	
	private Integer levelLearnedAt;
	private NameUrlResponse moveLearnMethod;
	private NameUrlResponse versionGroup;

}
