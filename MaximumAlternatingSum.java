/*
 * Day 50 - LeetCode
 *
 * Problem: Maximum Alternating Sum of Squares
 *
 * Given an integer array nums, maximize the alternating sum
 * of squared elements after rearranging the array.
 *
 * The alternating sum is:
 * nums[0]^2 - nums[1]^2 + nums[2]^2 - nums[3]^2 + ...
 *
 * Approach:
 * 1. Convert every element to its absolute value.
 * 2. Sort the array in ascending order.
 * 3. Add the squares of the smaller half to a negative sum.
 * 4. Add the squares of the larger half to a positive sum.
 * 5. Subtract the smaller-half sum from the larger-half sum.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space, excluding sorting overhead.
 *
 * Date Solved: 13 October 2026
 */

import java.util.*;

class Solution {

    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

        // Convert every element to its absolute value.
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }

        // Sort the absolute values.
        Arrays.sort(nums);

        long negativeSum = 0;
        long positiveSum = 0;

        // Smaller half contributes negatively.
        for (int i = 0; i < n / 2; i++) {
            negativeSum += (long) nums[i] * nums[i];
        }

        // Larger half contributes positively.
        for (int i = n / 2; i < n; i++) {
            positiveSum += (long) nums[i] * nums[i];
        }

        return positiveSum - negativeSum;
    }
}
