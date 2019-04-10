package org.cesartxt.adventofcode;

import java.util.*;

class Day4 {
    static int solve(List<Record> recordList) throws IllegalAccessException {
        recordList.sort(byDateAsc());
        List<Guard> guardList = processSortedRecords(recordList);
        Guard guardWithMostAsleepMinutes = getGuardWithMostAsleepMinutes(guardList).orElseThrow(() -> new IllegalArgumentException("There was not information of any Guard"));
        return guardWithMostAsleepMinutes.determineMinuteMostLikelyToBeAsleep() * guardWithMostAsleepMinutes.id;
    }

    private static Comparator<Record> byDateAsc() {
        return Comparator.comparing(Record::getYear)
                .thenComparing(Record::getMonth)
                .thenComparing(Record::getDay)
                .thenComparing(Record::getHour)
                .thenComparing(Record::getMinutes);
    }

    private static List<Guard> processSortedRecords(List<Record> recordList) throws IllegalAccessException {
        Map<Integer, Guard> guardIdToGuardMap = new HashMap<>();
        int i = 0;
        while (i < recordList.size()) {
            String beginShiftStatement = recordList.get(i++).statement;
            int guardId = getGuardIdFromBeginShiftStatement(beginShiftStatement);
            Guard guard = guardIdToGuardMap.computeIfAbsent(guardId, Guard::new);
            while (i < recordList.size() && !recordList.get(i).statement.startsWith("Guard #")) {
                int asleepMinute = recordList.get(i++).getMinutes();
                int wakeUpMinute = recordList.get(i++).getMinutes();
                guard.registerSleepMinutes(asleepMinute, wakeUpMinute);
            }
        }
        return new ArrayList<>(guardIdToGuardMap.values());
    }

    private static int getGuardIdFromBeginShiftStatement(String statement) throws IllegalAccessException {
        if (!statement.endsWith(" begins shift")) {
            throw new IllegalAccessException("Given statement doesn't indicate when a guard starts his/her shift");
        }
        String[] statementTokens = statement.split("\\s");
        String guardIdAsString = statementTokens[1].substring(1); // Guard id is the second token of the statement. Removing first character from it that is a '#'
        return Integer.parseInt(guardIdAsString);
    }

    private static Optional<Guard> getGuardWithMostAsleepMinutes(List<Guard> guardList) {
        Guard mostMinutesAsleepGuard = null;
        int mostMinutesAsleep = -1;
        for (Guard guard : guardList) {
            int guardTotalMinutesAsleep = guard.getTotalMinutesAsleep();
            if (guardTotalMinutesAsleep > mostMinutesAsleep) {
                mostMinutesAsleep = guardTotalMinutesAsleep;
                mostMinutesAsleepGuard = guard;
            }
        }
        return mostMinutesAsleepGuard == null ? Optional.empty() : Optional.of(mostMinutesAsleepGuard);
    }

    static class Record {
        int year;
        int month;
        int day;
        int hour;
        int minutes;
        String statement;

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

        int determineMinuteMostLikelyToBeAsleep() {
            int minuteMostLikelyToBeAsleep = -1;
            int max = -1;
            for (int i = 0; i < 60; i++) {
                if (max < minuteOfHourAsleepCount[i]) {
                    minuteMostLikelyToBeAsleep = i;
                    max = minuteOfHourAsleepCount[i];
                }
            }
            return minuteMostLikelyToBeAsleep;
        }

        void registerSleepMinutes(int asleepMinute, int wakeUpMinute) {
            for (int i = asleepMinute; i < wakeUpMinute; i++) {
                minuteOfHourAsleepCount[i]++;
            }
        }
    }
}


