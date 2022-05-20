package com.sith.sir.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(
                exception,
                "Data error code: 03x03499fa. Please contact a System Administrator",
                new HttpHeaders(),
                HttpStatus.OK,
                request);
    }

}
