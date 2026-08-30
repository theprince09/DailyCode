/*
 * Day 7 - LeetCode
 *
 * Problem: Minimum Deletions to Remove Minimum and Maximum
 *
 * Given an integer array nums, remove the minimum number of elements
 * from either the beginning or the end of the array so that both the
 * minimum and maximum elements are removed.
 *
 * Approach:
 * 1. Find the indices of the minimum and maximum elements.
 * 2. Let left be the smaller index and right be the larger index.
 * 3. There are three possible ways to remove both elements:
 *
 *    Case 1: Remove both from the front.
 *            Deletions = right + 1
 *
 *    Case 2: Remove both from the back.
 *            Deletions = n - left
 *
 *    Case 3: Remove the minimum from the front and maximum from the back
 *            (or vice versa).
 *            Deletions = (left + 1) + (n - right)
 *
 * 4. Return the minimum of these three possibilities.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 30 August 2026
 */

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        // Find indices of minimum and maximum elements
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // left = smaller index, right = larger index
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Remove both elements from the front
        int front = right + 1;

        // Remove both elements from the back
        int back = n - left;

        // Remove one element from each side
        int frontBack = (left + 1) + (n - right);

        return Math.min(front, Math.min(back, frontBack));
    }
}
