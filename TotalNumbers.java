/*
 * Day 18 - LeetCode
 *
 * Problem: Total Numbers
 *
 * Given an array of digits, count how many distinct 3-digit even numbers
 * can be formed using these digits.
 *
 * Rules:
 * 1. The number must be a 3-digit number, so the first digit cannot be 0.
 * 2. The last digit must be even.
 * 3. Each digit can be used only as many times as it appears in the
 *    given array.
 *
 * Approach:
 * 1. Count the frequency of every digit using a frequency array.
 *
 * 2. Choose the hundreds digit:
 *    - It can be from 1 to 9 because the number cannot start with 0.
 *
 * 3. Choose the tens digit:
 *    - It can be from 0 to 9.
 *    - Make sure enough copies of the digit are available if it is
 *      the same as the hundreds digit.
 *
 * 4. Choose the units digit:
 *    - It must be even: 0, 2, 4, 6, or 8.
 *    - Make sure enough copies are available considering the digits
 *      already used.
 *
 * 5. Every valid combination represents one distinct 3-digit number.
 *
 * Time Complexity: O(10 * 10 * 5) = O(1)
 * Space Complexity: O(10) = O(1)
 *
 * Date Solved: 11 September 2026
 */

class Solution {

    public int totalNumbers(int[] digits) {

        // Frequency of each digit
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int result = 0;

        // Choose the hundreds digit
        // It cannot be 0.
        for (int first = 1; first < 10; first++) {

            // Choose the tens digit
            for (int second = 0; second < 10; second++) {

                // Choose the units digit
                // It must be even.
                for (int third = 0; third < 10; third += 2) {

                    /*
                     * Check whether enough copies of each digit
                     * are available.
                     */
                    if (freq[first] > 0
                            && freq[second] > (first == second ? 1 : 0)
                            && freq[third] > (first == third ? 1 : 0)
                            + (second == third ? 1 : 0)) {

                        result++;
                    }
                }
            }
        }

        return result;
    }
}
