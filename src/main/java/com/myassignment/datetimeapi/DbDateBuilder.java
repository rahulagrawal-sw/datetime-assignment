package com.myassignment.datetimeapi;

import com.myassignment.exception.DbDateTimeException;
import com.myassignment.exception.DbDateTimeParseException;
import com.myassignment.exception.DbNoSuchSupportedDateTimePatternException;
import com.myassignment.model.DbDate;
import com.myassignment.model.DbMonth;

public final class DbDateBuilder {
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String COLON = ":";

    public DbDate buildDate(String inputDate, String DAY_PATTERN, String MONTH_PATTERN, String YEAR_PATTERN) throws DbNoSuchSupportedDateTimePatternException, DbDateTimeParseException, DbDateTimeException {
        // --------------- Split Date Parts ---------------------------
        String[] dateParts = inputDate.split(DASH);
        if (dateParts == null || dateParts.length != 3) {
            throw new DbDateTimeParseException("Parsing failed for given date part (date don't have 3 parts) : " + inputDate);
        }

        // --------------- VALIDATE Date Part ---------------------------
        String yearStr = "";
        int year = 0;
        if ("yyyy".equals(YEAR_PATTERN)) {
            yearStr = dateParts[2];
            if (yearStr == null || yearStr.length() != 4) {
                throw new DbDateTimeException("Invalid Date (year length is not 4) : " + inputDate);
            }
            year = Integer.parseInt(yearStr);
        } else {
            throw new DbNoSuchSupportedDateTimePatternException("No such supported pattern for given date : " + inputDate);
        }

        short month = 0;
        DbMonth dbMonth = null;
        if ("mm".equals(MONTH_PATTERN)) {
            String monthStr = dateParts[1];
            if (monthStr == null || monthStr.length() != 2) {
                throw new DbDateTimeException("Invalid Date (month length is not 2) : " + inputDate);
            }
            month = Short.valueOf(monthStr);
            dbMonth = DbMonth.of(month);
        } else {
            throw new DbNoSuchSupportedDateTimePatternException("No such supported pattern for given date : " + inputDate);
        }

        short day = 0;
        if ("dd".equals(DAY_PATTERN)) {
            String dayStr = dateParts[0];
            if (dayStr == null || dayStr.length() != 2) {
                throw new DbDateTimeException("Invalid Date (day length is not 2) : " + inputDate);
            }
            day = Short.valueOf(dayStr);

            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
                throw new DbDateTimeException("Invalid Date (day must be between 1 to 31) : " + inputDate);
            }

            if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
                throw new DbDateTimeException("Invalid Date (day must be between 1 to 30) : " + inputDate);
            }

            //If month is February, validate days in February
            if (month == 2 && !DateUtil.validDaysInFeb(year, month, day)) {
                throw new DbDateTimeException("Invalid Date (incorrect days for Feb month) : " + inputDate);
            }
        } else {
            throw new DbNoSuchSupportedDateTimePatternException("No such supported pattern for given date : " + inputDate);
        }

        return new DbDate(day, dbMonth, yearStr);
    }

}
