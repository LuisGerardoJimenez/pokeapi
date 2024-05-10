package com.mx.pokeapi.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDTO implements Serializable{

	private static final long serialVersionUID = 2757676324326682895L;
	
	private ArrayList<AbilitiesDTO> abilities;
	private Integer baseExperience;
	private ArrayList<HeldItemDTO> heldItems;
	private Integer id;
	private String name;
	private String locationAreaEncounters;

}
