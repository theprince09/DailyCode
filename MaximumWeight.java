/*
 * Day 19 - LeetCode
 *
 * Problem: Maximum Weight
 *
 * Given a list of intervals where each interval contains:
 *
 *     [start, end, weight]
 *
 * Select exactly 4 non-overlapping intervals such that their total
 * weight is maximum.
 *
 * If multiple selections have the same maximum weight, return the
 * lexicographically smallest list of their original indices.
 *
 * Approach:
 * 1. Store each interval as:
 *    [end, start, weight, originalIndex]
 *
 * 2. Sort all intervals by their end position.
 *
 * 3. For every interval, use binary search to find the latest interval
 *    that ends before the current interval starts.
 *
 * 4. Use Dynamic Programming:
 *
 *    dp[i][j] = best result using the first i sorted intervals
 *               while selecting exactly j intervals.
 *
 * 5. At every interval, we have two choices:
 *
 *    - Skip the current interval.
 *    - Take the current interval and combine it with the best solution
 *      from the previous non-overlapping interval.
 *
 * 6. We store weight as negative internally so that the normal
 *    lexicographical comparison can be used to prefer the maximum weight.
 *
 * 7. If weights are equal, choose the lexicographically smaller list
 *    of original indices.
 *
 * Time Complexity: O(n log n + 4 * n * log n)
 *                  = O(n log n)
 *
 * Space Complexity: O(n)
 *
 * Date Solved: 12 September 2026
 */

import java.util.*;

class Solution {

    // Represents an interval
    static class Interval {
        int start;
        int end;
        int weight;
        int originalIndex;

        Interval(int start, int end, int weight, int originalIndex) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.originalIndex = originalIndex;
        }
    }

    // Represents a DP state
    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    /*
     * Compare two states.
     *
     * Smaller internal weight means larger actual weight because
     * we store weight as negative.
     *
     * If weights are equal, choose lexicographically smaller indices.
     */
    private State better(State a, State b) {

        if (a.weight != b.weight) {
            return a.weight < b.weight ? a : b;
        }

        return compareLists(a.indices, b.indices) <= 0 ? a : b;
    }

    // Lexicographically compare two lists
    private int compareLists(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }

    /*
     * Find the number of intervals among [0, hi) whose end is
     * strictly smaller than start.
     *
     * This is equivalent to Python's:
     *
     *     bisect_left(sortedIntervals, (start,), hi=i)
     */
    private int findPrevious(Interval[] intervals, int hi, int start) {

        int left = 0;
        int right = hi;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (intervals[mid].end < start) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public List<Integer> maximumWeight(int[][] intervals) {

        int n = intervals.length;

        Interval[] sortedIntervals = new Interval[n];

        // Create interval objects
        for (int i = 0; i < n; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];
            int weight = intervals[i][2];

            sortedIntervals[i] =
                    new Interval(start, end, weight, i);
        }

        // Sort by end position
        Arrays.sort(
                sortedIntervals,
                Comparator.comparingInt(a -> a.end)
        );

        /*
         * dp[i][j]:
         * Best state using the first i intervals
         * and selecting exactly j intervals.
         */
        State[][] dp = new State[n + 1][5];

        // Initialize DP
        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= 4; j++) {

                dp[i][j] =
                        new State(0, new ArrayList<>());
            }
        }

        for (int i = 0; i < n; i++) {

            Interval current = sortedIntervals[i];

            /*
             * Find the first interval whose end >= current.start.
             * Therefore, all intervals before k are non-overlapping
             * with the current interval.
             */
            int k = findPrevious(
                    sortedIntervals,
                    i,
                    current.start
            );

            for (int j = 1; j <= 4; j++) {

                // Option 1: Skip current interval
                State skip = dp[i][j];

                // Option 2: Take current interval
                State previous = dp[k][j - 1];

                List<Integer> takeIndices =
                        new ArrayList<>(previous.indices);

                takeIndices.add(current.originalIndex);

                // Sort original indices for lexicographical comparison
                Collections.sort(takeIndices);

                State take = new State(
                        previous.weight - current.weight,
                        takeIndices
                );

                // Choose the better option
                dp[i + 1][j] = better(skip, take);
            }
        }

        return dp[n][4].indices;
    }
}
