package com.example.monumento;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
				@Info(description = "Una API de monumentos",
								version = "1.0",
								contact = @Contact(
									email = "castilla.caalv24@triana.salesianos.edu",
									name = "Álvaro"
								),
						license = @License(
								name = "No se que poner"),
						title = "API sobre productos."

				))
public class MonumentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonumentoApplication.class, args);
	}

}
