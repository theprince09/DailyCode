/*
 * Day 27 - LeetCode
 *
 * Problem: Reverse Degree of a String
 *
 * Given a string s consisting of lowercase English letters,
 * calculate its reverse degree.
 *
 * The reverse value of a letter is:
 *      'a' -> 26
 *      'b' -> 25
 *      ...
 *      'z' -> 1
 *
 * The reverse degree is the sum of:
 *      reverseValue(letter) * position
 *
 * where position starts from 1.
 *
 * Approach:
 * 1. Traverse the string from left to right.
 * 2. Calculate the reverse value of each character using:
 *      26 - (c - 'a')
 * 3. Multiply the reverse value by its 1-based position.
 * 4. Add the result to the total sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 20 September 2026
 */

class Solution {

    public int reverseDegree(String s) {

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Calculate reverse alphabetical value.
            int reverseValue = 26 - (c - 'a');

            // Position starts from 1.
            int position = i + 1;

            sum += reverseValue * position;
        }

        return sum;
    }
}
