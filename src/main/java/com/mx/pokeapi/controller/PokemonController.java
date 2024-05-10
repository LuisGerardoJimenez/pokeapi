package com.mx.pokeapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.pokeapi.business.PokemonBusiness;
import com.mx.pokeapi.dto.AbilitiesDTO;
import com.mx.pokeapi.dto.DetailsDTO;
import com.mx.pokeapi.dto.HeldItemDTO;
import com.mx.pokeapi.dto.RecordsDTO;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Pokemon")
@CrossOrigin(origins = "*")
@Slf4j
public class PokemonController {
	
	@Autowired
	private PokemonBusiness pokemonBusiness;
	
	@Operation(summary = "Search for all Pokemons")
	@GetMapping(produces = "application/json")
	public RecordsDTO getPokemons(@RequestHeader(value = "X-Forwarded-For", defaultValue = "unknown") String clientIp) {
		log.info("Entrando a buscar los pokemon -> "+clientIp);
		return this.pokemonBusiness.getPokemons();
	}
	
	@Operation(summary = "Search for a Pokemons by name")
	@GetMapping(path = "/{name}", produces = "application/json")
	public DetailsDTO getPokemonsByName(HttpServletRequest request, @PathVariable(name = "name") String name) {
		log.info("Entrando a buscar el pokemon por Nombre -> "+name+" IP -> "+request.getRemoteAddr());
		log.info("Request URL -> "+request.getRequestURL());
		log.info("Servlet Path -> "+request.getServletPath());
		log.info("Request URI -> "+request.getRequestURI());
		log.info("Method -> "+request.getMethod());
		log.info("Nombre del metodo que llama -> "+new Object(){}.getClass().getEnclosingMethod().getName());
		return this.pokemonBusiness.getPokemonByName(name);
	}
	
//	@GetMapping(path = "/{name}", produces = "application/json")
//	public DetailsDTO getPokemonsByName(@PathVariable(name = "name") String name) {
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		log.info("Entrando a buscar el pokemon por Nombre -> "+name+" IP -> "+attributes.getRequest().getRemoteAddr());
//		return this.pokemonBusiness.getPokemonByName(name);
//	}
	
	@Operation(summary = "Search for Pokemon's abilities by Pokemon name")
	@GetMapping(path = "/abilities/{name}", produces = "application/json")
	public ArrayList<AbilitiesDTO> getPokemonsAbilitiesByPokemonName(HttpServletRequest request, @PathVariable(name = "name") String name) {
		log.info("Request URL -> "+request.getRequestURL());
		log.info("Servlet Path -> "+request.getServletPath());
		log.info("Request URI -> "+request.getRequestURI());
		log.info("Method -> "+request.getMethod());
		log.info("Nombre del metodo que llama -> "+new Object(){}.getClass().getEnclosingMethod().getName());
		return this.pokemonBusiness.getAbilitiesByPokemon(name);
	}
	
	@Operation(summary = "Search for Pokemon's base experience by Pokemon name")
	@GetMapping(path = "/base/experience/{name}", produces = "application/json")
	public Integer getPokemonsBaseExperienceByPokemonName(HttpServletRequest request, @PathVariable(name = "name") String name) {
		log.info("Request URL -> "+request.getRequestURL());
		log.info("Servlet Path -> "+request.getServletPath());
		log.info("Request URI -> "+request.getRequestURI());
		log.info("Method -> "+request.getMethod());
		log.info("Nombre del metodo que llama -> "+new Object(){}.getClass().getEnclosingMethod().getName());
		return this.pokemonBusiness.getBaseExperienceByPokemon(name);
	}
	
	@Operation(summary = "Search for Pokemon's held items by Pokemon name")
	@GetMapping(path = "/held/items/{name}", produces = "application/json")
	public ArrayList<HeldItemDTO> getPokemonsHeldItemsByPokemonName(HttpServletRequest request, @PathVariable(name = "name") String name) {
		log.info("Request URL -> "+request.getRequestURL());
		log.info("Servlet Path -> "+request.getServletPath());
		log.info("Request URI -> "+request.getRequestURI());
		log.info("Method -> "+request.getMethod());
		log.info("Nombre del metodo que llama -> "+new Object(){}.getClass().getEnclosingMethod().getName());
		return this.pokemonBusiness.getHeldItemsByPokemon(name);
	}
	
	@Operation(summary = "Search for Pokemon's Id by Pokemon name")
	@GetMapping(path = "/id/{name}", produces = "application/json")
	public Integer getIdsByPokemonName(HttpServletRequest request, @PathVariable(name = "name") String name) {
		log.info("Request URL -> "+request.getRequestURL());
		log.info("Servlet Path -> "+request.getServletPath());
		log.info("Request URI -> "+request.getRequestURI());
		log.info("Method -> "+request.getMethod());
		log.info("Nombre del metodo que llama -> "+new Object(){}.getClass().getEnclosingMethod().getName());
		return this.pokemonBusiness.getIdByPokemon(name);
	}
	
	@Operation(summary = "Search for Pokemon's Location Area Encounters by Pokemon name")
	@GetMapping(path = "/location/area/encounters/{name}", produces = "application/json")
	public String getLocationAreaEncountersByPokemonName(HttpServletRequest request, @PathVariable(name = "name") String name) {
		log.info("Request URL -> "+request.getRequestURL());
		log.info("Servlet Path -> "+request.getServletPath());
		log.info("Request URI -> "+request.getRequestURI());
		log.info("Method -> "+request.getMethod());
		log.info("Nombre del metodo que llama -> "+new Object(){}.getClass().getEnclosingMethod().getName());
		return this.pokemonBusiness.getLocationAreaEncountersByPokemon(name);
	}

}
