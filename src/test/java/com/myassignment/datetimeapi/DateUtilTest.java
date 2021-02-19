package com.myassignment.datetimeapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateUtilTest {

    @Test
    @DisplayName("Given Leap Year then return True")
    public void isLeapYear() {
        int year = 2020;
        boolean result = DateUtil.isLeap(year);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Given Non Leap Year then return False")
    public void isNonLeapYear() {
        int year = 2021;
        boolean result = DateUtil.isLeap(year);
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("Given Leap Year & Valid days in Feb then then should return True")
    public void testLeapYearFebMonthValidDays() {
        int year = 2020;
        boolean result = DateUtil.validDaysInFeb(year, 2, 29);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Given Leap Year & Valid days in Feb then  then should return True")
    public void testNonLeapYearFebMonthValidDays() {
        int year = 2021;
        boolean result = DateUtil.validDaysInFeb(year, 2, 28);
        Assertions.assertEquals(true, result);
    }
    @Test
    @DisplayName("Given Leap Year & InValid days in Feb then should return False")
    public void testLeapYearFebMonthInValidDays() {
        int year = 2020;
        boolean result = DateUtil.validDaysInFeb(year, 2, 30);
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("Given Non Leap Year & InValid days in Feb then should return False")
    public void testNonLeapYearFebMonthInValidDays() {
        int year = 2021;
        boolean result = DateUtil.validDaysInFeb(year, 2, 29);
        Assertions.assertEquals(false, result);
    }
}
