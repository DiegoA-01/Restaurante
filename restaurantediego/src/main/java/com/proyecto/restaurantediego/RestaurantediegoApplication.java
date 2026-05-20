package com.proyecto.restaurantediego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class RestaurantediegoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantediegoApplication.class, args);
	}

}
