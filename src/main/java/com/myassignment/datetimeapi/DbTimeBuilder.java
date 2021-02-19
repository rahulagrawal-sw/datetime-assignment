package com.myassignment.datetimeapi;

import com.myassignment.exception.DbDateTimeException;
import com.myassignment.exception.DbDateTimeParseException;
import com.myassignment.exception.DbNoSuchSupportedDateTimePatternException;
import com.myassignment.model.DbTime;

public final class DbTimeBuilder {
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String COLON = ":";

    public DbTime buildTime(String inputTime, String HOUR_PATTERN, String MINUTE_PATTERN, String SECOND_PATTERN) throws DbNoSuchSupportedDateTimePatternException, DbDateTimeParseException, DbDateTimeException {
        // --------------- Split Time Parts ---------------------------
        String[] timeParts = inputTime.split(COLON);
        if (timeParts == null || timeParts.length != 3) {
            throw new DbDateTimeParseException("Parsing failed for given time part : " + inputTime);
        }

        // --------------- VALIDATE Time Part ---------------------------
        byte hour = 0;
        if ("hh".equals(HOUR_PATTERN)) {
            String hourStr = timeParts[0];
            if (hourStr == null || hourStr.length() != 2) {
                throw new DbDateTimeException("Invalid Time (hour length is not 2) : " + inputTime);
            }
            hour = Byte.valueOf(hourStr);
            if (hour > 12 || hour < 0) {
                throw new DbDateTimeException("Invalid Time (hour must be between 00 to 12) : " + inputTime);
            }
        } else {
            throw new DbNoSuchSupportedDateTimePatternException("No such supported pattern for given time : " + inputTime);
        }

        byte minute = 0;
        if ("mm".equals(MINUTE_PATTERN)) {
            String minuteStr = timeParts[1];
            if (minuteStr == null || minuteStr.length() != 2) {
                throw new DbDateTimeException("Invalid Time (minute length is not 2) : " + inputTime);
            }
            minute = Byte.valueOf(minuteStr);
            if (minute > 60 || minute < 0) {
                throw new DbDateTimeException("Invalid Time (minute must be between 00 to 60) : " + inputTime);
            }
        } else {
            throw new DbNoSuchSupportedDateTimePatternException("No such supported pattern for given time : " + inputTime);
        }

        byte second = 0;
        if ("ss".equals(SECOND_PATTERN)) {
            String secondStr = timeParts[2];
            if (secondStr == null || secondStr.length() != 2) {
                throw new DbDateTimeException("Invalid Time (second length is not 2) : " + inputTime);
            }
            second = Byte.valueOf(secondStr);
            if (second > 60 || second < 0) {
                throw new DbDateTimeException("Invalid Time (second must be between 00 to 60) : " + inputTime);
            }
        } else {
            throw new DbNoSuchSupportedDateTimePatternException("No such supported pattern for given time : " + inputTime);
        }

        return new DbTime(hour, minute, second);
    }
}
