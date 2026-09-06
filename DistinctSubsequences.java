/*
 * Day 13 - LeetCode
 *
 * Problem: Distinct Subsequences
 *
 * Given two strings s and t, return the number of distinct subsequences
 * of s which equal t.
 *
 * A subsequence is formed by deleting some (possibly zero) characters
 * from s without changing the order of the remaining characters.
 *
 * Approach:
 * 1. Use Dynamic Programming.
 *
 * 2. Let dp[i][j] represent the number of distinct subsequences of
 *    s[i...] that can form t[j...].
 *
 * 3. Base Case:
 *    If j == t.length(), then t is completely formed.
 *    There is exactly one way to form an empty string:
 *
 *        dp[i][n] = 1
 *
 * 4. If s[i] == t[j], we have two choices:
 *
 *    - Use s[i] to match t[j]:
 *          dp[i + 1][j + 1]
 *
 *    - Skip s[i]:
 *          dp[i + 1][j]
 *
 *    Therefore:
 *
 *        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j]
 *
 * 5. If s[i] != t[j], we cannot use s[i], so we skip it:
 *
 *        dp[i][j] = dp[i + 1][j]
 *
 * 6. The final answer is dp[0][0].
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 *
 * Date Solved: 6 September 2026
 */

class Solution {

    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        // If s is shorter than t, forming t is impossible.
        if (m < n) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];

        /*
         * If t is completely matched, there is exactly one way
         * to form the empty remaining string.
         */
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        /*
         * Fill the DP table from bottom-right to top-left.
         */
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                if (s.charAt(i) == t.charAt(j)) {

                    // Take current character OR skip it
                    dp[i][j] =
                            dp[i + 1][j + 1]
                            + dp[i + 1][j];

                } else {

                    // Current characters do not match, so skip s[i]
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
