package com.rgarmal.gestion.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracionRest{
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
