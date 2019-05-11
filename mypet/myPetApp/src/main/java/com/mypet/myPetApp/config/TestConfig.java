package com.mypet.myPetApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mypet.myPetApp.service.DBService;


@Configuration
@Profile("test")// todos os bins dessa classe vai ser ativo apenas quando o test tiver ativo no application properties
public class TestConfig {
	

	@Autowired
	private DBService  dbService;
	
	@Bean
	public boolean instantiateDatabase() {
		dbService.instantiateTestDataBase();
		return true;
	}

}
