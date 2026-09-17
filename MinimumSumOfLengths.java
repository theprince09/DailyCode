/*
 * Day 24 - LeetCode
 *
 * Problem: Find Two Non-overlapping Sub-arrays Each With Target Sum
 *
 * Given an array of positive integers and a target k, find two
 * non-overlapping subarrays whose sums are equal to k.
 * Return the minimum possible sum of their lengths.
 *
 * Approach:
 * 1. Use a sliding window to find every subarray whose sum is k.
 * 2. dp[i] stores the minimum length of a valid subarray with sum k
 *    found completely within the first i elements.
 * 3. When a valid subarray [i...j] is found:
 *      - Its length is j - i + 1.
 *      - dp[i] gives the best non-overlapping subarray before it.
 *      - Update the answer using:
 *            length + dp[i]
 * 4. Update dp[j + 1] with the minimum valid length seen so far.
 * 5. If no pair of non-overlapping subarrays exists, return -1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 17 September 2026
 */

class Solution {

    public int minSumOfLengths(int[] arr, int k) {

        int n = arr.length;
        int result = n + 1;

        int[] dp = new int[n + 1];

        // Represents no valid subarray found yet.
        for (int i = 0; i <= n; i++) {
            dp[i] = n;
        }

        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Shrink the window if the sum becomes too large.
            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            // Carry forward the best answer so far.
            dp[right + 1] = dp[right];

            // Found a subarray with sum exactly k.
            if (sum == k) {

                int length = right - left + 1;

                // dp[left] is completely before this subarray.
                result = Math.min(result, length + dp[left]);

                // Store the shortest valid subarray ending at or before right.
                dp[right + 1] = Math.min(dp[right], length);
            }
        }

        return result == n + 1 ? -1 : result;
    }
}
