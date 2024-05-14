package com.mx.pokeapi.feign.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailsResponse implements Serializable{

	private static final long serialVersionUID = -7549182742483318701L;
	
	private ArrayList<AbilitiesResponse> abilities;
	@JsonAlias("base_experience")
	@SerializedName("base_experience")
	private Integer baseExperience;
	private CriesResponse cries;
	private ArrayList<NameUrlResponse> forms;
	private ArrayList<GameIndexResponse> gameIndices;
	private Integer height;
	@JsonAlias("held_items")
	@SerializedName("held_items")
	private ArrayList<HeldItemResponse> heldItems;
	private Integer id;
	private Boolean isDefault;
	@JsonAlias("location_area_encounters")
	@SerializedName("location_area_encounters")
	private String locationAreaEncounters;
	private ArrayList<MovesResponse> moves;
	private String name;
	private Integer order;
	private ArrayList<Object> pastAbilities;
	private ArrayList<Object> pastTypes;
	private NameUrlResponse species;

}
