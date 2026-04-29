package com.kuturogi.user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "User Service API",
        version = "1.0",
        description = "Kullanıcı kayıt, giriş ve profil yönetimi (Keycloak OAuth2)",
        contact = @Contact(name = "Bertuğ Kuturoğlu", email = "bkuturoglu61@gmail.com", url = "https://github.com/kuturogi")
    )
)
public class OpenApiConfig {}
