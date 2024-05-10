package com.mx.pokeapi.business;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.pokeapi.dto.RecordsDTO;
import com.mx.pokeapi.dto.ResultsDTO;
import com.mx.pokeapi.feign.client.PokemonClient;
import com.mx.pokeapi.feign.dto.RecordsResponse;
import com.mx.pokeapi.interfaces.PokemonInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PokemonBusiness implements PokemonInterface{
	
	@Autowired
	private PokemonClient pokemonClient;

	@Override
	public RecordsDTO getPokemons() {
		log.info("PokemonBusiness -> getPokemons");
		RecordsResponse response = this.pokemonClient.getPokemons();
		log.info("Response-> "+response);
		return RecordsDTO.builder()
				.count(response.getCount())
				.next(response.getNext())
				.previous(response.getPrevious())
				.results(response.getResults()!=null? (ArrayList<ResultsDTO>) response.getResults().stream().map(r -> new ResultsDTO(r.getName(), r.getUrl())).collect(Collectors.toList()) :null)
				.build();
	}

}
