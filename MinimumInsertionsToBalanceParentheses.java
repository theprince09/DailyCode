/*
 * Day 46 - LeetCode
 *
 * Problem: Minimum Insertions to Balance a Parentheses String
 *
 * Given a parentheses string, find the minimum number of insertions
 * needed to make it valid.
 *
 * Every '(' must be matched with exactly two consecutive ')'.
 *
 * Approach:
 * 1. Track unmatched opening parentheses using `open`.
 * 2. When '(' is encountered, increment `open`.
 * 3. When ')' is encountered:
 *      - Check whether the next character is also ')'.
 *      - If yes, consume both closing parentheses.
 *      - Otherwise, insert one ')' to complete the pair.
 * 4. Match the closing pair with an unmatched '('.
 *      - If an opening parenthesis exists, decrement `open`.
 *      - Otherwise, insert one '('.
 * 5. Every remaining '(' needs two ')' insertions.
 * 6. Return the total number of insertions.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 9 October 2026
 */

class Solution {

    public int minInsertions(String s) {

        int open = 0;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                open++;

            } else {

                // Ensure this ')' has a second closing parenthesis.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'.
                } else {
                    answer++; // Insert the missing ')'.
                }

                // Match this pair with an opening parenthesis.
                if (open > 0) {
                    open--;
                } else {
                    answer++; // Insert a missing '('.
                }
            }
        }

        // Each unmatched '(' needs two closing parentheses.
        return answer + open * 2;
    }
}
