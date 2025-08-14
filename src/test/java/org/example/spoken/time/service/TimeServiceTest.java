package org.example.spoken.time.service;

import org.example.spoken.time.dictionary.TimeDictionary;
import org.example.spoken.time.parser.TimeParser;
import org.example.spoken.time.rules.*;
import org.example.spoken.time.util.TimeDictionaryEN;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TimeServiceTest {

    private static TimeService timeService;

    @BeforeAll
    static void setUp() {
        TimeDictionary timeDictionary = new TimeDictionaryEN();
        timeService = new TimeService(new TimeParser(), List.of(new HalfPastRule(timeDictionary),
                new MinutesPastRule(timeDictionary),
                new MinutesToRule(timeDictionary),
                new OclockRule(timeDictionary),
                new QuarterPastRule(timeDictionary),
                new QuarterToRule(timeDictionary)));
    }

    @ParameterizedTest
    @MethodSource("provideTimeArguments")
    void shouldReturnExpectedValue(String inputTime, String outputTime) {
        assertEquals(outputTime, timeService.convertTimeToSpeech(inputTime));
    }

    static Stream<Arguments> provideTimeArguments() {
        return Stream.of(
                Arguments.arguments("1:00", "one o'clock"),
                Arguments.arguments("13:00", "one o'clock"),
                Arguments.arguments("2:05", "five past two"),
                Arguments.arguments("14:05", "five past two"),
                Arguments.arguments("3:10", "ten past three"),
                Arguments.arguments("4:15", "quarter past four"),
                Arguments.arguments("16:15", "quarter past four"),
                Arguments.arguments("5:20", "twenty past five"),
                Arguments.arguments("6:25", "twenty five past six"),
                Arguments.arguments("6:32", "twenty eight to seven"),
                Arguments.arguments("18:32", "twenty eight to seven"),
                Arguments.arguments("7:30", "half past seven"),
                Arguments.arguments("7:30", "half past seven"),
                Arguments.arguments("19:35", "twenty five to eight"),
                Arguments.arguments("08:40", "twenty to nine"),
                Arguments.arguments("9:45", "quarter to ten"),
                Arguments.arguments("21:45", "quarter to ten"),
                Arguments.arguments("10:50", "ten to eleven"),
                Arguments.arguments("11:55", "five to twelve"),
                Arguments.arguments("00:00", "midnight"),
                Arguments.arguments("24:00", "midnight"),
                Arguments.arguments("12:00", "noon")
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"24:01", "9x:23", "9:60", "-3:13", "", " "})
    void shouldThrownExceptionForInvalidTime(String invalidInputTime) {
        assertThrows(IllegalArgumentException.class, () -> timeService.convertTimeToSpeech(invalidInputTime));
    }

    @Test
    void shouldNotReturnExpectedValue() {
        assertNotEquals("six thirty two", timeService.convertTimeToSpeech("6:32"));
    }
}