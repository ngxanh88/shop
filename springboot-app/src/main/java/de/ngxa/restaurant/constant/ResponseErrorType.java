package de.ngxa.restaurant.constant;

public enum ResponseErrorType {

    UNKNOWN("UNKNOWN");

    private String typeName;

    ResponseErrorType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
