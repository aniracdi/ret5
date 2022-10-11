package com.usa.proyectoReto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.usa.proyectoReto3.Model"})
//@EnableJpaRepositories("Repository")
public class ProyectoReto3Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoReto3Application.class, args);

	}

}
