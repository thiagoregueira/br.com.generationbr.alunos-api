package br.com.generationbr.alunosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = @Server(url = "/", description = "Defautl Server URL"))
@SpringBootApplication
public class AlunosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunosApiApplication.class, args);
	}

}
