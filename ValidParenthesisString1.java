/*
 * Day 41 - LeetCode
 *
 * Problem: Valid Parenthesis String
 *
 * Given a string containing '(', ')' and '*', determine whether
 * the string can be a valid parentheses string.
 *
 * The '*' character can represent:
 *      '('
 *      ')'
 *      ''
 *
 * Approach:
 * 1. Maintain a range of possible balances:
 *      low  = minimum possible number of unmatched '('
 *      high = maximum possible number of unmatched '('
 *
 * 2. For '(':
 *      low++ and high++
 *
 * 3. For ')':
 *      low-- and high--
 *
 * 4. For '*':
 *      - It can act as ')', decreasing the balance.
 *      - It can act as '(', increasing the balance.
 *      - It can also be empty.
 *      Therefore:
 *          low--
 *          high++
 *
 * 5. If high becomes negative, there is no possible valid balance.
 * 6. low can never be negative because we can choose '*' as empty
 *    or '(' when necessary.
 * 7. At the end, low must be 0 for a valid string to exist.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 4 October 2026
 */

class Solution {

    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {

                // Must be an opening parenthesis.
                low++;
                high++;

            } else if (c == ')') {

                // Must be a closing parenthesis.
                low--;
                high--;

            } else {

                // '*' can be '(', ')' or empty.
                low--;
                high++;
            }

            // Even the maximum possible balance is invalid.
            if (high < 0) {
                return false;
            }

            // Balance cannot be negative.
            low = Math.max(low, 0);
        }

        // A zero balance must be achievable.
        return low == 0;
    }
}
