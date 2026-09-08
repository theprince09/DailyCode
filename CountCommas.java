/*
 * Day 15 - LeetCode
 *
 * Problem: Count Commas
 *
 * Given an integer n, count the total number of commas that would appear
 * when writing all integers from 1 to n using standard decimal notation.
 *
 * Approach:
 * Numbers from 1 to 999 do not contain any commas.
 * Every number from 1000 onward contains at least one comma.
 *
 * Therefore, the number of commas is:
 *
 *     n - 999
 *
 * Since n can be less than 999, use Math.max(0, n - 999).
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Date Solved: 8 September 2026
 */

class Solution {

    public int countCommas(int n) {
        return Math.max(0, n - 999);
    }
}
