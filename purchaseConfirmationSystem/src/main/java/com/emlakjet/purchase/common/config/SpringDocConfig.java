package com.emlakjet.purchase.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Spring doc config.
 */
@Configuration
public class SpringDocConfig {

    /**
     * Configure open api info open api.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI configureOpenApiInfo() {

        return new OpenAPI().info(new Info().title("EmlakJet APIs").version("1.0.0")
                .description("Kadir Özçamur Case"));

    }
}
