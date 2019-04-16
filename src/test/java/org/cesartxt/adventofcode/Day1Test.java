package org.cesartxt.adventofcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Day1Test {
    @Test
    public void testPart1() {
        List<Integer> frequencyChanges = Arrays.asList(+1, +1, -2);
        int frequency = new Day1(null).solve(frequencyChanges).getPart1Answer();
        assertThat(frequency, is(0));

        frequencyChanges = Collections.singletonList(0);
        frequency = new Day1(null).solve(frequencyChanges).getPart1Answer();
        assertThat(frequency, is(0));
    }

    @Test
    public void testPart2() {
        List<Integer> frequencyChanges = Arrays.asList(+1, -1);
        int firstFrequencyToBeReachedTwice = new Day1(null).solve(frequencyChanges).getPart2Answer();
        assertThat(firstFrequencyToBeReachedTwice, is(0));

        frequencyChanges = Arrays.asList(+3, +3, +4, -2, -4);
        firstFrequencyToBeReachedTwice = new Day1(null).solve(frequencyChanges).getPart2Answer();
        assertThat(firstFrequencyToBeReachedTwice, is(10));

        frequencyChanges = Arrays.asList(-6, +3, +8, +5, -6);
        firstFrequencyToBeReachedTwice = new Day1(null).solve(frequencyChanges).getPart2Answer();
        assertThat(firstFrequencyToBeReachedTwice, is(5));

        frequencyChanges = Arrays.asList(+7, +7, -2, -7, -4);
        firstFrequencyToBeReachedTwice = new Day1(null).solve(frequencyChanges).getPart2Answer();
        assertThat(firstFrequencyToBeReachedTwice, is(14));
    }
}