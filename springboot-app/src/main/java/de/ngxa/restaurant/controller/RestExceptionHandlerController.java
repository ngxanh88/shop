package de.ngxa.restaurant.controller;

import de.ngxa.restaurant.dto.ResponseErrorDetails;
import de.ngxa.restaurant.exception.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDetails> handleInvalidInputObject(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<ResponseErrorDetails> handleServletException(ServletException ex) {
        if(ex instanceof NoHandlerFoundException) {
            return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseErrorDetails> handleBadRequestException(BadRequestException ex) {
        return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getErrorType()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ResponseErrorDetails> handleForbiddenException(ForbiddenException ex) {
        return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseErrorDetails> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ResponseErrorDetails> handleUnauthorizedException(UnauthorizedException ex) {
        return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnsupportedMediaTypeException.class)
    public ResponseEntity<ResponseErrorDetails> handleUnsupportedMediaTypeException(UnsupportedMediaTypeException ex) {
        return new ResponseEntity<>(new ResponseErrorDetails(ex.getMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
}
