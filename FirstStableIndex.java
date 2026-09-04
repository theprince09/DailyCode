/*
 * Day 11 - LeetCode
 *
 * Problem: First Stable Index
 *
 * Given an integer array nums and an integer k, find the first index i
 * such that:
 *
 * max(nums[0 ... i]) - min(nums[i ... n - 1]) <= k
 *
 * Return the smallest such index. If no such index exists, return -1.
 *
 * Approach:
 * 1. Build a suffix minimum array.
 *    min[i] stores the minimum value from nums[i] to the end.
 *
 * 2. Traverse the array from left to right while maintaining the
 *    maximum value seen so far.
 *
 * 3. At every index i:
 *
 *    maximum = max(nums[0 ... i])
 *    minimum = min(nums[i ... n - 1])
 *
 *    If:
 *
 *    maximum - minimum <= k
 *
 *    then i is the first stable index, so return i.
 *
 * 4. If no index satisfies the condition, return -1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 4 September 2026
 */

class Solution {

    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // Suffix minimum array
        int[] min = new int[n];

        min[n - 1] = nums[n - 1];

        // Build suffix minimums
        for (int i = 1; i < n; i++) {
            min[n - i - 1] =
                    Math.min(nums[n - i - 1], min[n - i]);
        }

        // Maximum value in the prefix
        int max = nums[0];

        for (int i = 0; i < n; i++) {

            max = Math.max(nums[i], max);

            // Difference between prefix maximum
            // and suffix minimum
            int difference = max - min[i];

            if (difference <= k) {
                return i;
            }
        }

        return -1;
    }
}
