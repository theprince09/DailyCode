class Solution {

    /*
     * Problem: Minimum Operations to Sort a String
     *
     * Approach:
     * 1. If the string is already sorted, return 0.
     * 2. If its length is 2 and it is not sorted, return -1.
     * 3. Find the minimum and maximum characters in the middle.
     * 4. Use the first, last, and middle characters to determine
     *    whether 1, 2, or 3 operations are required.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Date Solved: 21 October 2026
     */

    public int minOperations(String s) {
        int n = s.length();

        // Check whether the string is already sorted.
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // A reversed string of length 2 cannot be sorted
        // using the allowed operation.
        if (n == 2) {
            return -1;
        }

        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        // Find the minimum and maximum characters in the middle.
        char lo = Character.MAX_VALUE;
        char hi = Character.MIN_VALUE;

        for (int i = 1; i < n - 1; i++) {
            lo = (char) Math.min(lo, s.charAt(i));
            hi = (char) Math.max(hi, s.charAt(i));
        }

        // One operation is sufficient if the first character
        // is the smallest or the last character is the largest.
        if (first <= Math.min(lo, last)
                || Math.max(first, hi) <= last) {
            return 1;
        }

        // Three operations are needed when the middle characters
        // lie strictly between the last and first characters.
        if (last < lo && hi < first) {
            return 3;
        }

        return 2;
    }
}
