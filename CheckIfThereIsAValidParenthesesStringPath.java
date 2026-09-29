/*
 * Day 36 - LeetCode
 *
 * Problem: Check if There Is a Valid Parentheses String Path
 *
 * Given an m x n grid containing '(' and ')', determine whether
 * there exists a path from the top-left cell to the bottom-right
 * cell such that:
 *
 * 1. The path only moves right or down.
 * 2. The characters along the path form a valid parentheses string.
 *
 * Approach:
 * 1. Maintain `balance`:
 *      '(' -> balance + 1
 *      ')' -> balance - 1
 * 2. Use DFS with memoization to avoid solving the same
 *    (row, column, balance) state repeatedly.
 * 3. Prune immediately if:
 *      - balance < 0
 *      - balance is greater than the number of cells remaining
 * 4. At the bottom-right cell, the balance must be exactly 0.
 * 5. From each cell, try moving down or right.
 *
 * Important:
 * A valid parentheses path must have an even number of cells,
 * because every '(' needs a matching ')'.
 *
 * Time Complexity: O(m * n * (m + n))
 * Space Complexity: O(m * n * (m + n))
 *
 * Date Solved: 29 September 2026
 */

import java.util.*;

class Solution {

    // Memoization:
    // key = row, column and current balance
    private Boolean[][][] memo;

    private int m;
    private int n;
    private char[][] grid;

    public boolean hasValidPath(char[][] grid) {

        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        // Total path length = m + n - 1.
        // A valid parentheses string must have even length.
        if ((m + n) % 2 == 0) {
            return false;
        }

        // The path must start with '('.
        if (grid[0][0] == ')') {
            return false;
        }

        // The path must end with ')'.
        if (grid[m - 1][n - 1] == '(') {
            return false;
        }

        memo = new Boolean[m][n][m + n];

        return dfs(0, 0, 0);
    }

    private boolean dfs(int row, int col, int balance) {

        // Update balance using the current cell.
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid prefix.
        if (balance < 0) {
            return false;
        }

        // Number of cells remaining after the current cell.
        int remaining = (m - row - 1) + (n - col - 1);

        /*
         * Even if every remaining cell is ')', we need enough
         * cells to bring the balance back to zero.
         */
        if (balance > remaining) {
            return false;
        }

        // Reached the destination.
        if (row == m - 1 && col == n - 1) {
            return balance == 0;
        }

        if (memo[row][col][balance] != null) {
            return memo[row][col][balance];
        }

        boolean possible = false;

        // Move down.
        if (row < m - 1) {
            possible = dfs(row + 1, col, balance);
        }

        // Move right.
        if (!possible && col < n - 1) {
            possible = dfs(row, col + 1, balance);
        }

        memo[row][col][balance] = possible;

        return possible;
    }
}
