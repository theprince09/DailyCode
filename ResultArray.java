/*
 * Day 28 - LeetCode
 *
 * Problem: Find Products of Elements of a Subarray
 *
 * Given an integer array nums and an integer k, find the number
 * of subarrays whose product has each possible remainder modulo k.
 *
 * Return an array ans where:
 *      ans[r] = number of subarrays whose product % k == r
 *
 * Approach:
 * 1. dp[r] stores the number of subarrays ending at the previous
 *    position whose product has remainder r modulo k.
 * 2. For every new number, calculate:
 *      x = num % k
 * 3. Start a new subarray containing only the current number:
 *      next[x]++
 * 4. Extend every previous subarray:
 *      newR = (r * x) % k
 *      next[newR] += dp[r]
 * 5. Add all values from next[] to the final answer.
 * 6. Set dp = next and continue.
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(k)
 *
 * Date Solved: 21 September 2026
 */

class Solution {

    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at the previous
        // position whose product % k == r.
        long[] dp = new long[k];

        for (int num : nums) {

            int x = num % k;

            long[] next = new long[k];

            // Start a new subarray with the current element.
            next[x]++;

            // Extend all previous subarrays.
            for (int r = 0; r < k; r++) {

                int newR = (r * x) % k;

                next[newR] += dp[r];
            }

            // Add current subarray counts to the final answer.
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            // Current subarrays become previous for the next iteration.
            dp = next;
        }

        return ans;
    }
}
