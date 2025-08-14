package org.example.spoken.time.parser;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeParser {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    public LocalTime parseTime(String time) {
        if (time == null) {
            throw new IllegalArgumentException("Time is required");
        }
        String trimmedTime = time.trim();
        try {
            return LocalTime.parse(trimmedTime, TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time: '" + time + "'. Expected format: H:mm (e.g., 4:15 or 16:15).", e);
        }
    }
}
