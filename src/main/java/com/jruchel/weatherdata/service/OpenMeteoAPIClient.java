package com.jruchel.weatherdata.service;

import com.jruchel.weatherdata.config.OpenMeteoAPIConfig;
import com.jruchel.weatherdata.model.openmeteo.archiveresponse.OpenMeteoArchiveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class OpenMeteoAPIClient {

    private final OpenMeteoAPIConfig config;
    private final RestTemplate restTemplate;

    public OpenMeteoArchiveResponse getHistoricalWeatherData(double latitude, double longitude, LocalDate startDate, LocalDate endDate) {
        String url = buildArchiveUrl(latitude, longitude, startDate, endDate);
        RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(url)).build();
        return restTemplate.exchange(requestEntity, OpenMeteoArchiveResponse.class).getBody();
    }

    private String buildArchiveUrl(double latitude, double longitude, LocalDate startDate, LocalDate endDate) {
        return config.getUrl() + config.getHistoricalDataEndpoint() + "?" +
                "latitude=" + latitude + "&" +
                "longitude=" + longitude + "&" +
                "start_date=" + startDate.toString() + "&" +
                "end_date=" + endDate.toString() + "&" +
                "daily=sunrise,sunset,rain_sum" + "&" +
                "timezone=auto" + "&" +
                "timeformat=unixtime";
    }

}
