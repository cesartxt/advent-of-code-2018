package org.cesartxt.adventofcode;

import java.io.FileNotFoundException;

/**
 * Run some solved puzzles for the Advent of Code 2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        printAnswers(new Day1("src/main/resources/day-1-puzzle-input.txt"));
        printAnswers(new Day4("src/main/resources/day-4-puzzle-input.txt"));
        printAnswers(new Day10("src/main/resources/day-10-puzzle-input.txt"));
    }

    static <T, S, U> void printAnswers(Puzzle<T, S, U> puzzle) throws FileNotFoundException {
        int dayNumber = puzzle.getDayNumber();
        String _inputFilePath = puzzle.getInputFilePath();
        System.out.println("Running Solution for Day " + dayNumber);
        System.out.println("Reading input for puzzle of Day " + dayNumber + ": " + _inputFilePath);
        System.out.println("Answers Problem Day :" + dayNumber);
        System.out.println("Day " + dayNumber + " Part 1 answer:");
        Solution<S, U> solution = puzzle.solve();
        System.out.println(solution.getPart1Answer());
        System.out.println("Day " + dayNumber + " Part 2 answer:");
        System.out.println(solution.getPart2Answer());
        System.out.println("--------------------");
    }
}
