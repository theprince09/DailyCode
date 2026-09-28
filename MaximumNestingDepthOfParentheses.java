/*
 * Day 35 - LeetCode
 *
 * Problem: Maximum Nesting Depth of the Parentheses
 *
 * Given a valid parentheses string, find its maximum nesting depth.
 *
 * Approach:
 * 1. Maintain `currentDepth` to represent the current number of
 *    open parentheses.
 * 2. Whenever '(' is encountered, increase the depth.
 * 3. Update the maximum depth.
 * 4. Whenever ')' is encountered, decrease the depth.
 * 5. Return the maximum depth encountered.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 28 September 2026
 */

class Solution {

    public int maxDepth(String s) {

        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {

                currentDepth++;

                // Track the maximum nesting depth.
                maxDepth = Math.max(maxDepth, currentDepth);
            }

            else if (c == ')') {

                currentDepth--;
            }
        }

        return maxDepth;
    }
}
