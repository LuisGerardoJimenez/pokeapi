package com.mx.pokeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.pokeapi.business.PokemonBusiness;
import com.mx.pokeapi.dto.RecordsDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Pokemon")
@CrossOrigin(origins = "*")
@Slf4j
public class PokemonController {
	
	@Autowired
	private PokemonBusiness pokemonBusiness;
	
	@GetMapping(produces = "application/json")
	public RecordsDTO getPokemons() {
		log.info("Entrando a buscar los pokemon");
		return pokemonBusiness.getPokemons();
	}

}
