/*
 * Day 48 - LeetCode
 *
 * Problem: Sum of Squares of Special Elements
 *
 * Given an integer array nums of length n, an element nums[i]
 * is special if n is divisible by its 1-based index (i + 1).
 *
 * Return the sum of squares of all special elements.
 *
 * Approach:
 * 1. Find the length n of the array.
 * 2. Traverse the array using index i.
 * 3. Check whether n % (i + 1) == 0.
 * 4. If true, add nums[i] * nums[i] to the answer.
 * 5. Return the final sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 11 October 2026
 */

class Solution {

    public int sumOfSquares(int[] nums) {

        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            // Check whether the 1-based index divides n.
            if (n % (i + 1) == 0) {
                sum += nums[i] * nums[i];
            }
        }

        return sum;
    }
}
