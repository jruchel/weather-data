package com.jruchel.weatherdata.repository;

import com.jruchel.weatherdata.model.database.WeatherDataEndpointCallEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataEndpointCallRepository extends JpaRepository<WeatherDataEndpointCallEntry, String> {

}
