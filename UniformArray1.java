/*
 * Day 10 - LeetCode
 *
 * Problem: Uniform Array
 *
 * Given an integer array A, determine whether the array can be made
 * uniform using the allowed operations.
 *
 * Approach:
 * 1. Find the minimum value in the array.
 * 2. Check whether the array contains at least one odd number.
 * 3. The result depends on the parity (odd/even) of the minimum value
 *    and whether any element in the array is odd.
 *
 *    - If the minimum value is odd, the array must contain an odd number.
 *    - If the minimum value is even, the array must contain no odd number.
 *
 * 4. Therefore, the array is uniform if:
 *
 *       (minimum value % 2 == 1) == (there exists an odd element)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 3 September 2026
 */

class Solution {

    public boolean uniformArray(int[] A) {

        int minValue = A[0];
        boolean hasOdd = false;

        for (int x : A) {

            // Find the minimum value
            minValue = Math.min(minValue, x);

            // Check if there is any odd number
            if ((x & 1) == 1) {
                hasOdd = true;
            }
        }

        // Minimum value's parity must match
        // whether the array contains an odd number.
        return ((minValue & 1) == 1) == hasOdd;
    }
}
