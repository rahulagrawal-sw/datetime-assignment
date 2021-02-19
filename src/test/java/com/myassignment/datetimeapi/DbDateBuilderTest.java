package com.myassignment.datetimeapi;

import com.myassignment.exception.DbDateTimeException;
import com.myassignment.exception.DbDateTimeParseException;
import com.myassignment.exception.DbNoSuchSupportedDateTimePatternException;
import com.myassignment.model.DbDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DbDateBuilderTest {

    @Test
    @DisplayName("Given Valid Date 1 with Valid Pattern then should print valid date in formatted words")
    public void validDate1WithValidPattern() {
        DbDateBuilder dateBuilder = new DbDateBuilder();
        DbDate result = dateBuilder.buildDate("01-10-2021", "dd", "mm", "yyyy");
        Assertions.assertEquals("01st-Oct-Twenty TwentyOne", result.toString());
    }

    @Test
    @DisplayName("Given Valid Date 2 with Valid Pattern then should print valid date in formatted words")
    public void validDate2WithValidPattern() {
        DbDateBuilder dateBuilder = new DbDateBuilder();
        DbDate result = dateBuilder.buildDate("31-03-2020", "dd", "mm", "yyyy");
        Assertions.assertEquals("31st-Mar-Twenty Twenty", result.toString());
    }

    @Test
    @DisplayName("Given Valid Date 3 with Valid Pattern then should print valid date in formatted words")
    public void validDate3WithValidPattern() {
        DbDateBuilder dateBuilder = new DbDateBuilder();
        DbDate result = dateBuilder.buildDate("31-07-1902", "dd", "mm", "yyyy");
        Assertions.assertEquals("31st-Jul-Nineteen Two", result.toString());
    }

    @Test
    @DisplayName("Given Valid Date 4 with Valid Pattern then should print valid date in formatted words")
    public void validDate4WithValidPattern() {
        DbDateBuilder dateBuilder = new DbDateBuilder();
        DbDate result = dateBuilder.buildDate("15-08-1947", "dd", "mm", "yyyy");
        Assertions.assertEquals("15th-Aug-Nineteen FourtySeven", result.toString());
    }

    //----------------- Invalid pattern tests
    @Test
    @DisplayName("Given Valid Date with InValid Pattern (ddd) then should throw exception DbNoSuchSupportedDateTimePatternException")
    public void validDateWithInValidPattern1() {
        DbDateBuilder dateBuilder = new DbDateBuilder();
        Assertions.assertThrows(DbNoSuchSupportedDateTimePatternException.class,
                () -> dateBuilder.buildDate("01-10-2021", "ddd", "mm", "yyyy"));
    }

    @Test
    @DisplayName("Given Valid Date with InValid Pattern (MM) then should throw exception DbNoSuchSupportedDateTimePatternException")
    public void validDateWithInValidPattern2() {
        DbDateBuilder dateBuilder = new DbDateBuilder();
        Assertions.assertThrows(DbNoSuchSupportedDateTimePatternException.class,
                () -> dateBuilder.buildDate("01-10-2021", "dd", "MM", "yyyy"));
    }

    @Test
    @DisplayName("Given Valid Date with InValid Pattern (YYYY) then should throw exception DbNoSuchSupportedDateTimePatternException")
    public void validDateWithInValidPattern3() {
        DbDateBuilder dateBuilder = new DbDateBuilder();
        Assertions.assertThrows(DbNoSuchSupportedDateTimePatternException.class,
                () -> dateBuilder.buildDate("01-10-2021", "dd", "mm", "YYYY"));
    }

    //Invalid Date input - DbDateTimeParseException
    @Test
    @DisplayName("Given InValid Date with Valid Pattern then should throw exception DbDateTimeParseException")
    public void inValidDate1WithValidPattern() {
        DbDateBuilder dbDateBuilder = new DbDateBuilder();
        Assertions.assertThrows(DbDateTimeParseException.class,
                () -> dbDateBuilder.buildDate("01-10:21", "dd", "mm", "yyyy"));
    }

    //Invalid Date input - DbDateTimeException
    @Test
    @DisplayName("Given InValid Time (day) with Valid Pattern then should throw exception DbDateTimeException")
    public void inValidTime2WithValidPattern() {
        DbDateBuilder dbDateBuilder = new DbDateBuilder();
        Assertions.assertThrows(DbDateTimeException.class,
                () -> dbDateBuilder.buildDate("32-01-2020", "dd", "mm", "yyyy"));
    }

    @Test
    @DisplayName("Given InValid Time (month) with Valid Pattern then should throw exception DbDateTimeException")
    public void inValidTime3WithValidPattern() {
        DbDateBuilder dbDateBuilder = new DbDateBuilder();
        Assertions.assertThrows(DbDateTimeException.class,
                () -> dbDateBuilder.buildDate("11-13-1900", "dd", "mm", "yyyy"));
    }

    @Test
    @DisplayName("Given InValid Time (year) with Valid Pattern then should throw exception DbDateTimeException")
    public void inValidTime4WithValidPattern() {
        DbDateBuilder dbDateBuilder = new DbDateBuilder();
        Assertions.assertThrows(DbDateTimeException.class,
                () -> dbDateBuilder.buildDate("22-05-19819", "dd", "mm", "yyyy"));
    }
}
