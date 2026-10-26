class Solution {

    /*
     * Day 62 - LeetCode
     * Problem: Count Islands With Sum Divisible by K
     *
     * Approach:
     * 1. Treat every grid cell as a DSU node.
     * 2. Initialize each cell's component sum with its grid value.
     * 3. Union adjacent positive cells horizontally and vertically.
     * 4. Merge component sums whenever two components are joined.
     * 5. Count land-component roots whose sum is divisible by k.
     *
     * Time Complexity: O(m * n * α(m * n))
     * Space Complexity: O(m * n)
     *
     * Date Solved: 26 October 2026
     */

    private int[] parent;
    private int[] rank;
    private long[] sum;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        // Union by rank.
        if (rank[rootX] > rank[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parent[rootX] = rootY;
        sum[rootY] += sum[rootX];

        if (rank[rootX] == rank[rootY]) {
            rank[rootY]++;
        }
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        parent = new int[total];
        rank = new int[total];
        sum = new long[total];

        // Initialize every cell as its own component.
        for (int i = 0; i < total; i++) {
            parent[i] = i;
            sum[i] = grid[i / n][i % n];
        }

        // Connect adjacent land cells.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int current = i * n + j;

                // Connect to the right.
                if (j + 1 < n && grid[i][j + 1] > 0) {
                    union(current, current + 1);
                }

                // Connect to the cell below.
                if (i + 1 < m && grid[i + 1][j] > 0) {
                    union(current, current + n);
                }
            }
        }

        // Count land components whose total sum is divisible by k.
        int count = 0;

        for (int i = 0; i < total; i++) {
            int row = i / n;
            int col = i % n;

            // Ignore water cells, even if their sum is divisible by k.
            if (grid[row][col] > 0 && find(i) == i
                    && sum[i] % k == 0) {
                count++;
            }
        }

        return count;
    }
}
