package de.ngxa.restaurant.dto;

import de.ngxa.restaurant.constant.ResponseErrorType;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ResponseErrorDetails {

    private Date timestamp = new Date();
    private String message;
    private int status;
    private String reasonPhrase;
    private ResponseErrorType errorType = ResponseErrorType.UNKNOWN;

    public ResponseErrorDetails(String message, HttpStatus status) {
        this(message, status, ResponseErrorType.UNKNOWN);
    }

    public ResponseErrorDetails(String message, HttpStatus status, ResponseErrorType errorType) {
        this.message = message;
        this.status = status.value();
        this.reasonPhrase = status.getReasonPhrase();
        this.errorType = errorType;
    }
}
