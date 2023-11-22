package com.ineutm.backend.evaluaciones;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.reactive.config.EnableWebFlux;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@EnableWebFlux
@OpenAPIDefinition(info = @Info(title = "Evaluación", version = "1.0", description = "Evaluación Inetum 1.0"))
public class EvaluacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionesApplication.class, args);
	}

}
