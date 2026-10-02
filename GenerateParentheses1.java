/*
 * Day 39 - LeetCode
 *
 * Problem: Generate Parentheses
 *
 * Given n pairs of parentheses, generate all combinations of
 * well-formed parentheses.
 *
 * Approach:
 * 1. Use backtracking to construct the string character by character.
 * 2. `open` = number of '(' still available.
 * 3. `close` = number of ')' still available.
 * 4. We can always add '(' if open > 0.
 * 5. We can add ')' only when close > open.
 *    This ensures that we never close more parentheses than we
 *    have opened.
 * 6. When both counters become 0, a complete valid combination
 *    has been constructed.
 *
 * Time Complexity: O(Cn * n)
 * Space Complexity: O(Cn * n)
 *
 * Where Cn is the nth Catalan number, representing the number
 * of valid parentheses combinations.
 *
 * Date Solved: 2 October 2026
 */

import java.util.*;

class Solution {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtrack(n, n, new StringBuilder());

        return result;
    }

    private void backtrack(
            int open,
            int close,
            StringBuilder current) {

        // A complete valid combination is formed.
        if (open == 0 && close == 0) {
            result.add(current.toString());
            return;
        }

        // We can still place an opening parenthesis.
        if (open > 0) {

            current.append('(');

            backtrack(open - 1, close, current);

            current.deleteCharAt(current.length() - 1);
        }

        // We can close only if there are more closing brackets
        // remaining than opening brackets.
        if (close > open) {

            current.append(')');

            backtrack(open, close - 1, current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}
