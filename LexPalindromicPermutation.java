/*
 * Day 5 - LeetCode
 *
 * Problem: Lexicographically Smallest Palindromic Permutation
 *
 * Given two strings s and target, rearrange the characters of s to
 * form a palindrome that is lexicographically greater than target.
 *
 * Among all valid palindromes, return the lexicographically smallest one.
 * If no such palindrome can be formed, return an empty string.
 *
 * Approach:
 * 1. Count the frequency of every character in s.
 * 2. A palindrome can have at most one character with an odd frequency.
 *    That character becomes the middle character.
 * 3. For every character, use half of its frequency to construct the
 *    left half of the palindrome.
 * 4. Build the left half greedily from left to right.
 * 5. At every position, try characters from 'a' to 'z'.
 * 6. Temporarily place a character and construct the largest possible
 *    palindrome using the remaining characters.
 * 7. If that palindrome is greater than target, the character is valid.
 * 8. Keep the smallest valid palindrome.
 * 9. Mirror the left half around the middle character to form the
 *    complete palindrome.
 *
 * Time Complexity: O(26 * n^2)
 * Space Complexity: O(n)
 *
 * Date Solved: 28 August 2026
 */

class Solution {

    private String isPossible(
            int n,
            int[] freq,
            String cur,
            char mid,
            String target
    ) {
        // Construct the largest possible left half
        // using remaining characters in descending order.
        StringBuilder left = new StringBuilder(cur);

        for (int i = 25; i >= 0; i--) {
            while (freq[i] > 0) {
                left.append((char) ('a' + i));
                freq[i]--;
            }
        }

        // Build the complete palindrome.
        StringBuilder palindrome = new StringBuilder(left);

        if (mid != '#') {
            // Odd-length palindrome:
            // left half + middle + reverse(left half)
            palindrome.append(mid);

            for (int i = left.length() - 1; i >= 0; i--) {
                palindrome.append(left.charAt(i));
            }
        } else {
            // Even-length palindrome:
            // left half + reverse(left half)
            for (int i = left.length() - 1; i >= 0; i--) {
                palindrome.append(left.charAt(i));
            }
        }

        String result = palindrome.toString();

        return result.compareTo(target) > 0 ? result : "";
    }

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        // Count character frequencies.
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find the middle character and prepare the left half.
        char mid = '#';
        int oddCount = 0;

        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1) {
                // This character can be used as the middle character.
                mid = (char) ('a' + i);
                freq[i]--;
                oddCount++;
            }

            // Only half of each frequency is needed for the left half.
            freq[i] /= 2;

            // More than one odd frequency means a palindrome
            // cannot be formed.
            if (oddCount >= 2) {
                return "";
            }
        }

        // Only the left half needs to be constructed.
        int halfLength = n / 2;

        String prefix = "";
        String result = "";

        // Greedily construct the left half.
        for (int i = 0; i < halfLength; i++) {

            boolean found = false;

            // Try the smallest character first.
            for (int j = 0; j < 26; j++) {

                if (freq[j] == 0) {
                    continue;
                }

                freq[j]--;

                String cur = prefix + (char) ('a' + j);

                // Check whether this choice can produce
                // a palindrome greater than target.
                String possible = isPossible(
                        halfLength,
                        freq,
                        cur,
                        mid,
                        target
                );

                if (!possible.isEmpty()) {
                    prefix = cur;
                    found = true;

                    // Keep the smallest valid palindrome.
                    if (result.isEmpty()
                            || possible.compareTo(result) < 0) {
                        result = possible;
                    }

                    break;
                }

                // Undo the choice and try the next character.
                freq[j]++;
            }

            // No character can be placed at this position.
            if (!found) {
                return "";
            }
        }

        return result;
    }
}
