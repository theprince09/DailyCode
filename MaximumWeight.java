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

    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    private int compareLists(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }

    private State better(State a, State b) {

        if (a == null) return b;
        if (b == null) return a;

        // Weight is stored as negative.
        // Smaller negative value = larger actual weight.
        if (a.weight != b.weight) {
            return a.weight < b.weight ? a : b;
        }

        // Same weight -> lexicographically smaller indices.
        return compareLists(a.indices, b.indices) <= 0 ? a : b;
    }

    private int findPrevious(
            Interval[] intervals,
            int hi,
            int start
    ) {

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

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] sortedIntervals = new Interval[n];

        for (int i = 0; i < n; i++) {

            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);
            int weight = intervals.get(i).get(2);

            sortedIntervals[i] =
                    new Interval(start, end, weight, i);
        }

        // Sort by end time.
        Arrays.sort(
                sortedIntervals,
                Comparator.comparingInt(a -> a.end)
        );

        /*
         * dp[i][j] =
         * best result using first i intervals
         * while selecting at most/exactly j intervals.
         *
         * null = impossible state.
         */
        State[][] dp = new State[n + 1][5];

        // Selecting 0 intervals is always possible.
        for (int i = 0; i <= n; i++) {
            dp[i][0] =
                    new State(0, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            Interval current = sortedIntervals[i];

            /*
             * Skip current interval.
             */
            for (int j = 0; j <= 4; j++) {
                dp[i + 1][j] = dp[i][j];
            }

            /*
             * Find first interval that cannot overlap
             * with current.
             *
             * We need:
             *
             * previous.end < current.start
             */
            int k = findPrevious(
                    sortedIntervals,
                    i,
                    current.start
            );

            /*
             * Take current interval.
             */
            for (int j = 1; j <= 4; j++) {

                if (dp[k][j - 1] == null) {
                    continue;
                }

                State previous = dp[k][j - 1];

                List<Integer> takeIndices =
                        new ArrayList<>(previous.indices);

                takeIndices.add(current.originalIndex);

                // Required for lexicographical comparison.
                Collections.sort(takeIndices);

                State take = new State(
                        previous.weight - current.weight,
                        takeIndices
                );

                dp[i + 1][j] =
                        better(dp[i + 1][j], take);
            }
        }

        /*
         * IMPORTANT:
         *
         * We need AT MOST 4 intervals,
         * not exactly 4.
         *
         * Therefore check all states:
         * 0, 1, 2, 3, 4.
         */
        State best = dp[n][0];

        for (int j = 1; j <= 4; j++) {
            best = better(best, dp[n][j]);
        }

        List<Integer> result = best.indices;

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
