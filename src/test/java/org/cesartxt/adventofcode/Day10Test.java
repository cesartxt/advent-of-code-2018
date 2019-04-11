package org.cesartxt.adventofcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day10Test {

    @Test
    public void test0() {
        Day10.PointSet pointSet = new Day10.PointSet();
        pointSet.add(new Day10.Point(9, 1, 0, 2));
        pointSet.add(new Day10.Point(7, 0, -1, 0));
        pointSet.add(new Day10.Point(3, -2, -1, 1));
        pointSet.add(new Day10.Point(6, 10, -2, -1));
        pointSet.add(new Day10.Point(2, -4, 2, 2));
        pointSet.add(new Day10.Point(-6, 10, 2, -2));
        pointSet.add(new Day10.Point(1, 8, 1, -1));
        pointSet.add(new Day10.Point(1, 7, 1, 0));
        pointSet.add(new Day10.Point(-3, 11, 1, -2));
        pointSet.add(new Day10.Point(7, 6, -1, -1));
        pointSet.add(new Day10.Point(-2, 3, 1, 0));
        pointSet.add(new Day10.Point(-4, 3, 2, 0));
        pointSet.add(new Day10.Point(10, -3, -1, 1));
        pointSet.add(new Day10.Point(5, 11, 1, -2));
        pointSet.add(new Day10.Point(4, 7, 0, -1));
        pointSet.add(new Day10.Point(8, -2, 0, 1));
        pointSet.add(new Day10.Point(15, 0, -2, 0));
        pointSet.add(new Day10.Point(1, 6, 1, 0));
        pointSet.add(new Day10.Point(8, 9, 0, -1));
        pointSet.add(new Day10.Point(3, 3, -1, 1));
        pointSet.add(new Day10.Point(0, 5, 0, -1));
        pointSet.add(new Day10.Point(-2, 2, 2, 0));
        pointSet.add(new Day10.Point(5, -2, 1, 2));
        pointSet.add(new Day10.Point(1, 4, 2, 1));
        pointSet.add(new Day10.Point(-2, 7, 2, -2));
        pointSet.add(new Day10.Point(3, 6, -1, -1));
        pointSet.add(new Day10.Point(5, 0, 1, 0));
        pointSet.add(new Day10.Point(-6, 0, 2, 0));
        pointSet.add(new Day10.Point(5, 9, 1, -2));
        pointSet.add(new Day10.Point(14, 7, -2, 0));
        pointSet.add(new Day10.Point(-3, 6, 2, -1));

        assertEquals("*", Day10.solve(pointSet));
    }
}
