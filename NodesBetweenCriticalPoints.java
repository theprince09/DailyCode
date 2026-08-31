/*
 * Day 8 - LeetCode
 *
 * Problem: Nodes Between Critical Points
 *
 * Given a linked list, a critical point is a local maximum or local
 * minimum. A node is a critical point if its value is either:
 *
 * 1. Greater than both its neighboring nodes, or
 * 2. Smaller than both its neighboring nodes.
 *
 * Return an array containing:
 * - The minimum distance between any two critical points.
 * - The maximum distance between the first and last critical points.
 *
 * If there are fewer than two critical points, return [-1, -1].
 *
 * Approach:
 * 1. Traverse the linked list using three pointers:
 *    prev, curr, and next.
 * 2. Check whether curr is a critical point by comparing it with
 *    its previous and next nodes.
 * 3. Store the position of the first critical point.
 * 4. For every subsequent critical point:
 *    - Calculate the distance from the previous critical point.
 *    - Update the minimum distance.
 * 5. The maximum distance is the difference between the first and
 *    last critical point.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Date Solved: 31 August 2026
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int minDistance = Integer.MAX_VALUE;

        int firstCritical = -1;
        int previousCritical = -1;

        int position = 1;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        while (next != null) {

            // Check if current node is a critical point
            boolean isCritical =
                    (prev.val < curr.val && curr.val > next.val)
                    || (prev.val > curr.val && curr.val < next.val);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = position;
                } else {
                    // Distance from previous critical point
                    minDistance = Math.min(
                            minDistance,
                            position - previousCritical
                    );
                }

                previousCritical = position;
            }

            prev = curr;
            curr = next;
            next = next.next;

            position++;
        }

        // Fewer than two critical points
        if (firstCritical == -1 || previousCritical == firstCritical) {
            return new int[]{-1, -1};
        }

        // Maximum distance = last critical - first critical
        int maxDistance = previousCritical - firstCritical;

        return new int[]{minDistance, maxDistance};
    }
}
