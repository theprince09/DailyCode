/*
 * Day 38 - LeetCode
 *
 * Problem: Valid Parentheses
 *
 * Given a string containing '(', ')', '{', '}', '[' and ']',
 * determine whether the input string has valid parentheses.
 *
 * A valid string must satisfy:
 * 1. Every opening bracket has a corresponding closing bracket.
 * 2. Brackets close in the correct order.
 * 3. Every closing bracket matches the most recently opened bracket.
 *
 * Approach:
 * 1. Use a stack to store opening brackets.
 * 2. Push every opening bracket onto the stack.
 * 3. For every closing bracket:
 *      - The stack must not be empty.
 *      - Pop the top opening bracket.
 *      - Check whether it matches the closing bracket.
 * 4. At the end, the stack must be empty.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 1 October 2026
 */

import java.util.*;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Store opening brackets.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else {

                // No opening bracket available to match.
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check whether the brackets match.
                if ((ch == ')' && top != '(')
                        || (ch == '}' && top != '{')
                        || (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // All opening brackets must have been closed.
        return stack.isEmpty();
    }
}
