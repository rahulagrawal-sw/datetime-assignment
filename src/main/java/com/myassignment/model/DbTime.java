package com.myassignment.model;

import java.io.Serializable;

public class DbTime implements Serializable {

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

    public DbTime(byte hour, byte minute, byte second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public String toString() {
        return ConstantMap.oneToSixtyInWordsMap.get(Integer.valueOf(hour)) +
                " Hours " +
                ConstantMap.oneToSixtyInWordsMap.get(Integer.valueOf(minute)) +
                " Minutes " +
                ConstantMap.oneToSixtyInWordsMap.get(Integer.valueOf(second)) +
                " Seconds";
    }
}
