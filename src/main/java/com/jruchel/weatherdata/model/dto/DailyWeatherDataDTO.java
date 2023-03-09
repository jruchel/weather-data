package com.jruchel.weatherdata.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DailyWeatherDataDTO {

    private LocalDate date;
    private LocalTime sunrise;
    private LocalTime sunset;
    private RainfallDTO rainfall;

}
