/*
 * Day 3 - LeetCode
 *
 * Problem: Shortest Beautiful Substring
 *
 * Given a binary string s and an integer k, find the shortest substring
 * that contains exactly k occurrences of '1'.
 *
 * If multiple substrings have the same minimum length, return the
 * lexicographically smallest one.
 *
 * Approach:
 * 1. Use a sliding window with two pointers.
 * 2. Count the number of '1's in the current window.
 * 3. When the window contains more than k ones, move the left pointer.
 * 4. When the window contains exactly k ones, remove all unnecessary
 *    leading zeros to make the substring as short as possible.
 * 5. Compare the current substring with the best answer found so far.
 *
 * Example:
 * s = "100011001", k = 3
 *
 * Possible valid substring:
 * "100011"
 *
 * Remove unnecessary leading zeros:
 * "11001"
 *
 * Answer = "11001"
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 26 August 2026
 */

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int left = 0;
        int ones = 0;

        String best = "";

        for (int right = 0; right < n; right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // If there are more than k ones, shrink the window
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // If we have exactly k ones,
            // remove unnecessary leading zeros
            while (ones == k && s.charAt(left) == '0') {
                left++;
            }

            // Check the current valid substring
            if (ones == k) {
                String current = s.substring(left, right + 1);

                if (best.isEmpty()
                        || current.length() < best.length()
                        || (current.length() == best.length()
                        && current.compareTo(best) < 0)) {

                    best = current;
                }
            }
        }

        return best;
    }
}
