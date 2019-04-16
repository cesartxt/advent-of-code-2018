package org.cesartxt.adventofcode;

import java.io.FileNotFoundException;

/**
 * Run some solved puzzles for the Advent of Code 2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Day1.init().printAnswers();
        Day4.init().printAnswers();
        Day10.init().printAnswers();
    }
}
