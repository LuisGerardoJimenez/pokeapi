package com.mx.pokeapi.business;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.pokeapi.dto.AbilitiesDTO;
import com.mx.pokeapi.dto.DetailsDTO;
import com.mx.pokeapi.dto.HeldItemDTO;
import com.mx.pokeapi.dto.NameUrlDTO;
import com.mx.pokeapi.dto.RecordsDTO;
import com.mx.pokeapi.dto.ResultsDTO;
import com.mx.pokeapi.dto.VersionDetailDTO;
import com.mx.pokeapi.feign.client.PokemonClient;
import com.mx.pokeapi.feign.dto.DetailsResponse;
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

	@Override
	public DetailsDTO getPokemonByName(String name) {
		log.info("PokemonBusiness -> getPokemonByName");
		DetailsResponse response = this.pokemonClient.getPokemonsByName(name);
		log.info("Response-> "+response);
		ArrayList<HeldItemDTO> heldItemsDTO = null;
		if(response.getHeldItems()!=null) {
			heldItemsDTO = (ArrayList<HeldItemDTO>) response.getHeldItems().stream().map(h -> {
				ArrayList<VersionDetailDTO> versionDetailList = (ArrayList<VersionDetailDTO>) h.getVersionDetails().stream().map(vd -> new VersionDetailDTO(vd.getRarity(), new NameUrlDTO(vd.getVersion().getName(), vd.getVersion().getUrl()))).collect(Collectors.toList());
				return new HeldItemDTO(new NameUrlDTO(h.getItem().getName(), h.getItem().getUrl()),versionDetailList); 
				}).collect(Collectors.toList());
		}
		return DetailsDTO.builder()
				.abilities(response.getAbilities()!=null? (ArrayList<AbilitiesDTO>) response.getAbilities().stream().map(a -> new AbilitiesDTO(new NameUrlDTO(a.getAbility().getName(), a.getAbility().getUrl()) , a.getIsHidden(), a.getSlot())).collect(Collectors.toList()) :null)
				.baseExperience(response.getBaseExperience())
				.heldItems(heldItemsDTO)
				.id(response.getId())
				.name(response.getName())
				.locationAreaEncounters(response.getLocationAreaEncounters())
				.build();
	}

	@Override
	public ArrayList<AbilitiesDTO> getAbilitiesByPokemon(String name) {
		log.info("PokemonBusiness -> getAbilitiesByPokemon");
		DetailsResponse response = this.pokemonClient.getPokemonsByName(name);
		log.info("Response-> "+response);
		return response.getAbilities()!=null? (ArrayList<AbilitiesDTO>) response.getAbilities().stream()
				.map(a -> new AbilitiesDTO(new NameUrlDTO(a.getAbility().getName(), a.getAbility().getUrl()), a.getIsHidden(), a.getSlot()))
				.collect(Collectors.toList()) : null;
	}

	@Override
	public Integer getBaseExperienceByPokemon(String name) {
		log.info("PokemonBusiness -> getBaseExperienceByPokemon");
		DetailsResponse response = this.pokemonClient.getPokemonsByName(name);
		log.info("Response-> "+response);
		return response.getBaseExperience();
	}

	@Override
	public ArrayList<HeldItemDTO> getHeldItemsByPokemon(String name) {
		log.info("PokemonBusiness -> getHeldItemsByPokemon");
		DetailsResponse response = this.pokemonClient.getPokemonsByName(name);
		log.info("Response-> "+response);
		ArrayList<HeldItemDTO> heldItemsDTO = null;
		if(response.getHeldItems()!=null) {
			heldItemsDTO = (ArrayList<HeldItemDTO>) response.getHeldItems().stream().map(h -> {
				ArrayList<VersionDetailDTO> versionDetailList = (ArrayList<VersionDetailDTO>) h.getVersionDetails().stream().map(vd -> new VersionDetailDTO(vd.getRarity(), new NameUrlDTO(vd.getVersion().getName(), vd.getVersion().getUrl()))).collect(Collectors.toList());
				return new HeldItemDTO(new NameUrlDTO(h.getItem().getName(), h.getItem().getUrl()),versionDetailList); 
				}).collect(Collectors.toList());
		}
		return heldItemsDTO;
	}

	@Override
	public Integer getIdByPokemon(String name) {
		log.info("PokemonBusiness -> getIdByPokemon");
		DetailsResponse response = this.pokemonClient.getPokemonsByName(name);
		log.info("Response-> "+response);
		return response.getId();
	}

	@Override
	public String getLocationAreaEncountersByPokemon(String name) {
		log.info("PokemonBusiness -> getLocationAreaEncountersByPokemon");
		DetailsResponse response = this.pokemonClient.getPokemonsByName(name);
		log.info("Response-> "+response);
		return response.getLocationAreaEncounters();
	}

}
