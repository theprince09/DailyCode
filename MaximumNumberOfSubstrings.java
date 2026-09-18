/*
 * Day 25 - LeetCode
 *
 * Problem: Maximum Number of Substrings
 *
 * Given a string s, find the maximum number of non-overlapping
 * substrings such that each character appearing in a substring
 * occurs only inside that substring.
 *
 * If multiple valid answers exist, return any answer with the
 * maximum number of substrings.
 *
 * Approach:
 * 1. Find the first and last occurrence of every character.
 * 2. For each character, create a candidate interval starting at
 *    its first occurrence and ending at its last occurrence.
 * 3. Expand the interval whenever a character inside it has a
 *    last occurrence beyond the current right boundary.
 * 4. If a character inside the interval has its first occurrence
 *    before the interval's left boundary, the interval is invalid.
 * 5. Store every valid interval.
 * 6. Sort intervals by their right endpoint.
 * 7. Greedily select intervals that do not overlap with the
 *    previously selected interval.
 *
 * Time Complexity: O(n + 26 * n + 26 log 26)
 * Space Complexity: O(26)
 *
 * Date Solved: 18 September 2026
 */

import java.util.*;

class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence of every character.
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        // Store intervals as {right, left}.
        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {

            // Character does not exist in the string.
            if (last[c] == -1) {
                continue;
            }

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            // Expand the interval whenever necessary.
            for (int i = left; i <= right; i++) {

                int d = s.charAt(i) - 'a';

                // This character occurs before our current interval.
                if (first[d] < left) {
                    valid = false;
                    break;
                }

                // Include all occurrences of this character.
                right = Math.max(right, last[d]);
            }

            if (valid) {
                intervals.add(new int[]{right, left});
            }
        }

        // Sort by right endpoint.
        intervals.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        List<String> answer = new ArrayList<>();

        int previousRight = -1;

        // Greedily select non-overlapping intervals.
        for (int[] interval : intervals) {

            int right = interval[0];
            int left = interval[1];

            if (left > previousRight) {
                answer.add(s.substring(left, right + 1));
                previousRight = right;
            }
        }

        return answer;
    }
}
