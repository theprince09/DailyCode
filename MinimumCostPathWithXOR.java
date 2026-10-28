import java.util.*;

class Solution {

    /*
     * Day 64 - LeetCode
     * Problem: Minimum Cost Path With XOR
     *
     * Approach:
     * 1. Start DFS from the top-left cell with XOR = 0.
     * 2. XOR the current cell's value into the running XOR.
     * 3. Explore paths by moving right or down.
     * 4. Memoize results using (row, column, current XOR).
     * 5. Return the minimum final XOR among valid paths.
     *
     * Time Complexity: O(n * m * 1024)
     * Space Complexity: O(n * m * 1024)
     *
     * Date Solved: 28 October 2026
     */

    private int n, m;
    private int[][][] dp;

    private int dfs(int i, int j, int xor, int[][] grid) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        xor ^= grid[i][j];

        if (i == n - 1 && j == m - 1) {
            return xor;
        }

        if (dp[i][j][xor] != -1) {
            return dp[i][j][xor];
        }

        int right = dfs(i, j + 1, xor, grid);
        int down = dfs(i + 1, j, xor, grid);

        return dp[i][j][xor] = Math.min(right, down);
    }

    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new int[n][m][1024];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, 0, 0, grid);
    }
}
