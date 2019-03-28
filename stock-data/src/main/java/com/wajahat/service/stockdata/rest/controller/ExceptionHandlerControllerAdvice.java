package com.wajahat.service.stockdata.rest.controller;

import com.wajahat.service.stockdata.rest.domain.ErrorResponse;
import com.wajahat.service.stockdata.rest.exception.InvalidParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;

/**
 * ExceptionHandler for REST APIs
 *
 * @author Wajahat Siddiqui
 */
@Slf4j
@ControllerAdvice(basePackages = {"com.wajahat.service.stockdata.rest.controller"} )
public class ExceptionHandlerControllerAdvice {

    /**
     * Handles {@link InvalidParameterException} by sending
     * {@link HttpStatus#BAD_REQUEST} response
     *
     * @param ex      {@link InvalidParameterException}
     * @param request {@link WebRequest}
     * @return {@link HttpStatus#BAD_REQUEST} response
     */
    @ExceptionHandler({ InvalidParameterException.class })
    public ResponseEntity<ErrorResponse> handleException(InvalidParameterException ex, WebRequest request) {

        log.info("InvalidParameterException :: " + Arrays.toString(ex.getStackTrace()));
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, getContentTypeHeader(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles {@link Exception} - Generic exception class by sending
     * {@link HttpStatus#INTERNAL_SERVER_ERROR} response
     *
     * @param ex      {@link Exception}
     * @param request {@link WebRequest}
     * @return {@link HttpStatus#INTERNAL_SERVER_ERROR} response
     */
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
        log.info("Exception :: " + ex.getClass() + "\n" + ex.getCause());
        log.info("Exception :: " + ex.getLocalizedMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, getContentTypeHeader(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private HttpHeaders getContentTypeHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
