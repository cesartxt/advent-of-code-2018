package org.cesartxt.adventofcode;

import java.util.List;

class Day1 {
    static int calculateFrequency(List<Integer> changes) {
        int frequency = 0;
        for (int change : changes) {
            frequency += change;
        }
        return frequency;
    }
}
