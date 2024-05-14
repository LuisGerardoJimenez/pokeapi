package com.mx.pokeapi;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.pokeapi.dto.DetailsDTO;
import com.mx.pokeapi.dto.RecordsDTO;
import com.mx.pokeapi.exception.PokeapiException;
import com.mx.pokeapi.interfaces.PokemonInterface;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PokeapiApplicationTests {
	
	@Autowired
	private PokemonInterface pokemonInterface;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getPokemons() {
		try {
			RecordsDTO recordsDTO = this.pokemonInterface.getPokemons("192.168.200.100", new Date());
			log.info("Data -> "+recordsDTO);
		} catch (PokeapiException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getPokemonsByName() {
		try {
			DetailsDTO detailsDTO = this.pokemonInterface.getPokemonByName("ditto","192.168.200.100", new Date());
			log.info("Data -> "+detailsDTO);
		} catch (PokeapiException e) {
			e.printStackTrace();
		}
	}

}
