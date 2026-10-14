/*
 * Day 51 - LeetCode
 *
 * Problem: Maximum Sum of Squares / Largest Number With Given Digit Sum
 *
 * Given num digits and a required digit sum, construct the
 * lexicographically largest num-digit string whose digits add up
 * to sum.
 *
 * Approach:
 * 1. The maximum possible digit sum is 9 * num.
 * 2. If sum exceeds this limit, return an empty string.
 * 3. Build the answer from left to right.
 * 4. At each position, choose the largest possible digit:
 *      digit = min(9, sum)
 * 5. Subtract the chosen digit from sum.
 * 6. If the remaining sum is zero after all positions are filled,
 *    return the result; otherwise, return an empty string.
 *
 * Time Complexity: O(num)
 * Space Complexity: O(num)
 *
 * Date Solved: 14 October 2026
 */

class Solution {

    public String maxSumOfSquares(int num, int sum) {

        // The maximum possible sum of num digits is 9 * num.
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder answer = new StringBuilder();

        // Greedily fill each position with the largest possible digit.
        while (num-- > 0) {

            int digit = Math.min(9, sum);

            answer.append(digit);
            sum -= digit;
        }

        // Return only if the required sum has been achieved.
        return sum == 0 ? answer.toString() : "";
    }
}
