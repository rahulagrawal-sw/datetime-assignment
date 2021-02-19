package com.myassignment.model;

import com.myassignment.datetimeapi.DbDateTimeFormatter;
import com.myassignment.exception.DbDateTimeException;

import java.io.Serializable;
import java.util.Objects;

public class DbDateTime implements Serializable {

    /**
     * The date part.
     */
    private final DbDate dbDate;
    /**
     * The time part.
     */
    private final DbTime dbTime;

    /**
     * The AM/PM part.
     */
    private final DbAmPm dbAmPmEnum;

    public DbDateTime(DbDate date, DbTime time, DbAmPm dbAmPmEnum) {
        this.dbDate = date;
        this.dbTime = time;
        this.dbAmPmEnum = dbAmPmEnum;
    }

    public static DbDateTime parse(String inputDateTime, DbDateTimeFormatter formatter) throws DbDateTimeException {
        if(formatter == null) {
            throw new DbDateTimeException("formatter is null");
        }
        return formatter.parse(inputDateTime);
    }

    public DbDate getDbDate() {
        return dbDate;
    }

    public DbTime getDbTime() {
        return dbTime;
    }

    public DbAmPm getDbAmPmEnum() {
        return dbAmPmEnum;
    }

    @Override
    public String toString() {
        return dbDate.toString() +
                " " + dbTime.toString() +
                " " + dbAmPmEnum.toString();
    }
}
