package org.cesartxt.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

class Day4 extends Puzzle<List<Day4.Record>, Integer, Integer> {
    Day4(String inputFilePath) {
        super(4, inputFilePath);
    }

    @Override
    Solution<Integer, Integer> solve(List<Record> input) {
        List<Guard> guardList = buildGuardList(input);
        Guard sleepiestGuard = determineSleepiestGuard(guardList);
        int part1Answer = sleepiestGuard.getMinuteWithMoreSleep() * sleepiestGuard.id;
        Guard guardMostAsleepSameMinute = determineGuardMostAsleepSameMinute(guardList);
        int part2Answer = guardMostAsleepSameMinute.getMinuteWithMoreSleep() * guardMostAsleepSameMinute.id;
        return new Solution<>(part1Answer, part2Answer);
    }

    @Override
    protected List<Record> readInput() throws FileNotFoundException {
        List<Day4.Record> recordList = new ArrayList<>();
        File file = new File(getInputFilePath());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String recordAsString = scanner.nextLine(); //Example record: [1518-11-02 23:56] Guard #3463 begins shift
                String regex = "^\\[(\\d+)-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2})] (.+)$";
                int year = Integer.parseInt(recordAsString.replaceAll(regex, "$1"));
                int month = Integer.parseInt(recordAsString.replaceAll(regex, "$2"));
                int day = Integer.parseInt(recordAsString.replaceAll(regex, "$3"));
                int hour = Integer.parseInt(recordAsString.replaceAll(regex, "$4"));
                int minutes = Integer.parseInt(recordAsString.replaceAll(regex, "$5"));
                String statement = recordAsString.replaceAll(regex, "$6");
                recordList.add(new Day4.Record(year, month, day, hour, minutes, statement));
            }
        }
        return recordList;
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
        return Collections.max(guardList, Comparator.comparing(Guard::calculateTotalMinutesAsleep));
    }

    private static Guard determineGuardMostAsleepSameMinute(List<Guard> guardList) {
        return Collections.max(guardList, Comparator.comparing(Guard::getCountForMinuteWithMoreSleep));
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

        int calculateTotalMinutesAsleep() {
            return IntStream.of(minuteOfHourAsleepCount).sum();
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


