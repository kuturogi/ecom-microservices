package com.kuturogi.sapintegration.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "SAP Integration Service API",
        version = "1.0",
        description = "E-ticaret siparişlerini SAP ERP'ye aktaran entegrasyon servisi. " +
                      "Kafka event-driven mimarisi üzerinden order eventi dinler, " +
                      "SAP BAPI_SALESORDER_CREATEFROMDAT2 simülasyonu ile SAP belge numarası üretir.",
        contact = @Contact(name = "Bertuğ Kuturoğlu", email = "bkuturoglu61@gmail.com", url = "https://github.com/kuturogi")
    )
)
public class OpenApiConfig {}
