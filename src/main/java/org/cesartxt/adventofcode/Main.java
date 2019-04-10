package org.cesartxt.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Run some solved puzzles for the Advent of Code 2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IllegalAccessException {
        runSolutionDay1();
    }

    private static void runSolutionDay1() throws FileNotFoundException, IllegalAccessException {
        /* Day1 Puzzle */
        System.out.println("Running Solution for Day 1");
        System.out.println("Reading input for puzzle of Day 1: src/main/resources/day-1-puzzle-input.txt");
        List<Integer> input = readIntegersFromFile("src/main/resources/day-1-puzzle-input.txt");
        int answer = Day1.calculateFrequency(input);
        System.out.println("Answer Problem Day 1:");
        System.out.println(answer);
        System.out.println("--------------------");

        System.out.println("Running Solution for Day 4");
        System.out.println("Reading input for puzzle of Day 4: src/main/resources/day-4-puzzle-input.txt");
        List<Day4.Record> input2 = readRecordsFromFile("src/main/resources/day-4-puzzle-input.txt");
        int answer2 = Day4.solve(input2);
        System.out.println("Answer Problem Day 4:");
        System.out.println(answer2);
        System.out.println("--------------------");
    }

    private static List<Integer> readIntegersFromFile(String pathName) throws FileNotFoundException {
        List<Integer> integerList = new ArrayList<>();
        File file = new File(pathName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                integerList.add(scanner.nextInt());
            }
        }
        return integerList;
    }

    private static List<Day4.Record> readRecordsFromFile(String pathName) throws FileNotFoundException {
        List<Day4.Record> recordList = new ArrayList<>();
        File file = new File(pathName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String recordAsString = scanner.nextLine();
                int year = Integer.parseInt(recordAsString.substring(1, 5));
                int month = Integer.parseInt(recordAsString.substring(6, 8));
                int day = Integer.parseInt(recordAsString.substring(9, 11));
                int hour = Integer.parseInt(recordAsString.substring(12, 14));
                int minutes = Integer.parseInt(recordAsString.substring(15, 17));
                String statement = recordAsString.substring(19);
                recordList.add(new Day4.Record(year, month, day, hour, minutes, statement));
            }
        }
        return recordList;
    }
}
