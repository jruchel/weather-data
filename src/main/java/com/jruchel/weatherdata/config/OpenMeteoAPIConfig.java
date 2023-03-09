package com.jruchel.weatherdata.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("open-meteo")
@Getter
@Setter
public class OpenMeteoAPIConfig {

    private String url;
    public String historicalDataEndpoint;

}
