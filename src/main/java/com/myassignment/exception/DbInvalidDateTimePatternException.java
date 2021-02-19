package com.myassignment.exception;

public class DbInvalidDateTimePatternException extends RuntimeException {

    /**
     * Constructs a new custom DbInvalidDateTimePatternException with the given message.
     *
     * @param message the message to use for this DbInvalidDateTimePatternException, may be null
     */
    public DbInvalidDateTimePatternException(String message) {
        super(message);
    }

}
