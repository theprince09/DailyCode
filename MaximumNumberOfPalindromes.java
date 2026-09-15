/*
 * Day 22 - LeetCode
 *
 * Problem: Maximum Number of Non-Overlapping Palindromes
 *
 * Given a string s and an integer k, find the maximum number of
 * non-overlapping palindromic substrings of length at least k.
 *
 * Approach:
 * 1. Start from the left and consider each index as the beginning
 *    of a possible palindrome.
 * 2. First check the substring of length k.
 * 3. If it is a palindrome, select it immediately because choosing
 *    the shortest valid palindrome leaves maximum space for others.
 * 4. Otherwise, check the substring of length k + 1.
 * 5. When a palindrome is found, count it and skip all its characters.
 * 6. Continue until there are fewer than k characters remaining.
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(1)
 *
 * Date Solved: 15 September 2026
 */

class Solution {

    public int maxPalindromes(String s, int k) {
        int n = s.length();

        if (k == 1) {
            return n;
        }

        int result = 0;

        for (int i = 0; i <= n - k; i++) {

            // Check palindrome of length k
            if (isPalindrome(s, i, i + k - 1)) {
                result++;
                i += k - 1;
            }

            // Check palindrome of length k + 1
            else if (i < n - k && isPalindrome(s, i, i + k)) {
                result++;
                i += k;
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
