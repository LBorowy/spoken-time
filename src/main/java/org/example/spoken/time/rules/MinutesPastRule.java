package org.example.spoken.time.rules;

import org.example.spoken.time.dictionary.TimeDictionary;

import java.time.LocalTime;

public class MinutesPastRule implements TimeRule {

    private final TimeDictionary timeDictionary;

    public MinutesPastRule(TimeDictionary timeDictionary) {
        this.timeDictionary = timeDictionary;
    }

    @Override
    public boolean isMatches(LocalTime time) {
        int minutes = time.getMinute();
        return minutes > 0 && minutes < 30 && minutes != 15;
    }

    @Override
    public String format(LocalTime time) {
        return timeDictionary.buildMinutesPast(time.getMinute(), time.getHour());
    }
}
