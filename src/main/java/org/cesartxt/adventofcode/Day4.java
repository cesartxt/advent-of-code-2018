package org.cesartxt.adventofcode;

import java.util.*;

class Day4 {
    static Solution solve(List<Record> recordList) {
        List<Guard> guardList = buildGuardList(recordList);
        Guard sleepiestGuard = determineSleepiestGuard(guardList);
        int part1Answer = sleepiestGuard.getMinuteWithMoreSleep() * sleepiestGuard.id;
        Guard guardMostAsleepSameMinute = determineGuardMostAsleepSameMinute(guardList);
        int part2Answer = guardMostAsleepSameMinute.getMinuteWithMoreSleep() * guardMostAsleepSameMinute.id;
        return new Solution(part1Answer, part2Answer);
    }

    private static List<Guard> buildGuardList(List<Record> recordList) {
        recordList.sort(byDateAsc());
        int i = 0;
        Map<Integer, Guard> idToGuardMap = new HashMap<>();
        while (i < recordList.size()) {
            int guardId = recordList.get(i++).getGuardId();
            Guard guard = idToGuardMap.computeIfAbsent(guardId, Guard::new);
            while (i < recordList.size() && !recordList.get(i).indicatesGuardIsBeggingShift()) {
                int sleepStart = recordList.get(i++).getMinutes();
                int endStart = recordList.get(i++).getMinutes();
                guard.registerSleepMinutes(sleepStart, endStart);
            }
        }
        return new ArrayList<>(idToGuardMap.values());
    }

    private static Comparator<Record> byDateAsc() {
        return Comparator.comparing(Record::getYear)
                .thenComparing(Record::getMonth)
                .thenComparing(Record::getDay)
                .thenComparing(Record::getHour)
                .thenComparing(Record::getMinutes);
    }

    private static Guard determineSleepiestGuard(List<Guard> guardList) {
        Guard sleepiestGuard = null;
        int maxMinutesAsleep = -1;
        for (Guard guard : guardList) {
            int guardTotalMinutesAsleep = guard.getTotalMinutesAsleep();
            if (guardTotalMinutesAsleep > maxMinutesAsleep) {
                maxMinutesAsleep = guardTotalMinutesAsleep;
                sleepiestGuard = guard;
            }
        }
        return sleepiestGuard;
    }

    private static Guard determineGuardMostAsleepSameMinute(List<Guard> guardList) {
        Guard guardMostFrequentlyAsleepSameMinute = null;
        int record = -1;
        for (Guard guard : guardList) {
            int guardRecordSleepSameMinute = guard.getCountForMinuteWithMoreSleep();
            if (guardRecordSleepSameMinute > record) {
                record = guardRecordSleepSameMinute;
                guardMostFrequentlyAsleepSameMinute = guard;
            }
        }
        return guardMostFrequentlyAsleepSameMinute;
    }

    static class Solution {
        final int part1Answer;
        final int part2Answer;

        Solution(int part1Answer, int part2Answer) {
            this.part1Answer = part1Answer;
            this.part2Answer = part2Answer;
        }
    }

    static class Record {
        private final int year;
        private final int month;
        private final int day;
        private final int hour;
        private final int minutes;
        private final String statement;

        Record(int year, int month, int day, int hour, int minutes, String statement) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minutes = minutes;
            this.statement = statement;
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

        private int getGuardId() {
            if (!indicatesGuardIsBeggingShift()) {
                throw new IllegalArgumentException("Record statement doesn't indicate when a guard starts his/her shift");
            }
            String[] statementTokens = statement.split("\\s");
            String guardIdAsString = statementTokens[1].substring(1); // Guard id is the second token of the statement. Removing first character from it that is a '#'
            return Integer.parseInt(guardIdAsString);
        }

        private boolean indicatesGuardIsBeggingShift() {
            return statement.endsWith(" begins shift");
        }
    }

    static class Guard {
        private final int id;
        private final int[] minuteOfHourAsleepCount = new int[60];

        Guard(int id) {
            this.id = id;
        }

        int getTotalMinutesAsleep() {
            int totalMinutesAsleep = 0;
            for (int minutes : minuteOfHourAsleepCount) {
                totalMinutesAsleep += minutes;
            }
            return totalMinutesAsleep;
        }

        int getMinuteWithMoreSleep() {
            int minuteWithMoreSleep = -1;
            int sleepRecord = -1;
            for (int i = 0; i < 60; i++) {
                if (sleepRecord < minuteOfHourAsleepCount[i]) {
                    minuteWithMoreSleep = i;
                    sleepRecord = minuteOfHourAsleepCount[i];
                }
            }
            return minuteWithMoreSleep;
        }

        int getCountForMinuteWithMoreSleep() {
            return minuteOfHourAsleepCount[getMinuteWithMoreSleep()];
        }

        void registerSleepMinutes(int sleepStart, int sleepEnd) {
            for (int i = sleepStart; i < sleepEnd; i++) {
                minuteOfHourAsleepCount[i]++;
            }
        }
    }
}


