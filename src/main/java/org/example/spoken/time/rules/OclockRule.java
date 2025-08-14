package org.example.spoken.time.rules;

import org.example.spoken.time.dictionary.TimeDictionary;

import java.time.LocalTime;

public class OclockRule implements TimeRule {

    private final TimeDictionary timeDictionary;

    public OclockRule(TimeDictionary timeDictionary) {
        this.timeDictionary = timeDictionary;
    }

    @Override
    public boolean isMatches(LocalTime time) {
        return time.getMinute() == 0;
    }

    @Override
    public String format(LocalTime time) {
        int hour = time.getHour();
        boolean isMidnight = hour == 0;
        boolean isNoon = hour == 12;
        return timeDictionary.buildOclock(hour, isMidnight, isNoon);
    }
}
