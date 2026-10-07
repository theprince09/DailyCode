/*
 * Day 44 - LeetCode
 *
 * Problem: Remove Invalid Parentheses
 *
 * Given a string containing parentheses and lowercase letters,
 * remove the minimum number of invalid parentheses so that the
 * resulting strings are valid.
 *
 * Return all possible valid strings.
 *
 * Approach:
 * 1. Scan from left to right to detect an excess of ')'.
 * 2. When an invalid ')' is found, try removing each possible
 *    ')' from the current range.
 * 3. Avoid removing consecutive ')' characters multiple times
 *    to prevent duplicate results.
 * 4. Once the string has no extra ')', scan from right to left
 *    to detect an excess of '('.
 * 5. Remove extra '(' using the same idea.
 * 6. When both directions are valid, add the resulting string
 *    to the answer.
 *
 * This guarantees that only the minimum required parentheses
 * are removed.
 *
 * Time Complexity: O(n * 2^n) in the worst case.
 * Space Complexity: O(n) recursion depth, excluding output.
 *
 * Date Solved: 7 October 2026
 */

import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        // First remove extra ')'.
        forward(s, result, 0, 0);

        return result;
    }

    /*
     * Scan from left to right and remove extra ')'.
     */
    private void forward(
            String s,
            List<String> result,
            int lastInvalid,
            int lastRemoved) {

        int balance = 0;

        for (int i = lastInvalid; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                balance++;
            }

            if (s.charAt(i) == ')') {
                balance--;
            }

            // Prefix is still valid.
            if (balance >= 0) {
                continue;
            }

            /*
             * Found an extra ')'.
             *
             * Try removing every possible ')' between
             * lastRemoved and i.
             */
            for (int j = lastRemoved; j <= i; j++) {

                if (s.charAt(j) == ')'
                        && (j == lastRemoved
                        || s.charAt(j - 1) != ')')) {

                    String next =
                            s.substring(0, j)
                            + s.substring(j + 1);

                    forward(
                            next,
                            result,
                            i,
                            j
                    );
                }
            }

            // Only handle the first invalid ')' at this level.
            return;
        }

        /*
         * No extra ')' remains.
         *
         * Now scan from right to left to remove extra '('.
         */
        backward(
                s,
                result,
                s.length() - 1,
                s.length() - 1
        );
    }

    /*
     * Scan from right to left and remove extra '('.
     */
    private void backward(
            String s,
            List<String> result,
            int lastInvalid,
            int lastRemoved) {

        int balance = 0;

        for (int i = lastInvalid; i >= 0; i--) {

            if (s.charAt(i) == ')') {
                balance++;
            }

            if (s.charAt(i) == '(') {
                balance--;
            }

            // Suffix is still valid.
            if (balance >= 0) {
                continue;
            }

            /*
             * Found an extra '('.
             *
             * Try removing every possible '(' between
             * i and lastRemoved.
             */
            for (int j = lastRemoved; j >= i; j--) {

                if (s.charAt(j) == '('
                        && (j == lastRemoved
                        || s.charAt(j + 1) != '(')) {

                    String next =
                            s.substring(0, j)
                            + s.substring(j + 1);

                    backward(
                            next,
                            result,
                            i - 1,
                            j - 1
                    );
                }
            }

            return;
        }

        // Both directions are valid.
        result.add(s);
    }
}
