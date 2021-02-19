package com.myassignment.exception;

public class DbDateTimeException extends RuntimeException {

    /**
     * Constructs a new custom DbDateTimeException with the given message.
     *
     * @param message the message to use for this DbDateTimeException, may be null
     */
    public DbDateTimeException(String message) {
        super(message);
    }

}
