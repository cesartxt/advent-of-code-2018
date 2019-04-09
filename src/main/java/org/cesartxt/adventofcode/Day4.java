package org.cesartxt.adventofcode;

import java.util.Comparator;
import java.util.List;

class Day4 {
    static void sortLogEntryListByDateAsc(List<LogEntry> unsortedLogEntryList) {
        unsortedLogEntryList.sort(byDateAsc());
    }

    private static Comparator<LogEntry> byDateAsc() {
        return Comparator.comparing(LogEntry::getYear)
                .thenComparing(LogEntry::getMonth)
                .thenComparing(LogEntry::getDay)
                .thenComparing(LogEntry::getHour)
                .thenComparing(LogEntry::getMinutes);
    }

    static class LogEntry {
        int year;
        int month;
        int day;
        int hour;
        int minutes;
        String statement;

        LogEntry(int year, int month, int day, int hour, int minutes) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minutes = minutes;
        }

        int getYear() {
            return year;
        }

        int getMonth() {
            return month;
        }

        int getDay() {
            return day;
        }

        int getHour() {
            return hour;
        }

        int getMinutes() {
            return minutes;
        }

    }
}


