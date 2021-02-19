package com.myassignment.model;

import java.util.HashMap;
import java.util.Map;

public abstract class ConstantMap {
    public static Map<Integer, String> daysInWordsMap;
    public static Map<Integer, String> oneToSixtyInWordsMap;

    static {
        daysInWordsMap = new HashMap<>();
        daysInWordsMap.put(1, "01st");
        daysInWordsMap.put(2, "02nd");
        daysInWordsMap.put(3, "03rd");
        daysInWordsMap.put(4, "04th");
        daysInWordsMap.put(5, "05th");
        daysInWordsMap.put(6, "06th");
        daysInWordsMap.put(7, "07th");
        daysInWordsMap.put(8, "08th");
        daysInWordsMap.put(9, "09th");
        daysInWordsMap.put(10, "10th");
        daysInWordsMap.put(11, "11th");
        daysInWordsMap.put(12, "12th");
        daysInWordsMap.put(13, "13th");
        daysInWordsMap.put(14, "14th");
        daysInWordsMap.put(15, "15th");
        daysInWordsMap.put(16, "16th");
        daysInWordsMap.put(17, "17th");
        daysInWordsMap.put(18, "18th");
        daysInWordsMap.put(19, "19th");
        daysInWordsMap.put(20, "20th");
        daysInWordsMap.put(21, "21st");
        daysInWordsMap.put(22, "22nd");
        daysInWordsMap.put(23, "23rd");
        daysInWordsMap.put(24, "24th");
        daysInWordsMap.put(25, "25th");
        daysInWordsMap.put(26, "26th");
        daysInWordsMap.put(27, "27th");
        daysInWordsMap.put(28, "28th");
        daysInWordsMap.put(29, "29th");
        daysInWordsMap.put(30, "30th");
        daysInWordsMap.put(31, "31st");

        //--------------ToSixtyInWordsMap
        oneToSixtyInWordsMap = new HashMap<>();
        oneToSixtyInWordsMap.put(0, "Zero");
        oneToSixtyInWordsMap.put(1, "One");
        oneToSixtyInWordsMap.put(2, "Two");
        oneToSixtyInWordsMap.put(3, "Three");
        oneToSixtyInWordsMap.put(4, "Four");
        oneToSixtyInWordsMap.put(5, "Five");
        oneToSixtyInWordsMap.put(6, "Six");
        oneToSixtyInWordsMap.put(7, "Seven");
        oneToSixtyInWordsMap.put(8, "Eight");
        oneToSixtyInWordsMap.put(9, "Nine");
        oneToSixtyInWordsMap.put(10, "Ten");
        oneToSixtyInWordsMap.put(11, "Eleven");
        oneToSixtyInWordsMap.put(12, "Twelve");
        oneToSixtyInWordsMap.put(13, "Thirteen");
        oneToSixtyInWordsMap.put(14, "Fourteen");
        oneToSixtyInWordsMap.put(15, "Fifteen");
        oneToSixtyInWordsMap.put(16, "Sixteen");
        oneToSixtyInWordsMap.put(17, "Seventeen");
        oneToSixtyInWordsMap.put(18, "Eighteen");
        oneToSixtyInWordsMap.put(19, "Nineteen");
        oneToSixtyInWordsMap.put(20, "Twenty");
        oneToSixtyInWordsMap.put(21, "TwentyOne");
        oneToSixtyInWordsMap.put(22, "TwentyTwo");
        oneToSixtyInWordsMap.put(23, "TwentyThree");
        oneToSixtyInWordsMap.put(24, "TwentyFour");
        oneToSixtyInWordsMap.put(25, "TwentyFive");
        oneToSixtyInWordsMap.put(26, "TwentySix");
        oneToSixtyInWordsMap.put(27, "TwentySeven");
        oneToSixtyInWordsMap.put(28, "TwentyEight");
        oneToSixtyInWordsMap.put(29, "TwentyNine");
        oneToSixtyInWordsMap.put(30, "Thirty");
        oneToSixtyInWordsMap.put(31, "ThirtyOne");
        oneToSixtyInWordsMap.put(32, "ThirtyTwo");
        oneToSixtyInWordsMap.put(33, "ThirtyThree");
        oneToSixtyInWordsMap.put(34, "ThirtyFour");
        oneToSixtyInWordsMap.put(35, "ThirtyFive");
        oneToSixtyInWordsMap.put(36, "ThirtySix");
        oneToSixtyInWordsMap.put(37, "ThirtySeven");
        oneToSixtyInWordsMap.put(38, "ThirtyEight");
        oneToSixtyInWordsMap.put(39, "ThirtyNine");
        oneToSixtyInWordsMap.put(40, "Fourty");
        oneToSixtyInWordsMap.put(41, "FourtyOne");
        oneToSixtyInWordsMap.put(42, "FourtyTwo");
        oneToSixtyInWordsMap.put(43, "FourtyThree");
        oneToSixtyInWordsMap.put(44, "FourtyFour");
        oneToSixtyInWordsMap.put(45, "FourtyFive");
        oneToSixtyInWordsMap.put(46, "FourtySix");
        oneToSixtyInWordsMap.put(47, "FourtySeven");
        oneToSixtyInWordsMap.put(48, "FourtyEight");
        oneToSixtyInWordsMap.put(49, "FourtyNine");
        oneToSixtyInWordsMap.put(50, "Fifty");
        oneToSixtyInWordsMap.put(51, "FiftyOne");
        oneToSixtyInWordsMap.put(52, "FiftyTwo");
        oneToSixtyInWordsMap.put(53, "FiftyThree");
        oneToSixtyInWordsMap.put(54, "FiftyFour");
        oneToSixtyInWordsMap.put(55, "FiftyFive");
        oneToSixtyInWordsMap.put(56, "FiftySix");
        oneToSixtyInWordsMap.put(57, "FiftySeven");
        oneToSixtyInWordsMap.put(58, "FiftyEight");
        oneToSixtyInWordsMap.put(59, "FiftyNine");
        oneToSixtyInWordsMap.put(60, "Sixty");

        //TODO: To be extended up to 99, so that year like 2168 can be printed in word format

    }
}
