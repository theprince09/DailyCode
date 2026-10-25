class Solution {

    /*
     * Day 61 - LeetCode
     * Problem: Number of Closed Islands
     *
     * Approach:
     * 1. Traverse every cell in the grid.
     * 2. When unvisited land (0) is found, run DFS.
     * 3. Mark visited land as water (1) to avoid revisiting it.
     * 4. If the DFS reaches outside the grid, the island is not closed.
     * 5. Count islands whose DFS never reaches the boundary.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n) worst case due to recursion.
     *
     * Date Solved: 25 October 2026
     */

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j, m, n)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int i, int j, int m, int n) {
        // Reaching outside the grid means the island touches the border.
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        // Water or already visited land.
        if (grid[i][j] == 1) {
            return true;
        }

        // Mark this land cell as visited.
        grid[i][j] = 1;

        // Use bitwise &: all four DFS calls must execute.
        boolean down = dfs(grid, i + 1, j, m, n);
        boolean up = dfs(grid, i - 1, j, m, n);
        boolean right = dfs(grid, i, j + 1, m, n);
        boolean left = dfs(grid, i, j - 1, m, n);

        return down & up & right & left;
    }
}
