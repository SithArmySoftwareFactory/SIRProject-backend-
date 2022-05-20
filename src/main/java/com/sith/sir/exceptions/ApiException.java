package com.sith.sir.exceptions;

public class ApiException extends RuntimeException {
    private String message;
    private Throwable throwable;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    public ApiException(Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
    }

    public ApiException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.throwable = throwable;
    }

    public void logMessage(String message) {
        //TO-DO Log messages to server
    }
}
