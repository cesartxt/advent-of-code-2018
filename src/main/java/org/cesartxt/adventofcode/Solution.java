package org.cesartxt.adventofcode;

class Solution<T, S> {
    private final T _part1Answer;
    private final S _part2Answer;

    Solution(T part1Answer, S part2Answer) {
        _part1Answer = part1Answer;
        _part2Answer = part2Answer;
    }

    T getPart1Answer() {
        return _part1Answer;
    }

    S getPart2Answer() {
        return _part2Answer;
    }
}
