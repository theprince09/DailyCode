/*
 * Day 2 - LeetCode
 *
 * Problem: Missing Multiple
 *
 * Given an integer array nums and an integer k, find the smallest
 * positive multiple of k that does not exist in nums.
 *
 * Approach:
 * 1. Check all numbers in nums that are divisible by k.
 * 2. Store their corresponding multiples (num / k) in a HashSet.
 * 3. Start checking from the first positive multiple (1 * k).
 * 4. Return the first multiple of k that is not present.
 *
 * Example:
 * nums = [8, 2, 3, 4, 6], k = 2
 *
 * Multiples of 2 present: 1, 2, 3, 4
 * Missing multiple: 5 * 2 = 10
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Date Solved: 25 August 2026
 */

import java.util.HashSet;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        // Store the multiples of k
        for (int num : nums) {
            if (num % k == 0) {
                set.add(num / k);
            }
        }

        // Find the first missing positive multiple
        int i = 1;

        while (true) {
            if (!set.contains(i)) {
                return i * k;
            }
            i++;
        }
    }
}
