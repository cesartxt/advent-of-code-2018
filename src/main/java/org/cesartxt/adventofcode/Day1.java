package org.cesartxt.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Day1 extends Puzzle<List<Integer>, Integer, Integer> {
    Day1(String filePath) {
        super(1, filePath);
    }

    @Override
    protected List<Integer> readInput() throws FileNotFoundException {
        List<Integer> integerList = new ArrayList<>();
        File file = new File(getInputFilePath());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                integerList.add(scanner.nextInt());
            }
        }
        return integerList;
    }

    @Override
    Solution<Integer, Integer> solve(List<Integer> input) {
        int currentFrequency = 0;
        Integer frequencyAfterFirstLoop = null;
        /*
         * There could be cases when there is no frequency seen twice (example, if the input is [+1]). Here, it is
         * assumed that this code is not going to receive that kind of input
         */
        Integer firstFrequencySeenTwice = null;
        Set<Integer> seenFrequencies = new HashSet<>();
        while (frequencyAfterFirstLoop == null || firstFrequencySeenTwice == null) {
            for (int change : input) {
                seenFrequencies.add(currentFrequency);
                currentFrequency += change;
                if (seenFrequencies.contains(currentFrequency) && firstFrequencySeenTwice == null) {
                    firstFrequencySeenTwice = currentFrequency;
                }
            }
            if (frequencyAfterFirstLoop == null) {
                frequencyAfterFirstLoop = currentFrequency;
            }
        }
        return new Solution<>(frequencyAfterFirstLoop, firstFrequencySeenTwice);
    }
}
