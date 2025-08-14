package org.example.spoken.time.util;

public class DialectEN {
    static final String[] HOURS = {
            "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"
    };

    static final String[] MINUTES = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    static String hour12(int hour24) {
        return HOURS[hour24 % 12];
    }

    static String minute(int minute) {
        return MINUTES[minute];
    }
}
