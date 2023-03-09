package com.jruchel.weatherdata.error;

import lombok.Getter;

@Getter
public class ValidationException extends Exception {

    private String field;
    private String value;
    private String description;

    public ValidationException(String field, String value, String description) {
        this.field = field;
        this.value = value;
        this.description = description;
    }
}
