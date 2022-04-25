package com.adria.noyauservice;

import com.adria.noyauservice.entities.ConnectionMatrix;
import com.adria.noyauservice.repositories.ConnectionMatrixRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class NoyauServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoyauServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(ConnectionMatrixRepository connectionMatrixRepository){
		return args -> {
			connectionMatrixRepository.save(new ConnectionMatrix(null, 1L, 1L));
			connectionMatrixRepository.save(new ConnectionMatrix(null, 2L, 1L));
			connectionMatrixRepository.save(new ConnectionMatrix(null, 3L, 2L));
		};
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

}
