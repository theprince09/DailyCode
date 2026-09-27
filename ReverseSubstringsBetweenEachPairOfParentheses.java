/*
 * Day 34 - LeetCode
 *
 * Problem: Reverse Substrings Between Each Pair of Parentheses
 *
 * Given a string containing lowercase English letters and
 * parentheses, reverse the strings inside each pair of matching
 * parentheses, starting from the innermost pair.
 *
 * Return the final string without any parentheses.
 *
 * Approach:
 * 1. Use a stack to find matching pairs of parentheses.
 * 2. Store the matching position of every parenthesis in the
 *    link[] array.
 * 3. Traverse the string using a direction variable:
 *      - dir = 1  -> move forward
 *      - dir = -1 -> move backward
 * 4. Whenever a parenthesis is encountered, jump directly to its
 *    matching parenthesis and reverse the traversal direction.
 * 5. Append only lowercase letters to the result.
 *
 * This effectively performs all required reversals without
 * explicitly reversing any substring.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 27 September 2026
 */

import java.util.*;

class Solution {

    public String reverseParentheses(String s) {

        int n = s.length();

        // link[i] stores the matching parenthesis of index i.
        int[] link = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Find matching parentheses.
        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            }

            else if (c == ')') {

                int open = stack.pop();

                link[i] = open;
                link[open] = i;
            }
        }

        StringBuilder result = new StringBuilder();

        int direction = 1;

        for (int i = 0; i < n; i += direction) {

            char c = s.charAt(i);

            // Append normal lowercase characters.
            if (c >= 'a' && c <= 'z') {
                result.append(c);
            }

            else {
                // Jump to the matching parenthesis.
                i = link[i];

                // Reverse traversal direction.
                direction = -direction;
            }
        }

        return result.toString();
    }
}
