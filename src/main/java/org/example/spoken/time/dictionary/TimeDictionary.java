package org.example.spoken.time.dictionary;

public interface TimeDictionary {
    String buildOclock(int hour24, boolean isMidnight, boolean isNoon);
    String buildQuarterPast(int hour24);
    String buildQuarterTo(int hour24);
    String buildHalfPast(int hour24);
    String buildMinutesPast(int minutes, int hour24);
    String buildMinutesTo(int minutes, int hour24);
}
