package com.mx.pokeapi.business;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mx.pokeapi.dto.AbilitiesDTO;
import com.mx.pokeapi.dto.DetailsDTO;
import com.mx.pokeapi.dto.HeldItemDTO;
import com.mx.pokeapi.dto.NameUrlDTO;
import com.mx.pokeapi.dto.RecordsDTO;
import com.mx.pokeapi.dto.ResultsDTO;
import com.mx.pokeapi.dto.VersionDetailDTO;
import com.mx.pokeapi.entity.RecordsEntity;
import com.mx.pokeapi.exception.PokeapiException;
import com.mx.pokeapi.feign.client.PokemonClient;
import com.mx.pokeapi.feign.dto.DetailsResponse;
import com.mx.pokeapi.feign.dto.RecordsResponse;
import com.mx.pokeapi.interfaces.PokemonInterface;
import com.mx.pokeapi.repository.RecordsRepository;

import feign.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PokemonBusiness implements PokemonInterface{
	
	@Autowired
	private PokemonClient pokemonClient;
	
	@Autowired
	private RecordsRepository recordsRepository;

	@Override
	public RecordsDTO getPokemons(String urlOrigin, Date requestDate) throws PokeapiException {
		try {
			log.info(this.getClass().getName()+" -> "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName());
			Response response = this.pokemonClient.getPokemons();
			Gson gson  = new Gson();
			RecordsResponse responseBody = gson.fromJson(response.body().asReader(StandardCharsets.UTF_8), RecordsResponse.class);
//			log.info("Body -> "+responseBody);
//			log.info("Results -> "+responseBody.getResults());
			this.saveFeignData(urlOrigin, requestDate, response);
			return RecordsDTO.builder()
					.count(responseBody.getCount())
					.next(responseBody.getNext())
					.previous(responseBody.getPrevious())
					.results(responseBody.getResults()!=null? (ArrayList<ResultsDTO>) responseBody.getResults().stream().map(r -> new ResultsDTO(r.getName(), r.getUrl())).collect(Collectors.toList()) : null)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PokeapiException("No se encontraron los pokemon, intente mas tarde");
		}
	}

	@Override
	public DetailsDTO getPokemonByName(String name, String urlOrigin, Date requestDate) throws PokeapiException {
		try {
			log.info(this.getClass().getName()+" -> "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName());
			Response response = this.pokemonClient.getPokemonsByName(name);
			ArrayList<HeldItemDTO> heldItemsDTO = null;
			Gson gson  = new Gson();
			DetailsResponse responseBody = gson.fromJson(response.body().asReader(StandardCharsets.UTF_8), DetailsResponse.class);
			if(responseBody.getHeldItems()!=null) {
				heldItemsDTO = (ArrayList<HeldItemDTO>) responseBody.getHeldItems().stream().map(h -> {
					ArrayList<VersionDetailDTO> versionDetailList = (ArrayList<VersionDetailDTO>) h.getVersionDetails().stream().map(vd -> new VersionDetailDTO(vd.getRarity(), new NameUrlDTO(vd.getVersion().getName(), vd.getVersion().getUrl()))).collect(Collectors.toList());
					return new HeldItemDTO(new NameUrlDTO(h.getItem().getName(), h.getItem().getUrl()),versionDetailList); 
					}).collect(Collectors.toList());
			}
			this.saveFeignData(urlOrigin, requestDate, response);
			return DetailsDTO.builder()
					.abilities(responseBody.getAbilities()!=null? (ArrayList<AbilitiesDTO>) responseBody.getAbilities().stream().map(a -> new AbilitiesDTO(new NameUrlDTO(a.getAbility().getName(), a.getAbility().getUrl()) , a.getIsHidden(), a.getSlot())).collect(Collectors.toList()) :null)
					.baseExperience(responseBody.getBaseExperience())
					.heldItems(heldItemsDTO)
					.id(responseBody.getId())
					.name(responseBody.getName())
					.locationAreaEncounters(responseBody.getLocationAreaEncounters())
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PokeapiException("No se encontraron datos del pokemon, intente mas tarde");
		}
	}

	@Override
	public ArrayList<AbilitiesDTO> getAbilitiesByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException {
		try {
			log.info(this.getClass().getName()+" -> "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName()); 
			Response response = this.pokemonClient.getPokemonsByName(name);
			Gson gson  = new Gson();
			DetailsResponse responseBody = gson.fromJson(response.body().asReader(StandardCharsets.UTF_8), DetailsResponse.class);
			this.saveFeignData(urlOrigin, requestDate, response);
			return responseBody.getAbilities()!=null? (ArrayList<AbilitiesDTO>) responseBody.getAbilities().stream()
					.map(a -> new AbilitiesDTO(new NameUrlDTO(a.getAbility().getName(), a.getAbility().getUrl()), a.getIsHidden(), a.getSlot()))
					.collect(Collectors.toList()) : null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PokeapiException("No se encontraron las habilidades del pokemon, intente mas tarde");
		}
		
	}

	@Override
	public Integer getBaseExperienceByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException {
		try {
			log.info(this.getClass().getName()+" -> "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName());
			Response response = this.pokemonClient.getPokemonsByName(name);
			Gson gson  = new Gson();
			DetailsResponse responseBody = gson.fromJson(response.body().asReader(StandardCharsets.UTF_8), DetailsResponse.class);
			return responseBody.getBaseExperience();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PokeapiException("No se encontro la experiencia base del pokemon, intente mas tarde");
		}
	}

	@Override
	public ArrayList<HeldItemDTO> getHeldItemsByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException {
		try {
			log.info(this.getClass().getName()+" -> "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName());
			Response response = this.pokemonClient.getPokemonsByName(name);
			ArrayList<HeldItemDTO> heldItemsDTO = null;
			Gson gson  = new Gson();
			DetailsResponse responseBody = gson.fromJson(response.body().asReader(StandardCharsets.UTF_8), DetailsResponse.class);
			if(responseBody.getHeldItems()!=null) {
				heldItemsDTO = (ArrayList<HeldItemDTO>) responseBody.getHeldItems().stream().map(h -> {
					ArrayList<VersionDetailDTO> versionDetailList = (ArrayList<VersionDetailDTO>) h.getVersionDetails().stream().map(vd -> new VersionDetailDTO(vd.getRarity(), new NameUrlDTO(vd.getVersion().getName(), vd.getVersion().getUrl()))).collect(Collectors.toList());
					return new HeldItemDTO(new NameUrlDTO(h.getItem().getName(), h.getItem().getUrl()),versionDetailList); 
					}).collect(Collectors.toList());
			}
			return heldItemsDTO;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PokeapiException("No se encontraron los items del pokemon, intente mas tarde");
		}
	}

	@Override
	public Integer getIdByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException {
		try {
			log.info(this.getClass().getName()+" -> "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName());
			Response response = this.pokemonClient.getPokemonsByName(name);
			Gson gson  = new Gson();
			DetailsResponse responseBody = gson.fromJson(response.body().asReader(StandardCharsets.UTF_8), DetailsResponse.class);
			return responseBody.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PokeapiException("No se encontro el id del pokemon, intente mas tarde");
		}
	}

	@Override
	public String getLocationAreaEncountersByPokemon(String name, String urlOrigin, Date requestDate) throws PokeapiException {
		try {
			log.info(this.getClass().getName()+" -> "+new Object() {}
		      .getClass()
		      .getEnclosingMethod()
		      .getName());
			Response response = this.pokemonClient.getPokemonsByName(name);
			Gson gson  = new Gson();
			DetailsResponse responseBody = gson.fromJson(response.body().asReader(StandardCharsets.UTF_8), DetailsResponse.class);
			return responseBody.getLocationAreaEncounters();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PokeapiException("No se encontro el area del pokemon, intente mas tarde");
		}
	}
	
	private void saveFeignData(String urlOrigin, Date requestDate, Response response) {
		log.info("Response-> "+response);
		log.info("RequestURL Feign -> "+response.request().url());
		log.info("Request Method Feign -> "+response.request().httpMethod());
		this.recordsRepository.save(new RecordsEntity(urlOrigin,requestDate,response.request().httpMethod().name(),response.request().url().toString()));
	}

}
