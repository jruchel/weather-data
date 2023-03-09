package com.jruchel.weatherdata.service;

import com.jruchel.weatherdata.mapper.OpenMeteoArchiveResponseMapper;
import com.jruchel.weatherdata.model.database.WeatherDataEndpointCallEntry;
import com.jruchel.weatherdata.model.dto.WeeklyWeatherDataDTO;
import com.jruchel.weatherdata.model.openmeteo.archiveresponse.OpenMeteoArchiveResponse;
import com.jruchel.weatherdata.repository.WeatherDataEndpointCallRepository;
import com.jruchel.weatherdata.util.DateUtils;
import lombok.RequiredArgsConstructor;
import net.iakovlev.timeshape.TimeZoneEngine;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class WeatherDataService {

    private final OpenMeteoAPIClient openMeteoAPIClient;
    private final OpenMeteoArchiveResponseMapper openMeteoArchiveResponseMapper;
    private final TimeZoneEngine timeZoneEngine;

    public WeeklyWeatherDataDTO getLastWeekWeatherData(double latitude, double longitude) {
        List<LocalDate> weekDays = DateUtils.getWeekDays(LocalDate.now().minusWeeks(1), timeZoneEngine.query(latitude, longitude).orElse(ZoneId.systemDefault()));
        OpenMeteoArchiveResponse openMeteoResponse = openMeteoAPIClient.getHistoricalWeatherData(latitude, longitude, weekDays.get(0), weekDays.get(weekDays.size() - 1));
        return openMeteoArchiveResponseMapper.getWeeklyWeatherDataDTOFromOpenMeteoResponse(openMeteoResponse);
    }
}
