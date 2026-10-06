/*
 * Day 43 - LeetCode
 *
 * Problem: Minimum Add to Make Parentheses Valid
 *
 * Given a string s containing '(' and ')', find the minimum number
 * of parentheses that must be added to make the string valid.
 *
 * Approach:
 * 1. Maintain `open` = number of currently unmatched '('.
 * 2. When '(' is encountered, increase `open`.
 * 3. When ')' is encountered:
 *      - If there is an unmatched '(', match it and decrease `open`.
 *      - Otherwise, this ')' needs a new '(' before it.
 *        Increase `count`.
 * 4. After processing the entire string, any remaining unmatched
 *    '(' needs a ')' for each one.
 * 5. Therefore, the answer is:
 *
 *        count + open
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 6 October 2026
 */

class Solution {

    public int minAddToMakeValid(String s) {

        int open = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                open++;

            } else {

                // No '(' available to match this ')'.
                if (open == 0) {
                    count++;
                } else {
                    // Match ')' with an existing '('.
                    open--;
                }
            }
        }

        // Remaining '(' need closing ')'.
        return open + count;
    }
}
