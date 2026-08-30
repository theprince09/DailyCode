/*
 * Day 6 - LeetCode
 *
 * Problem: Lexicographically Smallest Array by Swapping Elements
 *
 * Given an integer array nums and an integer limit, we can swap two
 * elements if their absolute difference is less than or equal to limit.
 *
 * Return the lexicographically smallest array that can be obtained
 * using any number of valid swaps.
 *
 * Approach:
 * 1. Create a sorted copy of the original array.
 * 2. In the sorted array, divide elements into groups.
 * 3. Two consecutive elements belong to the same group if their
 *    difference is <= limit.
 * 4. All elements within the same group can be rearranged freely.
 * 5. Store which group each value belongs to.
 * 6. Traverse the original array from left to right.
 * 7. For each element, take the smallest unused value from its group.
 *
 * Why this works:
 * If consecutive sorted elements differ by at most limit, they can be
 * connected through valid swaps. Therefore, all elements in that group
 * can be rearranged among their original positions.
 *
 * Example:
 * nums = [1, 5, 3, 9, 8]
 * limit = 2
 *
 * Sorted = [1, 3, 5, 8, 9]
 *
 * Groups:
 * [1, 3, 5] and [8, 9]
 *
 * We assign the smallest available value from each group to the
 * corresponding positions in the original array.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 * Date Solved: 29 August 2026
 */

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        // Create a sorted copy
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Store groups of values
        List<List<Integer>> groups = new ArrayList<>();

        // Map each value to its group
        Map<Integer, Integer> groupMap = new HashMap<>();

        int groupId = -1;

        // Create groups based on the limit
        for (int i = 0; i < sorted.length; i++) {

            if (i == 0 || sorted[i] - sorted[i - 1] > limit) {
                groups.add(new ArrayList<>());
                groupId++;
            }

            groups.get(groupId).add(sorted[i]);
            groupMap.put(sorted[i], groupId);
        }

        // Pointer to the next unused element in each group
        int[] index = new int[groups.size()];

        // Replace each element with the smallest available
        // element from its corresponding group
        for (int i = 0; i < nums.length; i++) {

            int currentGroup = groupMap.get(nums[i]);

            nums[i] = groups.get(currentGroup).get(index[currentGroup]);

            index[currentGroup]++;
        }

        return nums;
    }
}
