import java.util.*;

class Solution {

    /*
     * Day 56 - LeetCode
     * Problem: Find Target Indices After Sorting Array
     *
     * Approach:
     * 1. Count elements smaller than target.
     * 2. Count elements equal to target.
     * 3. Target indices start at the count of smaller elements.
     * 4. Generate consecutive indices for every occurrence of target.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k) for the output, O(1) auxiliary space
     *
     * Date Solved: 19 October 2026
     */

    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0;
        int equal = 0;

        // Count values smaller than and equal to target.
        for (int x : nums) {
            if (x < target) {
                smaller++;
            } else if (x == target) {
                equal++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Target values occupy consecutive positions after sorting.
        for (int i = 0; i < equal; i++) {
            ans.add(smaller + i);
        }

        return ans;
    }
}
