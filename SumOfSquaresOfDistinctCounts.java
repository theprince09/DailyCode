import java.util.*;

class Solution {
    /*
     * Day 52 - LeetCode
     * Problem: Sum of Counts of Subarrays
     *
     * Approach:
     * 1. Fix each index i as the starting point.
     * 2. Use a HashSet to track distinct elements as the subarray grows.
     * 3. For each subarray, add the square of its distinct count.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * Date Solved: 15 October 2026
     */

    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();

        // Every index can be the start of a subarray
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();

            // Expand the subarray to the right
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));

                int count = set.size();
                ans += count * count;
            }
        }

        return ans;
    }
}
