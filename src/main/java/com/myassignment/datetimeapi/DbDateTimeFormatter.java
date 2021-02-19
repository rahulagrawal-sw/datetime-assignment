package com.myassignment.datetimeapi;

import com.myassignment.exception.DbDateTimeException;
import com.myassignment.exception.DbDateTimeParseException;
import com.myassignment.exception.DbInvalidDateTimePatternException;
import com.myassignment.model.DbAmPm;
import com.myassignment.model.DbDate;
import com.myassignment.model.DbDateTime;
import com.myassignment.model.DbTime;

/**
 * Formatter for printing and parsing date-time objects.
 */
public final class DbDateTimeFormatter {

    private final String DAY_PATTERN;
    private final String MONTH_PATTERN;
    private final String YEAR_PATTERN;
    private final String HOUR_PATTERN;
    private final String MINUTE_PATTERN;
    private final String SECOND_PATTERN;
    private final String AMPM_PATTERN;

    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String COLON = ":";
    private static final String SLASH = "/";

    public DbDateTimeFormatter(String DAY_PATTERN, String MONTH_PATTERN, String YEAR_PATTERN, String HOUR_PATTERN, String MINUTE_PATTERN, String SECOND_PATTERN, String AMPM_PATTERN) {
        this.DAY_PATTERN = DAY_PATTERN;
        this.MONTH_PATTERN = MONTH_PATTERN;
        this.YEAR_PATTERN = YEAR_PATTERN;
        this.HOUR_PATTERN = HOUR_PATTERN;
        this.MINUTE_PATTERN = MINUTE_PATTERN;
        this.SECOND_PATTERN = SECOND_PATTERN;
        this.AMPM_PATTERN = AMPM_PATTERN;
    }

    //TODO: for better modularity & separation of concern below parsing code can be moved to another new helper class
    public static DbDateTimeFormatter ofPattern(String pattern) throws DbInvalidDateTimePatternException {
        if (pattern == null || pattern.length() != 25) {
            throw new DbInvalidDateTimePatternException("Invalid date time pattern : " + pattern);
        }

        String[] parts = pattern.split(SPACE);
        if (parts == null || parts.length != 3) {
            throw new DbInvalidDateTimePatternException("Invalid date time pattern : " + pattern);
        }

        // --------------- Split Date Parts ---------------------------
        String[] dateParts = parts[0].split(DASH);
        if (dateParts == null || dateParts.length != 3) {
            throw new DbInvalidDateTimePatternException("Invalid date time pattern : " + pattern);
        }
        final String dayPatternLocal = dateParts[0];
        final String monthPatternLocal = dateParts[1];
        final String yearPatternLocal = dateParts[2];

        // --------------- Split Time Parts ---------------------------
        String[] timeParts = parts[1].split(COLON);
        if (timeParts == null || timeParts.length != 3) {
            throw new DbInvalidDateTimePatternException("Invalid date time pattern : " + pattern);
        }
        final String hourPatternLocal = timeParts[0];
        final String minutePatternLocal = timeParts[1];
        final String secondPatternLocal = timeParts[2];

        // --------------- AM PM Part ---------------------------
        final String amPmPatternLocal [] = parts[2].split(SLASH);
        if (amPmPatternLocal == null || amPmPatternLocal.length != 2) {
            throw new DbInvalidDateTimePatternException("Invalid date time input : " + pattern);
        }

        return new DbDateTimeFormatter(dayPatternLocal, monthPatternLocal, yearPatternLocal, hourPatternLocal, minutePatternLocal, secondPatternLocal, parts[2]);
    }

    /**
     * Based in given input string, this will parse, create and return DbDateTime Object or throws exception
     *
     * @param inputDateTime, string value to accept given datetime string
     * @return DbDateTime object post successful creation
     * @throws DbDateTimeException
     * @throws DbDateTimeParseException
     */
    public DbDateTime parse(String inputDateTime) throws DbDateTimeException, DbDateTimeParseException {
        if (inputDateTime == null || inputDateTime.length() != 22) {
            throw new DbDateTimeException("Invalid date time input (either null OR length is not equal to 22): " + inputDateTime);
        }

        String[] parts = inputDateTime.split(SPACE);
        if (parts == null || parts.length != 3) {
            throw new DbDateTimeParseException("Parsing failed for given date time input : " + inputDateTime);
        }

        //build immutable date & time objects using formatter
        DbDate dbDate = new DbDateBuilder().buildDate(parts[0], DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        DbTime dbTime = new DbTimeBuilder().buildTime(parts[1], HOUR_PATTERN, MINUTE_PATTERN, SECOND_PATTERN);

        DbAmPm dbAmPmEnum = DbAmPm.of(parts[2]);

        return new DbDateTime(dbDate, dbTime, dbAmPmEnum);
    }
}
