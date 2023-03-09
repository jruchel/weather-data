package com.jruchel.weatherdata.model.openmeteo.archiveresponse;

import lombok.Data;

@Data
public class OpenMeteoArchiveResponse {
    private OpenMeteoDaily daily;
    private String timezone;

}
