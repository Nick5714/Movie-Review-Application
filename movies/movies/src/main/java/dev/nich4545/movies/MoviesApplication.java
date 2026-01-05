package dev.nich4545.movies;

import org.springframework.boot.SpringApplication; // contains 'Run' which is required to start the Spring application
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}
