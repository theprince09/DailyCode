/*
 * Day 45 - LeetCode
 *
 * Problem: Remove Outermost Parentheses
 *
 * Given a valid parentheses string, remove the outermost pair
 * of parentheses from every primitive component.
 *
 * Approach:
 * 1. Maintain `level` to track the current nesting depth.
 * 2. For '(':
 *      - If level > 0, it is not an outermost '(',
 *        so add it to the result.
 *      - Then increase the level.
 * 3. For ')':
 *      - First decrease the level.
 *      - If level > 0, it is not an outermost ')',
 *        so add it to the result.
 * 4. Parentheses that change the level between 0 and 1 are
 *    the outermost parentheses and are therefore skipped.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 8 October 2026
 */

class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();

        int level = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {

                // Keep '(' only if it is not outermost.
                if (level > 0) {
                    result.append(c);
                }

                level++;

            } else {

                level--;

                // Keep ')' only if it is not outermost.
                if (level > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
