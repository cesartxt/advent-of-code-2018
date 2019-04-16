package org.cesartxt.adventofcode;

import java.io.FileNotFoundException;

abstract class Puzzle<T, S, U> {
    private final int _dayNumber;
    private final String _inputFilePath;

    Puzzle(int dayNumber, String inputFilePath) {
        _dayNumber = dayNumber;
        _inputFilePath = inputFilePath;
    }

    abstract T readInput(String inputFilePath) throws FileNotFoundException;

    abstract Solution solve(T input);

    void printAnswers() throws FileNotFoundException {
        System.out.println("Running Solution for Day " + _dayNumber);
        System.out.println("Reading input for puzzle of Day " + _dayNumber + ": " + _inputFilePath);
        T input = readInput(_inputFilePath);
        System.out.println("Answers Problem Day :" + _dayNumber);
        System.out.println("Day " + _dayNumber + " Part 1 answer:");
        Solution<S, U> solution = solve(input);
        System.out.println(solution.getPart1Answer());
        System.out.println("Day " + _dayNumber + " Part 2 answer:");
        System.out.println(solution.getPart2Answer());
        System.out.println("--------------------");
    }
}
