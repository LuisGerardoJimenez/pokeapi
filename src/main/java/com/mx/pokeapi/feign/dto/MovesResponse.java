package com.mx.pokeapi.feign.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovesResponse implements Serializable{

	private static final long serialVersionUID = 5431678451011650389L;
	
	private NameUrlResponse move;
	private ArrayList<VersionGroupDetailResponse> versionGroupDetails;

}
