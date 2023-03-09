package com.jruchel.weatherdata.model.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private long timestamp;

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

}
