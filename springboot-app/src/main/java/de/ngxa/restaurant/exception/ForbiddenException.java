package de.ngxa.restaurant.exception;

public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 289197335695146258L;

	public ForbiddenException() {
	}

	public ForbiddenException(String message) {
		super(message);
	}
}
