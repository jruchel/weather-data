package com.jruchel.weatherdata.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeeklyWeatherDataDTO {

    private List<DailyWeatherDataDTO> dailyWeatherData = new ArrayList<>();

}
