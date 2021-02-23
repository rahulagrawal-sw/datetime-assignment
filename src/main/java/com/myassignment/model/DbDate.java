package com.myassignment.model;

import java.io.Serializable;

public final class DbDate implements Serializable {

    /**
     * The year.
     */
    private final String year;
    /**
     * The month-of-year.
     */
    private final DbMonth month;
    /**
     * The day-of-month.
     */
    private final short day;


    public DbDate(short day, DbMonth month, String year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        Integer yearPart1 = Integer.valueOf(year.substring(0, 2));
        Integer yearPart2 = Integer.valueOf(year.substring(2, 4));

        return ConstantMap.daysInWordsMap.get(Integer.valueOf(day)) +
                "-" +
                month.name() +
                "-" +
                ConstantMap.oneToSixtyInWordsMap.get(yearPart1) +
                " " +
                ConstantMap.oneToSixtyInWordsMap.get(yearPart2);
    }
}
