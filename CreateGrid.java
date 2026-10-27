class Solution {

    /*
     * Day 63 - LeetCode
     * Problem: Create Grid
     *
     * Approach:
     * 1. Initialize an m x n grid filled with '#'.
     * 2. Replace every cell in the top row with '.'.
     * 3. Replace every cell in the rightmost column with '.'.
     * 4. Return the resulting grid as a list of strings.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * Date Solved: 27 October 2026
     */

    public List<String> createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        // Fill the grid with '#'.
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        // Mark the top row with '.'.
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        // Mark the rightmost column with '.'.
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        // Convert each row into a String.
        List<String> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            result.add(new String(grid[i]));
        }

        return result;
    }
}
