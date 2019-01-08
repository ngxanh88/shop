package de.ngxa.restaurant.exception;

import de.ngxa.restaurant.constant.ResponseErrorType;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -6004679274682198618L;

	private ResponseErrorType errorType = ResponseErrorType.UNKNOWN;

	public BadRequestException() {
	}

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, ResponseErrorType errorType) {
		super(message);
		this.errorType = errorType;
	}

	public ResponseErrorType getErrorType() {
		return errorType;
	}
}
