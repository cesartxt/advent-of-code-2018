package org.cesartxt.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Day1 extends Puzzle<List<Integer>, Integer, Integer> {
    private Day1() {
        super(1, "src/main/resources/day-1-puzzle-input.txt");
    }

    static Day1 init() {
        return new Day1();
    }

    @Override
    Solution<Integer, Integer> solve(List<Integer> input) {
        return new Solution<>(part1(input), part2(input));
    }

    @Override
    protected List<Integer> readInput(String s) throws FileNotFoundException {
        List<Integer> integerList = new ArrayList<>();
        File file = new File(s);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                integerList.add(scanner.nextInt());
            }
        }
        return integerList;
    }

    static int part1(List<Integer> changes) {
        int frequency = 0;
        for (int change : changes) {
            frequency += change;
        }
        return frequency;
    }

    static int part2(List<Integer> changes) {
        int frequency = 0;
        Set<Integer> seenFrequencies = new HashSet<>();
        while (true) {
            for (int change : changes) {
                seenFrequencies.add(frequency);
                frequency += change;
                if (seenFrequencies.contains(frequency)) {
                    return frequency;
                }
            }
        }
    }
}
