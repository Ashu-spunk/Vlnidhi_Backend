package com.vlup.vlnidhi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VlnidhiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VlnidhiBackendApplication.class, args);
		
		System.out.println("Nidhi Bank Bankend Runs");
	}
	
	  @Bean
	  public ModelMapper modelMapper() {
		  return new ModelMapper();
	  }

}
