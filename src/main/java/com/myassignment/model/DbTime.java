package com.myassignment.model;

import java.io.Serializable;

public final class DbTime implements Serializable {

    /**
     * The hour.
     */
    private final byte hour;
    /**
     * The minute.
     */
    private final byte minute;
    /**
     * The second.
     */
    private final byte second;

    /**
     * The AM/PM
     */
    private final DbAmPm dbAmPm;

    public DbTime(byte hour, byte minute, byte second, DbAmPm dbAmPm) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.dbAmPm = dbAmPm;
    }

    @Override
    public String toString() {
        return ConstantMap.oneToSixtyInWordsMap.get(Integer.valueOf(hour)) +
                " Hours " +
                ConstantMap.oneToSixtyInWordsMap.get(Integer.valueOf(minute)) +
                " Minutes " +
                ConstantMap.oneToSixtyInWordsMap.get(Integer.valueOf(second)) +
                " Seconds" +
                " " +
                dbAmPm.toString();
    }
}
