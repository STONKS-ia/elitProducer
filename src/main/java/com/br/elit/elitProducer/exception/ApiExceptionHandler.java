package com.br.elit.elitProducer.exception;

import java.util.List;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.FieldError;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @Value("${rest.exception.handler.unexpected-error}")
    private String unexpectedError;

    @Value("${rest.exception.handler.resource-not-found}")
    private String resourceNotFound;

    @Value("${rest.exception.handler.invalid-json}")
    private String invalidJson;

    @Value("${rest.exception.handler.method-not-supported}")
    private String methodNotSupported;

    @Value("${rest.exception.handler.invalid-arguments}")
    private String invalidArguments;

    @Value("${rest.exception.handler.invalid-path-param}")
    private String invalidPathParam;

    @ExceptionHandler(value = {NoHandlerFoundException.class, NoSuchElementException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiException notFoundException(HttpServletRequest request, Exception exception) {
        return new ApiException(request, resourceNotFound, exception.getMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiException badRequestException(HttpServletRequest request, HttpMessageNotReadableException exception) {
        return new ApiException(request, invalidJson, exception.getMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiException badRequestException(HttpServletRequest request, HttpRequestMethodNotSupportedException exception) {
        return new ApiException(request, methodNotSupported, exception.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiException badRequestException(HttpServletRequest request, MethodArgumentTypeMismatchException exception) {
        return new ApiException(request, invalidPathParam, exception.getMessage());
    }

    @ExceptionHandler(value = ApiBussinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiException badRequestException(HttpServletRequest request, ApiBussinessException exception) {
        return new ApiException(request, invalidArguments, exception.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiException badRequestException(HttpServletRequest request, MethodArgumentNotValidException exception) {

        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        HashMap<String, String> detail = new HashMap<String, String>();

        for (FieldError fieldError : errors) {
            detail.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ApiException(request, invalidArguments, detail);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiException handleException(HttpServletRequest request, Exception exception) {
        return new ApiException(request, unexpectedError, exception.getMessage());
    }
}
