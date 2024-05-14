package com.mx.pokeapi.interfaces;

import java.util.ArrayList;
import java.util.Date;

import com.mx.pokeapi.dto.AbilitiesDTO;
import com.mx.pokeapi.dto.DetailsDTO;
import com.mx.pokeapi.dto.HeldItemDTO;
import com.mx.pokeapi.dto.RecordsDTO;
import com.mx.pokeapi.exception.PokeapiException;

public interface PokemonInterface {
	
	RecordsDTO getPokemons(String urlOrigin, Date requestDate) throws PokeapiException;
	
	DetailsDTO getPokemonByName(String name, String urlOrigin, Date requestDate) throws PokeapiException;
	
	ArrayList<AbilitiesDTO> getAbilitiesByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException;
	
	Integer getBaseExperienceByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException;
	
	ArrayList<HeldItemDTO> getHeldItemsByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException;
	
	Integer getIdByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException;
	
	String getLocationAreaEncountersByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException;

}
