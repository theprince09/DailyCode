/*
 * LeetCode: Stone Game VIII
 * Problem: Given an integer array stones, Alice and Bob take turns
 * combining the leftmost stones. Each player adds the sum of the
 * removed stones to their score.
 *
 * Goal:
 * Return the maximum possible score difference:
 * Alice's Score - Bob's Score
 *
 * Date Solved: 24 August 2026
 *
 * Approach:
 * 1. Convert the array into prefix sums.
 * 2. Start with the total sum of all stones.
 * 3. Iterate from right to left and use DP to calculate the
 *    maximum score difference.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Calculate prefix sums
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Start with the total sum
        int dp = stones[n - 1];

        // Calculate maximum score difference
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, stones[i] - dp);
        }

        return dp;
    }
}
