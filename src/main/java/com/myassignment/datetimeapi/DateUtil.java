package com.myassignment.datetimeapi;

public abstract class DateUtil {

    public static boolean isLeap(int year) {
        return year % 4 == 0;
    }

    public static boolean validDaysInFeb(int year, int day) {
        if (DateUtil.isLeap(year)) {
            //if leap year then 29 days
            return day <= 29 && day >= 1;
        } else {
            //if NOT leap year then 28 days
            return day <= 28 && day >= 1;
        }
    }
}
