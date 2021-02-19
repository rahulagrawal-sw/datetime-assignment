package com.myassignment.datetimeapi;

import com.myassignment.exception.DbDateTimeException;
import com.myassignment.exception.DbDateTimeParseException;
import com.myassignment.exception.DbNoSuchSupportedDateTimePatternException;
import com.myassignment.model.DbTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DbTimeBuilderTest {

    @Test
    @DisplayName("Given Valid Time 1 with Valid Pattern then should print valid Time in formatted words")
    public void validTime1WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        DbTime result = TimeTimeBuilder.buildTime("11:10:20", "hh", "mm", "ss");
        Assertions.assertEquals("Eleven Hours Ten Minutes Twenty Seconds", result.toString());
    }

    @Test
    @DisplayName("Given Valid Time 2 with Valid Pattern then should print valid Time in formatted words")
    public void validTime2WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        DbTime result = TimeTimeBuilder.buildTime("09:59:59", "hh", "mm", "ss");
        Assertions.assertEquals("Nine Hours FiftyNine Minutes FiftyNine Seconds", result.toString());
    }

    @Test
    @DisplayName("Given Valid Time 3 with Valid Pattern then should print valid Time in formatted words")
    public void validTime3WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        DbTime result = TimeTimeBuilder.buildTime("00:00:29", "hh", "mm", "ss");
        Assertions.assertEquals("Zero Hours Zero Minutes TwentyNine Seconds", result.toString());
    }

    @Test
    @DisplayName("Given Valid Time 4 with Valid Pattern then should print valid Time in formatted words")
    public void validTime4WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        DbTime result = TimeTimeBuilder.buildTime("03:06:09", "hh", "mm", "ss");
        Assertions.assertEquals("Three Hours Six Minutes Nine Seconds", result.toString());
    }

    //----------------- Invalid pattern tests (DbNoSuchSupportedTimeTimePatternException)
    @Test
    @DisplayName("Given Valid Time with InValid Pattern (HH) then should throw exception DbNoSuchSupportedTimeTimePatternException")
    public void validTimeWithInValidPattern1() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        Assertions.assertThrows(DbNoSuchSupportedDateTimePatternException.class,
                () -> TimeTimeBuilder.buildTime("03:06:09", "HH", "mm", "ss"));
    }

    @Test
    @DisplayName("Given Valid Time with InValid Pattern (MM) then should throw exception DbNoSuchSupportedTimeTimePatternException")
    public void validTimeWithInValidPattern2() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        Assertions.assertThrows(DbNoSuchSupportedDateTimePatternException.class,
                () -> TimeTimeBuilder.buildTime("03:06:09", "dd", "MM", "ss"));
    }

    @Test
    @DisplayName("Given Valid Time with InValid Pattern (SS) then should throw exception DbNoSuchSupportedTimeTimePatternException")
    public void validTimeWithInValidPattern3() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        Assertions.assertThrows(DbNoSuchSupportedDateTimePatternException.class,
                () -> TimeTimeBuilder.buildTime("03:06:09", "dd", "mm", "SS"));
    }

    //Invalid Time input - DbDateTimeParseException
    @Test
    @DisplayName("Given InValid Time with Valid Pattern then should throw exception DbDateTimeParseException")
    public void inValidTime1WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        Assertions.assertThrows(DbDateTimeParseException.class,
                () -> TimeTimeBuilder.buildTime("01-10:21", "hh", "mm", "ss"));
    }
    @Test
    @DisplayName("Given InValid Time (hour) with Valid Pattern then should throw exception DbDateTimeException")
    public void inValidTime2WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        Assertions.assertThrows(DbDateTimeException.class,
                () -> TimeTimeBuilder.buildTime("13:10:21", "hh", "mm", "ss"));
    }

    @Test
    @DisplayName("Given InValid Time (minute) with Valid Pattern then should throw exception DbDateTimeException")
    public void inValidTime3WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        Assertions.assertThrows(DbDateTimeException.class,
                () -> TimeTimeBuilder.buildTime("01:61:21", "hh", "mm", "ss"));
    }

    @Test
    @DisplayName("Given InValid Time (second) with Valid Pattern then should throw exception DbDateTimeException")
    public void inValidTime4WithValidPattern() {
        DbTimeBuilder TimeTimeBuilder = new DbTimeBuilder();
        Assertions.assertThrows(DbDateTimeException.class,
                () -> TimeTimeBuilder.buildTime("01:10:65", "hh", "mm", "ss"));
    }
}
