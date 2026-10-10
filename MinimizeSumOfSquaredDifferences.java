/*
 * Day 47 - LeetCode
 *
 * Problem: Minimize Sum of Squared Differences
 *
 * Given two integer arrays nums1 and nums2, along with k1 and k2
 * operations, minimize the sum of squared differences between
 * corresponding elements.
 *
 * In one operation, increase or decrease an element in either
 * array by 1.
 *
 * Approach:
 * 1. Calculate the absolute difference at each index.
 * 2. Store the frequency of each difference in a frequency array.
 * 3. Use k1 + k2 as the total number of available operations.
 * 4. Process differences from largest to smallest.
 * 5. Reduce the largest differences first:
 *      - If all differences at the current level can be reduced,
 *        move them to the next lower level.
 *      - Otherwise, reduce only as many as the remaining operations
 *        allow, then stop.
 * 6. Calculate the sum of squared differences using the final
 *    frequency array.
 *
 * Time Complexity: O(n + M)
 * Space Complexity: O(M)
 *
 * M = maximum possible difference (100000).
 *
 * Date Solved: 10 October 2026
 */

class Solution {

    public long minSumSquareDiff(
            int[] nums1,
            int[] nums2,
            int k1,
            int k2) {

        int maxDifference = 100_000;

        int[] difference = new int[maxDifference + 1];

        // Count the frequency of every absolute difference.
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            difference[diff]++;
        }

        int operations = k1 + k2;

        // Reduce the largest differences first.
        for (int i = maxDifference; i >= 1; i--) {

            int count = difference[i];

            if (count == 0) {
                continue;
            }

            // All differences at this level can be reduced.
            if (count <= operations) {

                difference[i - 1] += count;
                difference[i] = 0;

                operations -= count;

            } else {

                // Reduce only as many as the remaining operations allow.
                difference[i] -= operations;
                difference[i - 1] += operations;

                operations = 0;
                break;
            }
        }

        // Calculate the sum of squared differences.
        long answer = 0;

        for (int i = 1; i <= maxDifference; i++) {
            answer += (long) difference[i] * i * i;
        }

        return answer;
    }
}
