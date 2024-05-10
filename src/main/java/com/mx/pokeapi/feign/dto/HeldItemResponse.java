package com.mx.pokeapi.feign.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeldItemResponse implements Serializable{

	private static final long serialVersionUID = -4256535250670672162L;
	
	private NameUrlResponse item;
	@JsonAlias("version_details")
	private ArrayList<VersionDetailResponse> versionDetails;

}
