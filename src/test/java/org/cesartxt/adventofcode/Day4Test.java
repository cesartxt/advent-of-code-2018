package org.cesartxt.adventofcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day4Test {
    @Test
    public void testSortLogEntryListByDateAsc() {
        String reason = "Method Day4#sortLogEntryListByDateAsc should sort the LogEntry instances contained in the " +
                "given list by date in ascending order";

        Day4.LogEntry entry1 = new Day4.LogEntry(2019, 1, 2, 12, 20);
        Day4.LogEntry entry2 = new Day4.LogEntry(2018, 12, 20, 1, 34);
        Day4.LogEntry entry3 = new Day4.LogEntry(2019, 3, 3, 2, 12);
        Day4.LogEntry entry4 = new Day4.LogEntry(2018, 12, 20, 1, 33);
        Day4.LogEntry entry5 = new Day4.LogEntry(2019, 2, 28, 13, 24);

        List<Day4.LogEntry> logEntryList = new ArrayList<>();
        logEntryList.add(entry1);
        logEntryList.add(entry2);
        logEntryList.add(entry3);
        logEntryList.add(entry4);
        logEntryList.add(entry5);

        Day4.sortLogEntryListByDateAsc(logEntryList);

        assertEquals(reason, entry4, logEntryList.get(0));
        assertEquals(reason, entry2, logEntryList.get(1));
        assertEquals(reason, entry1, logEntryList.get(2));
        assertEquals(reason, entry5, logEntryList.get(3));
        assertEquals(reason, entry3, logEntryList.get(4));
    }

}
