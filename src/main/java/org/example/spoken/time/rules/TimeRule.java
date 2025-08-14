package org.example.spoken.time.rules;

import java.time.LocalTime;

public interface TimeRule {
    boolean isMatches(LocalTime time);
    String format(LocalTime time);
}
