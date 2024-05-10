package com.mx.pokeapi.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.pokeapi.feign.dto.DetailsResponse;
import com.mx.pokeapi.feign.dto.RecordsResponse;

@FeignClient(name = "pokemonClient", url = "${pokeapi.feign.url}")
public interface PokemonClient {
	
	@GetMapping("/pokemon")
	RecordsResponse getPokemons();
	
	@GetMapping("/pokemon/{name}")
	DetailsResponse getPokemonsByName(@PathVariable(name = "name") String name);

}
