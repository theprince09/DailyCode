/*
 * Day 31 - LeetCode
 *
 * Problem: Smallest Index With Digit Sum Equal to Index
 *
 * Given an integer array nums, find the smallest index i such that
 * the sum of the digits of nums[i] is equal to i.
 *
 * Return -1 if no such index exists.
 *
 * Approach:
 * 1. Traverse the array from left to right.
 * 2. For each number, calculate its digit sum.
 * 3. Compare the digit sum with the current index.
 * 4. Since we traverse from left to right, the first matching
 *    index is automatically the smallest index.
 * 5. Return -1 if no index satisfies the condition.
 *
 * Time Complexity: O(n * d)
 * Space Complexity: O(1)
 *
 * Where d is the number of digits in a number.
 *
 * Date Solved: 24 September 2026
 */

class Solution {

    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int digitSum = 0;

            // Calculate the sum of digits.
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }

            // First matching index is the smallest.
            if (digitSum == i) {
                return i;
            }
        }

        return -1;
    }
}
