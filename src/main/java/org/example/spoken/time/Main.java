package org.example.spoken.time;

import org.example.spoken.time.dictionary.TimeDictionary;
import org.example.spoken.time.parser.TimeParser;
import org.example.spoken.time.rules.*;
import org.example.spoken.time.service.TimeService;
import org.example.spoken.time.util.TimeDictionaryEN;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Use: gradle run --args=<H:mm>");
            System.exit(1);
        }
        TimeDictionary timeDictionary = new TimeDictionaryEN();
        TimeService timeService = new TimeService(new TimeParser(), List.of(new HalfPastRule(timeDictionary),
                new MinutesPastRule(timeDictionary),
                new MinutesToRule(timeDictionary),
                new OclockRule(timeDictionary),
                new QuarterPastRule(timeDictionary),
                new QuarterToRule(timeDictionary)));

        String inputTime = args[0];
        try {
            System.err.println(timeService.convertTimeToSpeech(inputTime));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
