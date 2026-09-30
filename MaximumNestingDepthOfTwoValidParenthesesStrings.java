/*
 * Day 37 - LeetCode
 *
 * Problem: Maximum Nesting Depth of Two Valid Parentheses Strings
 *
 * Given a valid parentheses sequence, split it into two valid
 * parentheses sequences such that the maximum nesting depth of
 * the two sequences is minimized.
 *
 * Approach:
 * 1. Maintain the current nesting depth.
 * 2. For an opening parenthesis:
 *      - Increase the depth.
 *      - Assign it to group `depth % 2`.
 * 3. For a closing parenthesis:
 *      - Assign it using the current depth % 2.
 *      - Then decrease the depth.
 * 4. Alternating based on depth parity distributes nested
 *    parentheses between the two groups.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 30 September 2026
 */

class Solution {

    public int[] maxDepthAfterSplit(String seq) {

        int depth = 0;
        int[] answer = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {

            char ch = seq.charAt(i);

            if (ch == '(') {

                depth++;

                // Assign based on the current depth.
                answer[i] = depth % 2;

            } else {

                // Use the current depth before decreasing it.
                answer[i] = depth % 2;

                depth--;
            }
        }

        return answer;
    }
}
