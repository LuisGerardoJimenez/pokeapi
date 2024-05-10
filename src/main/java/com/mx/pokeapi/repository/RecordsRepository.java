package com.mx.pokeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.pokeapi.entity.RecordsEntity;

@Repository
public interface RecordsRepository extends JpaRepository<RecordsEntity, Long>{

	RecordsEntity findAllById(Long id);
	
}
