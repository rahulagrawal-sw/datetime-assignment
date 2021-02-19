package com.myassignment.model;

import com.myassignment.exception.DbDateTimeException;

public enum DbAmPm {

    AM,
    PM;

    public static DbAmPm of(String amPm) {
        if (amPm.equals("AM") ) {
            return DbAmPm.AM;
        } else if(amPm.equals("PM")) {
            return DbAmPm.PM;
        } else {
            throw new DbDateTimeException("Invalid value for given AM/PM: " + amPm);
        }
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override
    public String toString() {
        if (this.getValue() == 1)
            return "Morning";
        else if (this.getValue() == 2)
            return "Evening";
        else
            return "";
    }
}
