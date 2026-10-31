class Solution {

    /*
     * Day 68 - LeetCode
     * Problem: Unique Paths
     *
     * Approach:
     * 1. Use a 1D DP array to store path counts.
     * 2. Initialize dp[0] = 1.
     * 3. Process each cell using its top and left path counts.
     * 4. Use a transition matrix based on the cell value.
     * 5. Update the DP values modulo 10^9 + 7.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     *
     * Date Solved: 31 October 2026
     */

    private static final int MOD = 1_000_000_007;

    private static final int[][][] MAT = {
        {
            {1, 1},
            {1, 1}
        },
        {
            {0, 1},
            {1, 0}
        }
    };

    public int uniquePaths(int[][] A) {
        int n = A[0].length;
        int left = 0;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int[] row : A) {
            left = 0;

            for (int j = 0; j < n; j++) {
                int top = dp[j];
                int c = row[j];

                dp[j] = (int) (
                    ((long) left * MAT[c][1][0]
                    + (long) top * MAT[c][1][1]) % MOD
                );

                left = (int) (
                    ((long) left * MAT[c][0][0]
                    + (long) top * MAT[c][0][1]) % MOD
                );
            }
        }

        return left;
    }
}
