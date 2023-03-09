package com.jruchel.weatherdata.controller;

import com.jruchel.weatherdata.aspect.SaveEndpointCall;
import com.jruchel.weatherdata.error.ValidationException;
import com.jruchel.weatherdata.model.dto.WeeklyWeatherDataDTO;
import com.jruchel.weatherdata.service.WeatherDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherDataController {

    private final WeatherDataService weatherDataService;

    @GetMapping("/lastWeek")
    @SaveEndpointCall
    public ResponseEntity<WeeklyWeatherDataDTO> getLastWeekWeatherData(@RequestParam Double latitude, @RequestParam Double longitude) throws ValidationException {
        validateLatitude(latitude);
        validateLongitude(longitude);
        return ResponseEntity.ok(weatherDataService.getLastWeekWeatherData(latitude, longitude));
    }

    private void validateLatitude(Double latitude) throws ValidationException {
        if (latitude == null) throw new ValidationException("latitude", null, "Latitude cannot be 'null'");
        if (latitude > 90.0 || latitude < -90)
            throw new ValidationException("latitude", String.valueOf(latitude), "Latitude must be between -90 and 90 degrees");
    }

    private void validateLongitude(Double longitude) throws ValidationException {
        if (longitude == null) throw new ValidationException("longitude", null, "Longitude cannot be 'null'");
        if (longitude > 180.0 || longitude < -180.0)
            throw new ValidationException("longitude", String.valueOf(longitude), "Longitude must be between -180 and 180 degrees");
    }
}
