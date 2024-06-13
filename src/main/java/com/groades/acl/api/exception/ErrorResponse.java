package com.groades.acl.api.exception;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponse {
    private Map<String, String> errors;

    public ErrorResponse(Map<String, String> errors) {
        this.errors = errors;
    }
}
