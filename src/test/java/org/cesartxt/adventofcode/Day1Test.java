package org.cesartxt.adventofcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Day1Test {
    @Test
    public void test0() {
        List<Integer> frequencyChanges = Arrays.asList(+1, +1, +1);
        int frequency = Day1.calculateFrequency(frequencyChanges);
        assertThat(frequency, is(3));
    }

    @Test
    public void test1() {
        List<Integer> frequencyChanges = Arrays.asList(+1, +1, -2);
        int frequency = Day1.calculateFrequency(frequencyChanges);
        assertThat(frequency, is(0));
    }

    @Test
    public void test2() {
        List<Integer> frequencyChanges = Arrays.asList(-1, -2, -3);
        int frequency = Day1.calculateFrequency(frequencyChanges);
        assertThat(frequency, is(-6));
    }

    @Test
    public void test3() {
        List<Integer> frequencyChanges = Collections.emptyList();
        int frequency = Day1.calculateFrequency(frequencyChanges);
        assertThat(frequency, is(0));
    }

    @Test
    public void test4() {
        List<Integer> frequencyChanges = Arrays.asList(-7, -19, +18, +19, -10, -12, -19);
        int frequency = Day1.calculateFrequency(frequencyChanges);
        assertThat(frequency, is(-30));
    }

    @Test
    public void test5() {
        List<Integer> frequencyChanges = Collections.singletonList(0);
        int frequency = Day1.calculateFrequency(frequencyChanges);
        assertThat(frequency, is(0));
    }
}