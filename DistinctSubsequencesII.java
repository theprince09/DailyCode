/*
 * Day 14 - LeetCode
 *
 * Problem: Distinct Subsequences II
 *
 * Given a string s, return the number of distinct non-empty subsequences
 * of s.
 *
 * Since the answer can be very large, return it modulo 10^9 + 7.
 *
 * Approach:
 * 1. Use Dynamic Programming.
 *
 * 2. Let dp[i] represent the number of distinct subsequences that
 *    end at index i.
 *
 * 3. Every character by itself forms a subsequence, so initially:
 *
 *        dp[i] = 1
 *
 * 4. For every previous index j:
 *
 *    - If s[i] != s[j], we can append s[i] to every subsequence
 *      ending at j.
 *
 *    - Therefore:
 *
 *        dp[i] += dp[j]
 *
 * 5. We only extend subsequences whose last character is different
 *    from s[i] to avoid counting duplicate subsequences.
 *
 * 6. Add dp[i] to the final result.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * Date Solved: 7 September 2026
 */

class Solution {

    public int distinctSubseqII(String s) {

        int n = s.length();
        int MOD = 1_000_000_007;

        // dp[i] = number of distinct subsequences ending at i
        int[] dp = new int[n];

        int result = 0;

        for (int i = 0; i < n; i++) {

            // The character itself forms a subsequence
            dp[i] = 1;

            // Try extending subsequences ending before i
            for (int j = 0; j < i; j++) {

                // Avoid duplicate subsequences ending with
                // the same character
                if (s.charAt(i) != s.charAt(j)) {

                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }

            // Add subsequences ending at i to the result
            result = (result + dp[i]) % MOD;
        }

        return result;
    }
}
