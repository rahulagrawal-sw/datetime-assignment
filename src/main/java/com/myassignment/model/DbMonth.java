package com.myassignment.model;

import com.myassignment.exception.DbDateTimeException;

public enum DbMonth {

    Jan,
    Feb,
    Mar,
    Apr,
    Mau,
    Jun,
    Jul,
    Aug,
    Sep,
    Oct,
    Nov,
    Dec;

    private static final DbMonth[] MONTHS_ENUMS = DbMonth.values();

    public static DbMonth of(int month) {
        if (month < 1 || month > 12) {
            throw new DbDateTimeException("Invalid value for given Month: " + month);
        }
        return MONTHS_ENUMS[month - 1];
    }
}
