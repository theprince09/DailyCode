/*
 * Day 26 - LeetCode
 *
 * Problem: Circle and Rectangle Overlapping
 *
 * Given a circle with radius r and center (cx, cy), and an
 * axis-aligned rectangle with bottom-left corner (x1, y1) and
 * top-right corner (x2, y2), determine whether they overlap.
 *
 * Approach:
 * 1. Find the point on the rectangle that is closest to the
 *    center of the circle.
 * 2. For the x-coordinate, clamp cx between x1 and x2.
 * 3. For the y-coordinate, clamp cy between y1 and y2.
 * 4. Calculate the squared distance between the closest point
 *    and the circle's center.
 * 5. The circle and rectangle overlap if this distance is less
 *    than or equal to r².
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Date Solved: 19 September 2026
 */

class Solution {

    public boolean checkOverlap(
            int r,
            int cx,
            int cy,
            int x1,
            int y1,
            int x2,
            int y2) {

        // Find the closest point on the rectangle to the circle center.
        int x = Math.max(x1, Math.min(cx, x2)) - cx;
        int y = Math.max(y1, Math.min(cy, y2)) - cy;

        // Compare squared distance with squared radius.
        return x * x + y * y <= r * r;
    }
}
