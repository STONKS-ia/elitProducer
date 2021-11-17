package com.br.elit.elitProducer.exception;

public class ApiBussinessException extends Exception{
    private String message;

    public ApiBussinessException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
