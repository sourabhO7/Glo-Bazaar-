package com.app.globazaar.exception;

import org.springframework.http.HttpStatus;
public class GloBazaarApiException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public GloBazaarApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
