/*
 * Day 40 - LeetCode
 *
 * Problem: Longest Valid Parentheses
 *
 * Given a string containing only '(' and ')', find the length
 * of the longest valid parentheses substring.
 *
 * Approach:
 * 1. Traverse the string from left to right using two counters:
 *      open  = number of '('
 *      close = number of ')'
 *
 * 2. When open == close, we have a valid parentheses substring
 *    of length 2 * close.
 *
 * 3. If close > open, the current substring cannot become valid,
 *    so reset both counters.
 *
 * 4. Perform a second traversal from right to left.
 *    This handles cases where there are extra '(' characters.
 *
 * 5. During the reverse traversal, if open > close, reset both
 *    counters.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 3 October 2026
 */

class Solution {

    public int longestValidParentheses(String s) {

        int answer = 0;

        int open = 0;
        int close = 0;

        // Pass 1: Left to right.
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            // Found a balanced valid substring.
            if (open == close) {
                answer = Math.max(answer, 2 * close);
            }

            // Too many closing parentheses.
            else if (close > open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;

        // Pass 2: Right to left.
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            // Found a balanced valid substring.
            if (open == close) {
                answer = Math.max(answer, 2 * open);
            }

            // Too many opening parentheses.
            else if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return answer;
    }
}
