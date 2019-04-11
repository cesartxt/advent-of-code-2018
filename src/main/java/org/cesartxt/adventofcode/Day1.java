package org.cesartxt.adventofcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Day1 {
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
