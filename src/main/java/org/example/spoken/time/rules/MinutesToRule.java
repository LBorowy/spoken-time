package org.example.spoken.time.rules;

import org.example.spoken.time.dictionary.TimeDictionary;

import java.time.LocalTime;

public class MinutesToRule implements TimeRule {

    private final TimeDictionary timeDictionary;

    public MinutesToRule(TimeDictionary timeDictionary) {
        this.timeDictionary = timeDictionary;
    }

    @Override
    public boolean isMatches(LocalTime time) {
        int minutes = time.getMinute();
        return minutes > 30 && minutes != 45;
    }

    @Override
    public String format(LocalTime time) {
        int minutesTo = 60 - time.getMinute();
        int nextHour = (time.getHour() + 1) % 24;
        return timeDictionary.buildMinutesTo(minutesTo, nextHour);
    }
}
