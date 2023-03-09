package com.jruchel.weatherdata.aspect;

import com.jruchel.weatherdata.model.database.WeatherDataEndpointCallEntry;
import com.jruchel.weatherdata.service.WeatherDataEndpointCallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class SaveEndpointCallAspect {

    private final WeatherDataEndpointCallService weatherDataEndpointCallService;

    @Before("@annotation(com.jruchel.weatherdata.aspect.SaveEndpointCall)")
    public void saveMethodCall(JoinPoint joinPoint) {
        if (joinPoint.getSignature().toString().contains("WeatherDataController.getLastWeekWeatherData")) {
            Double latitude = (Double) joinPoint.getArgs()[0];
            Double longitude = (Double) joinPoint.getArgs()[1];
            weatherDataEndpointCallService.save(new WeatherDataEndpointCallEntry(latitude, longitude));
        }
    }

}
