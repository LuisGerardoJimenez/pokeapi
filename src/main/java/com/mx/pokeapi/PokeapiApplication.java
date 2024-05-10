package com.mx.pokeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration
@EntityScan("com.mx.pokeapi.entity")
public class PokeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeapiApplication.class, args);
	}

}
