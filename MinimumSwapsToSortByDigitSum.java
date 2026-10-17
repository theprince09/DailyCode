import java.util.*;

class Solution {

    /*
     * Problem: Minimum Swaps to Sort by Digit Sum
     *
     * Approach:
     * 1. Calculate the digit sum of every number.
     * 2. Sort indices by digit sum, breaking ties by numeric value.
     * 3. Build targetPos to map each original index to its sorted position.
     * 4. Count cycles in the resulting permutation.
     * 5. Minimum swaps = n - number of cycles.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     *
     * Date Solved: 17 October 2026
     */

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digitSum = new int[n];

        // Calculate the digit sum of each number.
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int sum = 0;

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            digitSum[i] = sum;
        }

        // Initialize original indices.
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices by digit sum, then by number value.
        Arrays.sort(indices, (a, b) -> {
            if (digitSum[a] != digitSum[b]) {
                return Integer.compare(digitSum[a], digitSum[b]);
            }

            return Integer.compare(nums[a], nums[b]);
        });

        // Map each original index to its target sorted position.
        int[] targetPos = new int[n];

        for (int pos = 0; pos < n; pos++) {
            targetPos[indices[pos]] = pos;
        }

        // Count cycles in the permutation.
        boolean[] visited = new boolean[n];
        int cycles = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;

                while (!visited[j]) {
                    visited[j] = true;
                    j = targetPos[j];
                }
            }
        }

        return n - cycles;
    }
}
