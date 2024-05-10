package com.mx.pokeapi.feign.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameIndexResponse implements Serializable{

	private static final long serialVersionUID = -1393361483953246957L;
	
	private Integer gameIndex;
	private ArrayList<NameUrlResponse> version;

}
