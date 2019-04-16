package org.cesartxt.adventofcode;

import java.io.FileNotFoundException;

abstract class Puzzle<T, S, U> {
    private final int _dayNumber;
    private final String _inputFilePath;

    Puzzle(int dayNumber, String inputFilePath) {
        _dayNumber = dayNumber;
        _inputFilePath = inputFilePath;
    }

    int getDayNumber() {
        return _dayNumber;
    }

    String getInputFilePath() {
        return _inputFilePath;
    }

    abstract T readInput() throws FileNotFoundException;

    Solution<S, U> solve() throws FileNotFoundException {
        return solve(readInput());
    }

    abstract Solution<S, U> solve(T input);
}
