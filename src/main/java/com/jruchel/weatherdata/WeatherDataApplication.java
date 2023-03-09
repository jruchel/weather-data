package com.jruchel.weatherdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableConfigurationProperties
@SpringBootApplication
@EnableJpaRepositories
public class WeatherDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataApplication.class, args);
    }

}
