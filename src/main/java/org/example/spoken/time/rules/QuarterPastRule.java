package org.example.spoken.time.rules;

import org.example.spoken.time.dictionary.TimeDictionary;

import java.time.LocalTime;

public class QuarterPastRule implements TimeRule {

    private final TimeDictionary timeDictionary;

    public QuarterPastRule(TimeDictionary timeDictionary) {
        this.timeDictionary = timeDictionary;
    }

    @Override
    public boolean isMatches(LocalTime time) {
        return time.getMinute() == 15;
    }

    @Override
    public String format(LocalTime time) {
        return timeDictionary.buildQuarterPast(time.getHour());
    }
}
