/*
 * Day 23 - LeetCode
 *
 * Problem: Number of Sets of K Non-Overlapping Line Segments
 *
 * Given n points on a line, count the number of ways to draw exactly
 * k non-overlapping line segments. Segments may share endpoints.
 *
 * Approach:
 * 1. dp[i][j] represents the number of ways to form j segments using
 *    points from 0 to i.
 * 2. For 0 segments, there is exactly 1 way:
 *       dp[i][0] = 1
 * 3. For every number of segments j, maintain a running sum of
 *    dp[i - 1][j - 1].
 * 4. The transition is:
 *       dp[i][j] = dp[i - 1][j] + sum
 * 5. Take modulo 1e9 + 7 at every step.
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(n * k)
 *
 * Date Solved: 16 September 2026
 */

class Solution {

    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {

        long[][] dp = new long[n][k + 1];

        // 0 segments -> exactly 1 way
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int segments = 1; segments <= k; segments++) {

            long sum = 0;

            for (int i = 1; i < n; i++) {

                // Add ways for segments - 1 segments
                sum = (sum + dp[i - 1][segments - 1]) % MOD;

                // Don't use i OR end a segment at i
                dp[i][segments] =
                        (dp[i - 1][segments] + sum) % MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}
