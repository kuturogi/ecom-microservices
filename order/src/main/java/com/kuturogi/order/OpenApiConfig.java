package com.kuturogi.order;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Order Service API",
        version = "1.0",
        description = "Sepet yönetimi ve sipariş oluşturma (Kafka event-driven)",
        contact = @Contact(name = "Bertuğ Kuturoğlu", email = "bkuturoglu61@gmail.com", url = "https://github.com/kuturogi")
    )
)
public class OpenApiConfig {}
