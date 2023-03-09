package com.jruchel.weatherdata.config;

import net.iakovlev.timeshape.TimeZoneEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GeneralConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TimeZoneEngine timeZoneEngine() {
        return TimeZoneEngine.initialize();
    }

}
