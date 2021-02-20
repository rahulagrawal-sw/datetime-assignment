package com.myassignment;

import com.myassignment.datetimeapi.DbDateTimeFormatter;
import com.myassignment.model.DbDateTime;

public class Main {

    public static void main(String[] args) {
        //Driver class
        String input1 = "01-12-2021 10:11:12 AM";
        String format = "dd-mm-yyyy hh:mm:ss AM/PM";  //only supported format with current implementation
        DbDateTimeFormatter formatter = DbDateTimeFormatter.ofPattern(format);
        DbDateTime dateTime = DbDateTime.parse(input1, formatter);

        System.out.println(String.format("Valid Date: %s", dateTime.getDbDate().toString()));
        System.out.println(String.format("Valid Time: %s", dateTime.getDbTime().toString()));
    }
}
