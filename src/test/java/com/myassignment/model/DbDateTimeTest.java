package com.myassignment.model;

import com.myassignment.datetimeapi.DbDateTimeFormatter;
import com.myassignment.exception.DbDateTimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DbDateTimeTest {

    DbDate dbDate = new DbDate((short) 11, DbMonth.Aug, "2020");
    DbTime dbTime = new DbTime((byte) 10, (byte) 12, (byte) 55);

    @Test
    @DisplayName("Given Valid Date Time AM/PM input then should create DbDateTime instance")
    public void validDateTimeInput1() {
        DbDateTime dbDateTime = new DbDateTime(dbDate, dbTime, DbAmPm.AM);
        Assertions.assertNotNull(dbDateTime);
    }

    @Test
    @DisplayName("Given Valid Date Time AM/PM input to fetch date part then should return DbDate instance")
    public void validDateTimeInput1FetchDatePartOnly() {
        DbDateTime dbDateTime = new DbDateTime(dbDate, dbTime, DbAmPm.AM);
        Assertions.assertNotNull(dbDateTime.getDbDate());
    }

    @Test
    @DisplayName("Given Valid Date Time AM/PM input to fetch time part then should return DbTime instance")
    public void validDateTimeInput1FetchTimePartOnly() {
        DbDateTime dbDateTime = new DbDateTime(dbDate, dbTime, DbAmPm.AM);
        Assertions.assertNotNull(dbDateTime.getDbTime());
    }

    @Test
    @DisplayName("Given Valid Date Time AM/PM input to fetch AM/PM part then should return DbAmPm instance")
    public void validDateTimeInput1FetchAmPmPartOnly() {
        DbDateTime dbDateTime = new DbDateTime(dbDate, dbTime, DbAmPm.AM);
        Assertions.assertNotNull(dbDateTime.getDbAmPmEnum());
    }

    //test parse method
    @Test
    @DisplayName("Given Valid Date Time input to parse then should return DbDateTime instance")
    public void validDateTimeInput1ToParse() {
        String input1 = "01-12-2021 10:11:12 AM";
        String format = "dd-mm-yyyy hh:mm:ss AM/PM";  //only supported format with current implementation
        DbDateTimeFormatter formatter = DbDateTimeFormatter.ofPattern(format);
        DbDateTime dateTime = DbDateTime.parse(input1, formatter);
        Assertions.assertNotNull(dateTime);
    }

    @Test
    @DisplayName("Given Valid Date Time input to parse then should return DbDateTime instance")
    public void validDateTimeInput1ToParseWithNullFormatter() {
        String input1 = "01-12-2021 10:11:12 AM";
        DbDateTimeFormatter formatter = null;
        Assertions.assertThrows(DbDateTimeException.class,
                () -> DbDateTime.parse(input1, formatter));
    }

    @Test
    @DisplayName("Given Valid Date Time with Valid Pattern then should print valid date time in formatted words")
    public void validDateTime1WithValidPattern() {
        String input1 = "01-12-2021 10:11:12 AM";
        String format = "dd-mm-yyyy hh:mm:ss AM/PM";  //only supported format with current implementation
        DbDateTimeFormatter formatter = DbDateTimeFormatter.ofPattern(format);
        DbDateTime dateTime = DbDateTime.parse(input1, formatter);
        Assertions.assertEquals("01st-Dec-Twenty TwentyOne Ten Hours Eleven Minutes Twelve Seconds Morning", dateTime.toString());
    }
}
