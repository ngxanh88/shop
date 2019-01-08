package de.ngxa.restaurant.exception;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = -7963015924149781492L;

	public UnauthorizedException() {
	}

	public UnauthorizedException(String message) {
		super(message);
	}
}
