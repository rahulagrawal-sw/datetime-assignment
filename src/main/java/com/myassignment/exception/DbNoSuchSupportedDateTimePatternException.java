package com.myassignment.exception;

public class DbNoSuchSupportedDateTimePatternException extends RuntimeException {

    /**
     * Constructs a new custom DbNoSuchSupportedDateTimeException with the given message.
     *
     * @param message the message to use for this DbNoSuchSupportedDateTimeException, may be null
     */
    public DbNoSuchSupportedDateTimePatternException(String message) {
        super(message);
    }

}
