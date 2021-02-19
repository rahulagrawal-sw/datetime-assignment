package com.myassignment.exception;

public class DbDateTimeParseException extends RuntimeException {

    /**
     * Constructs a new custom DbDateTimeParseException with the given message.
     *
     * @param message the message to use for this DbDateTimeParseException, may be null
     */
    public DbDateTimeParseException(String message) {
        super(message);
    }

}
