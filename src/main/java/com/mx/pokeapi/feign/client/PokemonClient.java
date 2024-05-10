package com.mx.pokeapi.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.pokeapi.feign.dto.RecordsResponse;

@FeignClient(name = "pokemonClient", url = "${pokeapi.feign.url}")
public interface PokemonClient {
	
	@GetMapping
	RecordsResponse getPokemons();

}
