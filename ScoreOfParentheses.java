/*
 * Day 42 - LeetCode
 *
 * Problem: Score of Parentheses
 *
 * Given a balanced parentheses string, calculate its score:
 *
 * 1. "()" has score 1.
 * 2. AB has score A + B, where A and B are balanced strings.
 * 3. (A) has score 2 * A.
 *
 * Approach:
 * 1. Maintain the current nesting depth.
 * 2. Increase depth when '(' is encountered.
 * 3. Decrease depth when ')' is encountered.
 * 4. If ')' directly follows '(', we found the primitive "()" pair.
 * 5. Its contribution is:
 *
 *        2^depth
 *
 *    where depth is the depth after closing the pair.
 *
 * 6. Add this contribution to the total score.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 5 October 2026
 */

class Solution {

    public int scoreOfParentheses(String s) {

        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                depth++;

            } else {

                depth--;

                /*
                 * If ')' directly follows '(',
                 * we found a primitive "()" pair.
                 *
                 * Its contribution is 2^depth.
                 */
                if (s.charAt(i - 1) == '(') {
                    score += (1 << depth);
                }
            }
        }

        return score;
    }
}
