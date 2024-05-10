package com.mx.pokeapi.interfaces;

import java.util.ArrayList;

import com.mx.pokeapi.dto.AbilitiesDTO;
import com.mx.pokeapi.dto.DetailsDTO;
import com.mx.pokeapi.dto.HeldItemDTO;
import com.mx.pokeapi.dto.RecordsDTO;

public interface PokemonInterface {
	
	RecordsDTO getPokemons();
	
	DetailsDTO getPokemonByName(String name);
	
	ArrayList<AbilitiesDTO> getAbilitiesByPokemon(String name);
	
	Integer getBaseExperienceByPokemon(String name);
	
	ArrayList<HeldItemDTO> getHeldItemsByPokemon(String name);
	
	Integer getIdByPokemon(String name);
	
	String getLocationAreaEncountersByPokemon(String name);

}
