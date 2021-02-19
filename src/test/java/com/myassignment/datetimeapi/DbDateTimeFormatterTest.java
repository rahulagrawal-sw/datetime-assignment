package com.myassignment.datetimeapi;

import com.myassignment.exception.DbDateTimeException;
import com.myassignment.exception.DbInvalidDateTimePatternException;
import com.myassignment.model.DbDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DbDateTimeFormatterTest {

    String patternGlobal = "dd-mm-yyyy hh:mm:ss AM/PM";
    DbDateTimeFormatter dbDateTimeFormatterGlobal = DbDateTimeFormatter.ofPattern(patternGlobal);

    @Test
    @DisplayName("Given Valid Pattern then should return DbDateTimeFormatter instance")
    public void validDateTimePattern() {
        String pattern = "dd-mm-yyyy hh:mm:ss AM/PM";
        DbDateTimeFormatter dbDateTimeFormatter = DbDateTimeFormatter.ofPattern(pattern);
        Assertions.assertNotNull(dbDateTimeFormatter);
    }

    @Test
    @DisplayName("Given InValid Pattern (backslash in date) then should throw DbInvalidDateTimePatternException")
    public void inValidDateTimePattern1() {
        String pattern = "dd/mm/yyyy hh:mm:ss AM/PM";
        Assertions.assertThrows(DbInvalidDateTimePatternException.class,
                () -> DbDateTimeFormatter.ofPattern(pattern));
    }

    @Test
    @DisplayName("Given InValid Pattern (dash in time) then should throw DbInvalidDateTimePatternException")
    public void inValidDateTimePattern2() {
        String pattern = "dd-mm-yyyy hh-mm-ss AM/PM";
        Assertions.assertThrows(DbInvalidDateTimePatternException.class,
                () -> DbDateTimeFormatter.ofPattern(pattern));
    }

    @Test
    @DisplayName("Given InValid Pattern (dash in AM_PM) then should throw DbInvalidDateTimePatternException")
    public void inValidDateTimePattern3() {
        String pattern = "dd-mm-yyyy hh:mm:ss AM-PM";
        Assertions.assertThrows(DbInvalidDateTimePatternException.class,
                () -> DbDateTimeFormatter.ofPattern(pattern));
    }

    @Test
    @DisplayName("Given InValid Pattern (length) then should throw DbInvalidDateTimePatternException")
    public void inValidDateTimePattern4() {
        String pattern = "dd-mm-yy hh:mm:ss AM-PM";
        Assertions.assertThrows(DbInvalidDateTimePatternException.class,
                () -> DbDateTimeFormatter.ofPattern(pattern));
    }

    //Valid date time inputs
    @Test
    @DisplayName("Given Valid input datetime then should return instance of DbDateTime")
    public void validDateTime1() {
        String input = "01-12-2021 10:11:12 AM";
        DbDateTime dbDateTime = dbDateTimeFormatterGlobal.parse(input);
        Assertions.assertNotNull(dbDateTime);
    }

    @Test
    @DisplayName("Given Valid input datetime then should return instance of DbDateTime")
    public void validDateTime2() {
        String input = "21-11-1978 11:21:52 AM";
        DbDateTime dbDateTime = dbDateTimeFormatterGlobal.parse(input);
        Assertions.assertNotNull(dbDateTime);
    }

    @Test
    @DisplayName("Given InValid input datetime (without AM/PM) then should throw DbDateTimeParseException")
    public void inValidDateTime1() {
        String input = "21-11-1978 11:21:52 ";
        Assertions.assertThrows(DbDateTimeException.class,
                () -> dbDateTimeFormatterGlobal.parse(input));
    }
}
