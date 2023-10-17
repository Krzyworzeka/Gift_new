package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("gift API")
                        .description("API dla podziału zadań przy przygotowaniu Szlachetnej Paczki")
                        .version("v1.1.1"));
    }

//    @Bean
//    public GroupedOpenApi actionApi(){
//        return GroupedOpenApi
//                .builder()
//                .group("action")
//                .packagesToScan("com.example.action")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi actionInfoApi(){
//        return GroupedOpenApi
//                .builder()
//                .group("actionInfo")
//                .packagesToScan("com.example.actionInfo")
//                .build();
//    }
//    @Bean
//    public GroupedOpenApi userApi(){
//        return GroupedOpenApi
//                .builder()
//                .group("user")
//                .packagesToScan("com.example.user")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi taskApi(){
//        return GroupedOpenApi
//                .builder()
//                .group("task")
//                .packagesToScan("com.example.task")
//                .build();
//    }

}
