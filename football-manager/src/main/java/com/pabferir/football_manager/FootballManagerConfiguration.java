package com.pabferir.football_manager;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FootballManagerConfiguration {

    // Web layer Beans ----------------------------------------------//
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Football Manager API")
                        .description("A Spring REST API using a Football Club Management data model for training in Java and Spring Boot fundamentals.")
                        .version("v1.0")
                        .license(new License().name("Apache License 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
    // Domain layer Beans -------------------------------------------//

    // Application layer Beans -------------------------------------//
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // Data Access layer Beans -------------------------------------//

}
