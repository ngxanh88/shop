package de.ngxa.restaurant.exception;

public class DuplicateLdapUserException extends Exception {

    private final String username;

    public DuplicateLdapUserException(String username, String message) {
        super(message);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
