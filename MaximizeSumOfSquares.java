/*
 * Day 49 - LeetCode
 *
 * Problem: Maximize the Sum of Squares of K Numbers
 *
 * Given an integer list nums and an integer k, construct k numbers
 * using the available set bits from nums to maximize the sum of
 * their squares.
 *
 * Return the maximum sum modulo 1_000_000_007.
 *
 * Approach:
 * 1. Count how many numbers have each bit set.
 * 2. Construct k numbers one by one.
 * 3. For each number, include every bit position that still has
 *    at least one available set bit.
 * 4. Decrease the frequency of each bit used.
 * 5. Add the square of each constructed number to the answer,
 *    taking modulo 1_000_000_007.
 *
 * Greedy Idea:
 * Distribute each available bit to the numbers being constructed
 * so that as many high-value bits as possible are combined together.
 * This maximizes the sum of squares.
 *
 * Time Complexity: O(n * B + k * B)
 * Space Complexity: O(B)
 *
 * Where B = 30 bit positions.
 *
 * Date Solved: 12 October 2026
 */

import java.util.*;

class Solution {

    public int maxSum(List<Integer> nums, int k) {

        int[] bitCount = new int[30];

        long answer = 0;
        long mod = 1_000_000_007L;

        // Step 1: Count set bits at every bit position.
        for (int num : nums) {

            for (int i = 0; i < 30; i++) {

                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        // Step 2: Greedily construct k numbers.
        while (k-- > 0) {

            long num = 0;

            for (int i = 0; i < 30; i++) {

                if (bitCount[i] > 0) {

                    // Include this available bit.
                    num |= (1L << i);

                    // This bit has now been used.
                    bitCount[i]--;
                }
            }

            // Add the square of the constructed number.
            answer = (answer + num * num) % mod;
        }

        return (int) answer;
    }
}
