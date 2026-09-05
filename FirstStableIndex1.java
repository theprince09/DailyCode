/*
 * Day 12 - LeetCode
 *
 * Problem: First Stable Index
 *
 * Given an integer array nums and an integer k, find the first index
 * that satisfies the stability condition.
 *
 * Approach:
 * 1. Maintain the maximum value seen so far using maxSoFar.
 * 2. Keep cand as the current candidate for the first stable index.
 * 3. When we reach the candidate index, store the maximum value of
 *    that prefix in cmax.
 * 4. If the current value is smaller than (cmax - k), the current
 *    candidate cannot be valid.
 * 5. Move the candidate to i + 1 and continue.
 * 6. At the end, return cand if it is a valid index; otherwise return -1.
 *
 * This approach avoids the suffix minimum array used in the previous
 * solution and achieves constant extra space.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 5 September 2026
 */

class Solution {

    public int firstStableIndex(int[] nums, int k) {

        int maxSoFar = -1;

        int candidate = 0;
        int candidateMax = 0;

        for (int i = 0; i < nums.length; i++) {

            // Maximum value seen so far
            maxSoFar = Math.max(maxSoFar, nums[i]);

            // When we reach the current candidate,
            // store the maximum of its prefix.
            if (i == candidate) {
                candidateMax = maxSoFar;
            }

            /*
             * If the current value is too small compared to the
             * maximum of the candidate's prefix, this candidate
             * cannot be stable.
             */
            if (nums[i] < candidateMax - k) {
                candidate = i + 1;
            }
        }

        return candidate < nums.length ? candidate : -1;
    }
}
