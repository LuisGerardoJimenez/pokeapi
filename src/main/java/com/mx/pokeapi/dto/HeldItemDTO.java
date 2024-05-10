package com.mx.pokeapi.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeldItemDTO implements Serializable{

	private static final long serialVersionUID = 381285012412782008L;
	
	private NameUrlDTO item;
	private ArrayList<VersionDetailDTO> versionDetails;

}
