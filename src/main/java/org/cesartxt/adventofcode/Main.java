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
    }

    private static void runSolutionDay1() throws FileNotFoundException {
        System.out.println("Running Solution for Day 1");
        System.out.println("Reading input for puzzle of Day 1: src/main/resources/day-1-puzzle-input.txt");
        List<Integer> input = processInputFile("src/main/resources/day-1-puzzle-input.txt");
        int answer = Day1.calculateFrequency(input);
        System.out.println("Answer Problem Day 1:");
        System.out.println(answer);
    }

    private static List<Integer> processInputFile(String pathName) throws FileNotFoundException {
        List<Integer> result = new ArrayList<>();
        File file = new File(pathName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                result.add(scanner.nextInt());
            }
        }
        return result;
    }
}
