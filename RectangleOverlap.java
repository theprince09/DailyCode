/*
 * Day 21 - LeetCode
 *
 * Problem: Rectangle Overlap
 *
 * Given two axis-aligned rectangles, determine whether they overlap.
 * Rectangles that only touch at their edge or corner are NOT considered
 * to overlap.
 *
 * Approach:
 * 1. Let the first rectangle be (x1, y1, x2, y2).
 * 2. Let the second rectangle be (X1, Y1, X2, Y2).
 * 3. Two rectangles overlap only if:
 *      - The left edge of one is before the right edge of the other.
 *      - The left edge of the other is before the right edge of the first.
 *      - The bottom edge of one is below the top edge of the other.
 *      - The bottom edge of the other is below the top edge of the first.
 * 4. All four conditions must be true.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Date Solved: 14 September 2026
 */

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int X1 = rec2[0];
        int Y1 = rec2[1];
        int X2 = rec2[2];
        int Y2 = rec2[3];

        return x1 < X2
                && X1 < x2
                && y1 < Y2
                && Y1 < y2;
    }
}
