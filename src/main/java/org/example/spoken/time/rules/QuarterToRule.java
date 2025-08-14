package org.example.spoken.time.rules;

import org.example.spoken.time.dictionary.TimeDictionary;

import java.time.LocalTime;

public class QuarterToRule implements TimeRule {

    private final TimeDictionary timeDictionary;

    public QuarterToRule(TimeDictionary timeDictionary) {
        this.timeDictionary = timeDictionary;
    }

    @Override
    public boolean isMatches(LocalTime time) {
        return time.getMinute() == 45;
    }

    @Override
    public String format(LocalTime time) {
        int nextHour = (time.getHour() + 1) % 24;
        return timeDictionary.buildQuarterTo(nextHour);
    }
}
