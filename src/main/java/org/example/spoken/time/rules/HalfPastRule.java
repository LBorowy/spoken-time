package org.example.spoken.time.rules;

import org.example.spoken.time.dictionary.TimeDictionary;

import java.time.LocalTime;

public class HalfPastRule implements TimeRule {

    private final TimeDictionary timeDictionary;

    public HalfPastRule(TimeDictionary timeDictionary) {
        this.timeDictionary = timeDictionary;
    }

    @Override
    public boolean isMatches(LocalTime time) {
        return time.getMinute() == 30;
    }

    @Override
    public String format(LocalTime time) {
        return timeDictionary.buildHalfPast(time.getHour());
    }
}
