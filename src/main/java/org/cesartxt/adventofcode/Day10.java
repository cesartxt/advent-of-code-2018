package org.cesartxt.adventofcode;

import java.util.*;

class Day10 {
    static Solution solve(PointSet pointSet) {
        int currentMinute = 0;
        while (pointSet.getMessage() == null) {
            pointSet.movePoints();
            currentMinute++;
        }
        return new Solution(pointSet.getMessage(), currentMinute);
    }

    static class Solution {
        final String part1Answer;
        final int part2Answer;

        Solution(String part1Answer, int part2Answer) {
            this.part1Answer = part1Answer;
            this.part2Answer = part2Answer;
        }
    }

    static class PointSet {
        private final List<Point> pointList = new ArrayList<>();
        private final Set<IntegerPair> positionSet = new HashSet<>();

        void add(Point point) {
            pointList.add(point);
        }

        void movePoints() {
            positionSet.clear();
            for (Point point : pointList) {
                point.move();
                positionSet.add(point.position);
            }
        }

        String getMessage() {
            if (allPointsHaveNeighbors()) {
                StringBuilder builder = new StringBuilder();
                int leftestXPosition = findLeftestXPosition();
                int rightestXPosition = findRightestXPosition();
                int upperYPosition = findUpperYPosition();
                int lowerYPosition = findLowerYPosition();
                for (int j = upperYPosition; j <= lowerYPosition; j++) {
                    for (int i = leftestXPosition; i <= rightestXPosition; i++) {
                        if (containsPointInPosition(i, j)) {
                            builder.append('#');
                        } else {
                            builder.append(' ');
                        }
                    }
                    builder.append('\n');
                }
                return builder.toString();
            }
            return null;
        }

        private boolean allPointsHaveNeighbors() {
            for (Point point : pointList) {
                if (!hasNeighbors(point)) {
                    return false;
                }
            }
            return true;
        }

        boolean hasNeighbors(Point point) {
            IntegerPair position = point.position;
            return containsPointInPosition(position.x, position.y - 1) ||
                    containsPointInPosition(position.x, position.y + 1) ||
                    containsPointInPosition(position.x - 1, position.y - 1) ||
                    containsPointInPosition(position.x - 1, position.y) ||
                    containsPointInPosition(position.x - 1, position.y + 1) ||
                    containsPointInPosition(position.x + 1, position.y - 1) ||
                    containsPointInPosition(position.x + 1, position.y) ||
                    containsPointInPosition(position.x + 1, position.y + 1);
        }

        boolean containsPointInPosition(int x, int y) {
            return positionSet.contains(new IntegerPair(x, y));
        }

        private int findUpperYPosition() {
            return positionSet.stream()
                    .mapToInt(p -> p.y)
                    .min()
                    .orElseThrow(() -> new IllegalArgumentException("PointSet is empty"));
        }

        private int findLowerYPosition() {
            return positionSet.stream()
                    .mapToInt(p -> p.y)
                    .max()
                    .orElseThrow(() -> new IllegalArgumentException("PointSet is empty"));
        }

        private int findLeftestXPosition() {
            return positionSet.stream()
                    .mapToInt(p -> p.x)
                    .min()
                    .orElseThrow(() -> new IllegalArgumentException("PointSet is empty"));
        }

        private int findRightestXPosition() {
            return positionSet.stream()
                    .mapToInt(p -> p.x)
                    .max()
                    .orElseThrow(() -> new IllegalArgumentException("PointSet is empty"));
        }
    }

    static class Point {
        private final IntegerPair position;
        private final IntegerPair velocity;

        Point(int xPosition, int yPosition, int xVelocity, int yVelocity) {
            this.position = new IntegerPair(xPosition, yPosition);
            this.velocity = new IntegerPair(xVelocity, yVelocity);
        }

        private void move() {
            position.move(velocity.x, velocity.y);
        }
    }

    static class IntegerPair {
        private int x;
        private int y;

        IntegerPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private void move(int x, int y) {
            this.x += x;
            this.y += y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            IntegerPair that = (IntegerPair) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
