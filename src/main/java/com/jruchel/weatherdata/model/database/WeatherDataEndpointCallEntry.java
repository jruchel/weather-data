package com.jruchel.weatherdata.model.database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class WeatherDataEndpointCallEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private double latitude;
    private double longitude;
    private double timestamp;

    public WeatherDataEndpointCallEntry(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = System.currentTimeMillis();
    }

}
