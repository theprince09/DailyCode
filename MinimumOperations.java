/*
 * Day 30 - LeetCode
 *
 * Problem: Minimum Operations to Reduce X to Zero
 *
 * Given an array nums and an integer x, remove elements from either
 * the left or right side of the array until the sum of removed
 * elements is exactly x.
 *
 * Return the minimum number of operations required.
 * If it is impossible, return -1.
 *
 * Approach:
 * 1. Calculate the total sum of the array.
 * 2. Instead of finding the elements to remove, find the longest
 *    subarray that can remain.
 * 3. If the removed elements sum to x, then the remaining subarray
 *    must have sum:
 *
 *        target = total - x
 *
 * 4. Since all numbers are positive, use a sliding window to find
 *    the longest subarray with sum equal to target.
 * 5. If the longest valid subarray has length L, then the minimum
 *    number of removed elements is:
 *
 *        n - L
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 23 September 2026
 */

class Solution {

    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        // Calculate total sum of the array.
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Sum of the subarray that should remain.
        int target = total - x;

        // Target is impossible.
        if (target < 0) {
            return -1;
        }

        // We need to remove every element.
        if (target == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;
        int longest = -1;

        // Find the longest subarray with sum = target.
        for (int right = 0; right < n; right++) {

            sum += nums[right];

            // Shrink the window if its sum becomes too large.
            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            // Found a valid subarray.
            if (sum == target) {
                longest = Math.max(
                        longest,
                        right - left + 1
                );
            }
        }

        // Remove everything outside the longest valid subarray.
        return longest == -1 ? -1 : n - longest;
    }
}
