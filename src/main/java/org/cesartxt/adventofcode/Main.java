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
    public static void main(String[] args) throws FileNotFoundException {
        runSolutionDay1();
        runSolutionDay4();
        runSolutionDay10();
    }

    private static void runSolutionDay1() throws FileNotFoundException {
        System.out.println("Running Solution for Day 1");
        System.out.println("Reading input for puzzle of Day 1: src/main/resources/day-1-puzzle-input.txt");
        List<Integer> input = readIntegersFromFile("src/main/resources/day-1-puzzle-input.txt");
        System.out.println("Answers Problem Day 1:");
        System.out.println("Part 1:");
        int part1Answer = Day1.part1(input);
        System.out.println(part1Answer);
        System.out.println("Part 2:");
        int part2Answer = Day1.part2(input);
        System.out.println(part2Answer);
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

    private static void runSolutionDay4() throws FileNotFoundException {
        System.out.println("Running Solution for Day 4");
        System.out.println("Reading input for puzzle of Day 4: src/main/resources/day-4-puzzle-input.txt");
        List<Day4.Record> input = readRecordsFromFile("src/main/resources/day-4-puzzle-input.txt");
        Day4.Solution answer = Day4.solve(input);
        System.out.println("Answer Problem Day 4:");
        System.out.println("Part 1:");
        int part1Answer = answer.part1Answer;
        System.out.println(part1Answer);
        System.out.println("Part 2:");
        int part2Answer = answer.part2Answer;
        System.out.println(part2Answer);
        System.out.println("--------------------");
    }

    private static List<Day4.Record> readRecordsFromFile(String pathName) throws FileNotFoundException {
        List<Day4.Record> recordList = new ArrayList<>();
        File file = new File(pathName);
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

    private static void runSolutionDay10() throws FileNotFoundException {
        System.out.println("Running Solution for Day 10");
        System.out.println("Reading input for puzzle of Day 4: src/main/resources/day-10-puzzle-input.txt");
        Day10.PointSet input = readPointsFromFile("src/main/resources/day-10-puzzle-input.txt");
        String answer = Day10.solve(input);
        System.out.println("Answer Problem Day 10:");
        System.out.println(answer);
        System.out.println("--------------------");
    }

    private static Day10.PointSet readPointsFromFile(String pathName) throws FileNotFoundException {
        Day10.PointSet pointSet = new Day10.PointSet();
        File file = new File(pathName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                pointSet.add(createPoint(line));
            }
        }
        return pointSet;
    }

    private static Day10.Point createPoint(String line) {
        String regex = "^position=<\\s*(-?\\d+),\\s*(-?\\d+)>\\s*velocity=<\\s*(-?\\d+),\\s*(-?\\d+)>$";
        int xPosition = Integer.parseInt(line.replaceAll(regex, "$1"));
        int yPosition = Integer.parseInt(line.replaceAll(regex, "$2"));
        int xVelocity = Integer.parseInt(line.replaceAll(regex, "$3"));
        int yVelocity = Integer.parseInt(line.replaceAll(regex, "$4"));
        return new Day10.Point(xPosition, yPosition, xVelocity, yVelocity);
    }
}
