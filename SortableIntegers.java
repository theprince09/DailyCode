class Solution {

    /*
     * Day 57 - LeetCode
     * Problem: Sortable Integers
     *
     * Approach:
     * 1. Count descents to check whether each block is a rotated sorted run.
     * 2. Build prefix maxima and suffix minima.
     * 3. Mark valid cuts where the prefix contains the smallest elements.
     * 4. Check every divisor k of n as a possible block size.
     * 5. Count k if every block satisfies both conditions.
     *
     * Time Complexity: O(sum(n / k) for all divisors k of n)
     * Space Complexity: O(n)
     *
     * Date Solved: 20 October 2026
     */

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        // desc[i] counts descents at positions j < i.
        int[] desc = new int[n];

        for (int i = 1; i < n; i++) {
            desc[i] = desc[i - 1]
                    + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        // Prefix maximums and suffix minimums.
        int[] premax = new int[n];
        int[] sufmin = new int[n];

        premax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            premax[i] = Math.max(premax[i - 1], nums[i]);
        }

        sufmin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sufmin[i] = Math.min(sufmin[i + 1], nums[i]);
        }

        // cut[m] is true if the first m elements
        // contain the m smallest values.
        boolean[] cut = new boolean[n];
        cut[0] = true;

        for (int m = 1; m < n; m++) {
            cut[m] = premax[m - 1] <= sufmin[m];
        }

        // Check whether nums[l..r] is a rotated sorted run.
        // A circular sequence has at most one descent.
        // Using long avoids overflow when comparing extreme integers.
        java.util.function.BiPredicate<Integer, Integer> rotatable =
                (l, r) -> desc[r] - desc[l]
                        + (nums[r] > nums[l] ? 1 : 0) <= 1;

        int ans = 0;

        // Every possible block size must divide n.
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean sortable = true;

            // Validate each block of size k.
            for (int l = 0; l < n; l += k) {
                int r = l + k - 1;

                if (!cut[l] || !rotatable.test(l, r)) {
                    sortable = false;
                    break;
                }
            }

            if (sortable) {
                ans += k;
            }
        }

        return ans;
    }
}
