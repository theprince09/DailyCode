import java.util.*;

class Solution {

    /*
     * Day 55 - LeetCode
     * Problem: Number of Ways to Reorder Array to Get Same BST
     *
     * Approach:
     * 1. Treat the first element as the BST root.
     * 2. Divide remaining elements into left and right subtrees.
     * 3. Recursively calculate valid reorderings for both subtrees.
     * 4. Use combinations to count ways to interleave left and right elements.
     * 5. Subtract 1 to exclude the original ordering.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     *
     * Date Solved: 18 October 2026
     */

    private static final int MOD = 1_000_000_007;
    private long[][] comb;

    // Precompute combinations using Pascal's triangle.
    private void buildCombinations(int n) {
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;

            for (int j = 1; j <= i; j++) {
                comb[i][j] = (
                    comb[i - 1][j - 1]
                    + comb[i - 1][j]
                ) % MOD;
            }
        }
    }

    private long solve(List<Integer> nums) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partition elements according to the BST root.
        for (int i = 1; i < n; i++) {
            int value = nums.get(i);

            if (value > root) {
                right.add(value);
            } else {
                left.add(value);
            }
        }

        long leftWays = solve(left);
        long rightWays = solve(right);

        // Interleave left and right elements while preserving
        // the relative order within each subtree.
        long interleavings = comb[n - 1][left.size()];

        return (((interleavings * leftWays) % MOD)
                * rightWays) % MOD;
    }

    public int numOfWays(int[] nums) {
        buildCombinations(nums.length);

        List<Integer> values = new ArrayList<>();
        for (int num : nums) {
            values.add(num);
        }

        // Exclude the original ordering.
        return (int) ((solve(values) - 1 + MOD) % MOD);
    }
}
