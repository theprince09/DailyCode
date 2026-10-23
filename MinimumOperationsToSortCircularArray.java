class Solution {

    /*
     * Day 59 - LeetCode
     * Problem: Minimum Operations to Sort a Circular Array
     *
     * Approach:
     * 1. Count consecutive ascending circular values.
     * 2. Count consecutive descending circular values.
     * 3. If ascending, calculate the answer using the first element.
     * 4. If descending, calculate the answer using the last element.
     * 5. If neither pattern holds, return -1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Date Solved: 23 October 2026
     */

    public int minOperations(int[] A) {
        int n = A.length;
        int asc = 1;
        int dsc = 1;

        for (int i = 1; i < n; i++) {
            if (A[i] == (A[i - 1] + 1) % n) {
                asc++;
            }

            if (A[i - 1] == (A[i] + 1) % n) {
                dsc++;
            }
        }

        // The array follows a circular ascending sequence.
        if (asc == n) {
            return A[0] == 0
                    ? 0
                    : Math.min(n - A[0], A[0] + 2);
        }

        // The array follows a circular descending sequence.
        if (dsc == n) {
            return Math.min(n - A[n - 1], A[n - 1]) + 1;
        }

        return -1;
    }
}
