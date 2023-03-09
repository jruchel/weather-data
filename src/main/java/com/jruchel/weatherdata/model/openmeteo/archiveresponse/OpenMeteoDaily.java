package com.jruchel.weatherdata.model.openmeteo.archiveresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OpenMeteoDaily {

    private List<Integer> sunrise = new ArrayList<>();
    private List<Integer> sunset = new ArrayList<>();
    @JsonProperty("rain_sum")
    private List<Double> rainSum = new ArrayList<>();
}
