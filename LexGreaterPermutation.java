/*
 * Day 4 - LeetCode
 *
 * Problem: Lexicographically Greater Permutation
 *
 * Given two strings s and target, rearrange the characters of s
 * to form the lexicographically smallest string that is strictly
 * greater than target.
 *
 * If no such permutation is possible, return an empty string.
 *
 * Approach:
 * 1. Count the frequency of every character in s.
 * 2. Subtract the characters used by target from the frequency array.
 * 3. Traverse target from right to left.
 * 4. At each position, restore the current target character.
 * 5. Check whether the prefix target[0...i-1] can be formed.
 * 6. Find the smallest available character greater than target[i].
 * 7. Place that character at position i.
 * 8. Append all remaining characters in sorted order to get the
 *    smallest possible lexicographically greater permutation.
 *
 * Time Complexity: O(n * 26)
 * Space Complexity: O(n + 26)
 *
 * Date Solved: 27 August 2026
 */

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        // Count characters available in s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Assume target is formed and subtract its characters
        for (char ch : target.toCharArray()) {
            count[ch - 'a']--;
        }

        // Try changing target from right to left
        for (int i = target.length() - 1; i >= 0; i--) {

            int current = target.charAt(i) - 'a';

            // Restore the current character
            count[current]++;

            // Check whether target[0...i-1] can be formed
            boolean validPrefix = true;

            for (int x : count) {
                if (x < 0) {
                    validPrefix = false;
                    break;
                }
            }

            if (!validPrefix) {
                continue;
            }

            // Find the smallest character greater than target[i]
            int next = -1;

            for (int c = current + 1; c < 26; c++) {
                if (count[c] > 0) {
                    next = c;
                    break;
                }
            }

            if (next == -1) {
                continue;
            }

            // Use the selected character
            count[next]--;

            StringBuilder answer = new StringBuilder();

            // Keep the prefix same as target
            answer.append(target, 0, i);

            // Add the smallest greater character
            answer.append((char) ('a' + next));

            // Add remaining characters in sorted order
            for (int c = 0; c < 26; c++) {
                while (count[c] > 0) {
                    answer.append((char) ('a' + c));
                    count[c]--;
                }
            }

            return answer.toString();
        }

        return "";
    }
}
