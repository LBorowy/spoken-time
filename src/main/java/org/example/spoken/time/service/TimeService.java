package org.example.spoken.time.service;

import org.example.spoken.time.parser.TimeParser;
import org.example.spoken.time.rules.TimeRule;

import java.time.LocalTime;
import java.util.List;

public class TimeService {
    private final TimeParser timeParser;
    private final List<TimeRule> ruleList;

    public TimeService(TimeParser timeParser, List<TimeRule> ruleList) {
        this.timeParser = timeParser;
        this.ruleList = ruleList;
    }

    public String convertTimeToSpeech(String inputTime) {
        LocalTime time = timeParser.parseTime(inputTime);
        return ruleList.stream()
                .filter(rule -> rule.isMatches(time))
                .findFirst()
                .map(rule -> rule.format(time))
                .orElseThrow(() -> new IllegalArgumentException("No matching rule for time: " + time));
    }
}
