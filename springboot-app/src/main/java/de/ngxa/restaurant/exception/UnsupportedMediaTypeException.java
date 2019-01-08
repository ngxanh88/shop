package de.ngxa.restaurant.exception;

public class UnsupportedMediaTypeException extends RuntimeException {

	private static final long serialVersionUID = 545657861680264719L;

	public UnsupportedMediaTypeException() {
	}

	public UnsupportedMediaTypeException(String message) {
		super(message);
	}
}
