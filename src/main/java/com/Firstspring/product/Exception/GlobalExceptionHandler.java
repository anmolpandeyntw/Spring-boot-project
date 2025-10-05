package com.Firstspring.product.Exception;

import com.Firstspring.product.dto.ExceptionResposeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * GlobalExceptionHandler: A centralized exception handler for the entire application.
 * It uses @ControllerAdvice to intercept exceptions thrown by @Controller and @RestController methods.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles CategoryAlreadyExistsException.
     * This method is invoked when a CategoryAlreadyExistsException is thrown from any controller.
     * It constructs a custom ExceptionResposeDTO and returns it with an HTTP 409 Conflict status.
     *
     * @param ex The CategoryAlreadyExistsException that was thrown.
     * @param webRequest The WebRequest object, providing details about the current request.
     * @return A ResponseEntity containing ExceptionResposeDTO and HttpStatus.CONFLICT.
     */
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResposeDTO> handleCategoryAlreadyExistsException(
            CategoryAlreadyExistsException ex,
            WebRequest webRequest) {

        // Create an ExceptionResposeDTO to provide structured error details.
        // webRequest.getDescription(false) fetches the request URI without client-specific info.
        ExceptionResposeDTO errorResponse = new ExceptionResposeDTO(
                webRequest.getDescription(false), // The request URI (e.g., /api/categories)
                HttpStatus.CONFLICT,             // HTTP status code: 409 Conflict
                ex.getMessage(),                 // The specific error message from the exception
                LocalDateTime.now()              // Timestamp of when the error occurred
        );

        // Return a ResponseEntity with the configured status and the custom error response body.
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }


    /**
     * Handles CategoryNotFoundException.
     * This method is invoked when a CategoryNotFoundException is thrown.
     * It returns the exception message directly with an HTTP 404 Not Found status.
     * (NOTE: Using HttpStatus.NOT_FOUND is generally more appropriate for "not found" errors,
     * but keeping CONFLICT as per your original code. Consider changing to NOT_FOUND for clarity).
     *
     * @param ex The CategoryNotFoundException that was thrown.
     * @return A ResponseEntity containing the error message (String) and HttpStatus.NOT_FOUND (or CONFLICT).
     */
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResposeDTO> handleCategoryNotFoundException(CategoryNotFoundException ex ,  WebRequest webRequest) {

        ExceptionResposeDTO exceptionResposeDTO = new ExceptionResposeDTO(
                webRequest.getDescription(false), // The request URI (e.g., /api/categories)
                HttpStatus.NOT_FOUND,             // HTTP status code: 409 Conflict
                ex.getMessage(),                 // The specific error message from the exception
                LocalDateTime.now()              // Timestamp of when the error occurred
        );

        return  ResponseEntity.status(HttpStatus.NOT_FOUND ).body(exceptionResposeDTO); // Changed to NOT_FOUND for best practice



    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResposeDTO> handleGlobalException( Exception ex ,  WebRequest webRequest) {

        ExceptionResposeDTO exceptionResposeDTO = new ExceptionResposeDTO(
                webRequest.getDescription(false), // The request URI (e.g., /api/categories)
                HttpStatus.INTERNAL_SERVER_ERROR,             // HTTP status code: 409 Conflict
                ex.getMessage(),                 // The specific error message from the exception
                LocalDateTime.now()              // Timestamp of when the error occurred
        );

        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body(exceptionResposeDTO); // Changed to NOT_FOUND for best practice



    }



}