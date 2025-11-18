package com.example.livros.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Gerenciador de Livros API",
                version = "v1",
                description = "API RESTful para CRUD de livros",
                contact = @Contact(name = "Jose Gabriel", email = "josetropilo@gmail.com")
        )
)
public class OpenApiConfig {}
