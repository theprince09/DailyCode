import java.util.*;

class Solution {

    /*
     * Day 53 - LeetCode
     * Problem: Subarrays Distinct Element Sum of Squares II
     *
     * Approach:
     * 1. Use a segment tree to store sums of distinct counts and
     *    sums of their squares for subarrays ending at each index.
     * 2. Use lastSeen to find where the current element adds a
     *    new distinct element to existing subarrays.
     * 3. Apply range increments with lazy propagation.
     * 4. Add the root's squared-count sum to the answer at each step.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     *
     * Date Solved: 16 October 2026
     */

    private static final int MOD = 1_000_000_007;

    private static class SegmentTree {
        private final int[] cnt;
        private final int[] sqCnt;
        private final int[] lazy;
        private final int n;

        SegmentTree(int n) {
            this.n = n;
            cnt = new int[4 * n];
            sqCnt = new int[4 * n];
            lazy = new int[4 * n];
        }

        // Apply an increment to every value in [left, right].
        private void apply(int node, int left, int right, int x) {
            long len = right - left + 1L;

            // Update squared sum using the old normal sum.
            sqCnt[node] = (int) (
                (sqCnt[node]
                    + 2L * x * cnt[node]
                    + 1L * x * x % MOD * len) % MOD
            );

            // Update the normal sum.
            cnt[node] = (int) (
                (cnt[node] + len * x) % MOD
            );

            lazy[node] = (int) ((lazy[node] + (long) x) % MOD);
        }

        // Push pending updates to the children.
        private void push(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;
            int x = lazy[node];

            apply(node * 2, left, mid, x);
            apply(node * 2 + 1, mid + 1, right, x);

            lazy[node] = 0;
        }

        // Combine the results from both children.
        private void merge(int node) {
            cnt[node] = (int) (
                (cnt[node * 2] + (long) cnt[node * 2 + 1]) % MOD
            );

            sqCnt[node] = (int) (
                (sqCnt[node * 2] + (long) sqCnt[node * 2 + 1]) % MOD
            );
        }

        // Add 1 to every element in the range [ql, qr].
        private void update(
            int node, int left, int right, int ql, int qr
        ) {
            if (qr < left || right < ql) {
                return;
            }

            if (ql <= left && right <= qr) {
                apply(node, left, right, 1);
                return;
            }

            push(node, left, right);

            int mid = left + (right - left) / 2;

            update(node * 2, left, mid, ql, qr);
            update(node * 2 + 1, mid + 1, right, ql, qr);

            merge(node);
        }

        void update(int left, int right) {
            if (left <= right) {
                update(1, 0, n - 1, left, right);
            }
        }

        int getSquaredSum() {
            return sqCnt[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long ans = 0;

        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int start = lastSeen.containsKey(nums[i])
                ? lastSeen.get(nums[i]) + 1
                : 0;

            lastSeen.put(nums[i], i);

            // Update distinct counts for all affected subarrays.
            tree.update(start, i);

            // Sum of squares for all subarrays ending at i.
            ans = (ans + tree.getSquaredSum()) % MOD;
        }

        return (int) ans;
    }
}
