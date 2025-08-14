package org.example.spoken.time.util;

import org.example.spoken.time.dictionary.TimeDictionary;

import static org.example.spoken.time.util.DialectEN.hour12;
import static org.example.spoken.time.util.DialectEN.minute;


public class TimeDictionaryEN implements TimeDictionary {
    @Override
    public String buildOclock(int hour24, boolean isMidnight, boolean isNoon) {
        if (isMidnight) {
            return "midnight";
        }
        if (isNoon) {
            return "noon";
        }
        return hour12(hour24) + " o'clock";
    }

    @Override
    public String buildQuarterPast(int hour24) {
        return "quarter past " + hour12(hour24);
    }

    @Override
    public String buildQuarterTo(int hour24) {
        return "quarter to " + hour12(hour24);
    }

    @Override
    public String buildHalfPast(int hour24) {
        return "half past " + hour12(hour24);
    }

    @Override
    public String buildMinutesPast(int minutes, int hour24) {
        return minute(minutes) + " past " + hour12(hour24);
    }

    @Override
    public String buildMinutesTo(int minutes, int hour24) {
        return minute(minutes) + " to " + hour12(hour24);
    }
}
