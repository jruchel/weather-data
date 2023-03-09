package com.jruchel.weatherdata.service;

import com.jruchel.weatherdata.model.database.WeatherDataEndpointCallEntry;
import com.jruchel.weatherdata.repository.WeatherDataEndpointCallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherDataEndpointCallService {

    private final WeatherDataEndpointCallRepository repository;

    public void save(WeatherDataEndpointCallEntry entry) {
        repository.save(entry);
    }

}
