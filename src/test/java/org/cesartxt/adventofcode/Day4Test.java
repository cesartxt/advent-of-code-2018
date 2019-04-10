package org.cesartxt.adventofcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day4Test {
    @Test
    public void test0() {
        Day4.Record record1 = new Day4.Record(2019, 1, 1, 0, 0, "Guard #1 begins shift");
        Day4.Record record2 = new Day4.Record(2019, 1, 1, 0, 10, "falls asleep");
        Day4.Record record3 = new Day4.Record(2019, 1, 1, 0, 29, "wakes up");
        Day4.Record record4 = new Day4.Record(2019, 1, 1, 23, 57, "Guard #2 begins shift");
        Day4.Record record5 = new Day4.Record(2019, 1, 2, 0, 18, "falls asleep");
        Day4.Record record6 = new Day4.Record(2019, 1, 2, 0, 19, "wakes up");
        Day4.Record record7 = new Day4.Record(2019, 1, 2, 0, 21, "falls asleep");
        Day4.Record record8 = new Day4.Record(2019, 1, 2, 0, 22, "wakes up");
        Day4.Record record9 = new Day4.Record(2019, 1, 2, 23, 52, "Guard #1 begins shift");
        Day4.Record record10 = new Day4.Record(2019, 1, 3, 0, 10, "falls asleep");
        Day4.Record record11 = new Day4.Record(2019, 1, 3, 0, 13, "wakes up");

        List<Day4.Record> recordList = Arrays.asList(record4, record7, record1, record9, record11, record5, record8, record2, record10, record6, record3);
        assertEquals(10, Day4.solve(recordList));//Expected answer is 10 because Guard 1 is the sleepiest and sleeps more in minute 10 (1 * 10)
    }
}
