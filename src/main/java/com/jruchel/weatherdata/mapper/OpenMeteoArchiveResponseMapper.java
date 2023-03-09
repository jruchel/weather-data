package com.jruchel.weatherdata.mapper;

import com.jruchel.weatherdata.model.dto.DailyWeatherDataDTO;
import com.jruchel.weatherdata.model.dto.RainfallDTO;
import com.jruchel.weatherdata.model.dto.WeeklyWeatherDataDTO;
import com.jruchel.weatherdata.model.openmeteo.archiveresponse.OpenMeteoArchiveResponse;
import com.jruchel.weatherdata.util.DateUtils;
import org.springframework.stereotype.Component;

@Component
public class OpenMeteoArchiveResponseMapper {

    public WeeklyWeatherDataDTO getWeeklyWeatherDataDTOFromOpenMeteoResponse(OpenMeteoArchiveResponse response) {
        WeeklyWeatherDataDTO result = new WeeklyWeatherDataDTO();

        String timezone = response.getTimezone();
        int days = response.getDaily().getSunrise().size();


        for (int i = 0; i < days; i++) {
            long sunrise = response.getDaily().getSunrise().get(i);
            long sunset = response.getDaily().getSunset().get(i);
            Double totalRainfall = response.getDaily().getRainSum().get(i);
            result.getDailyWeatherData().add(getDailyWeatherDataDTO(sunrise, sunset, totalRainfall, timezone));
        }
        return result;
    }

    private DailyWeatherDataDTO getDailyWeatherDataDTO(long sunrise, long sunset, Double rainSum, String timezone) {
        DailyWeatherDataDTO result = new DailyWeatherDataDTO();
        result.setDate(DateUtils.getDateFromTimestamp(sunrise, timezone));
        result.setSunrise(DateUtils.getTimeFromTimestamp(sunrise, timezone));
        result.setSunset(DateUtils.getTimeFromTimestamp(sunset, timezone));
        if (rainSum != null) {
            RainfallDTO rainfallDTO = new RainfallDTO();
            rainfallDTO.setTotal(rainSum);
            rainfallDTO.setAveragePerHour(rainSum / 24.0);
            result.setRainfall(rainfallDTO);
        }
        return result;
    }

}
