package com.guimasoftware.interfaces.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIValidationError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new APIValidationError(ex);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorMessage>  handle(RuntimeException ex) {
        if (ex instanceof ApiBadRequestException) {
            return new ResponseEntity<>(new ApiErrorMessage((ApiBadRequestException) ex), HttpStatus.BAD_REQUEST);
        }else if (ex instanceof ApiNotFoundException) {
            return new ResponseEntity<>(new ApiErrorMessage((ApiNotFoundException) ex), HttpStatus.NOT_FOUND);
        }else if (ex instanceof ApiException) {
            return new ResponseEntity<>(new ApiErrorMessage((ApiException) ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new ApiErrorMessage(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiErrorMessage> handle(Exception ex) {
        if (ex instanceof MissingServletRequestParameterException) {
            return new ResponseEntity<>(new ApiErrorMessage(ex), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ApiErrorMessage(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
