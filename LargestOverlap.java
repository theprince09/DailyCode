/*
 * Day 20 - LeetCode
 *
 * Problem: Image Overlap
 *
 * Given two binary matrices img1 and img2 of the same size, find the
 * maximum number of positions where both matrices contain 1 after
 * translating one matrix over the other.
 *
 * The matrices cannot be rotated.
 *
 * Approach:
 * 1. Represent every row of the matrix as a bitmask.
 * 2. Try every possible vertical shift.
 * 3. For every vertical shift, try every possible horizontal shift.
 * 4. Shift the corresponding row bitmask and perform a bitwise AND
 *    with the row of the other image.
 * 5. Count the number of set bits using Long.bitCount().
 * 6. Keep track of the maximum overlap.
 *
 * Since the matrix size is at most 30, all rows fit inside a long.
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 *
 * Date Solved: 13 September 2026
 */

class Solution {

    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        // Store each row as a bitmask
        long[] rows1 = new long[n];
        long[] rows2 = new long[n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {
                    rows1[i] |= (1L << j);
                }

                if (img2[i][j] == 1) {
                    rows2[i] |= (1L << j);
                }
            }
        }

        int answer = 0;

        /*
         * Try every vertical shift.
         *
         * shift = negative -> move img1 upward
         * shift = positive -> move img1 downward
         */
        for (int vertical = -n + 1; vertical < n; vertical++) {

            /*
             * Try every horizontal shift.
             *
             * shift = negative -> move left
             * shift = positive -> move right
             */
            for (int horizontal = -n + 1;
                 horizontal < n;
                 horizontal++) {

                int count = 0;

                for (int row = 0; row < n; row++) {

                    int shiftedRow = row + vertical;

                    // Row is outside the matrix after shifting
                    if (shiftedRow < 0 || shiftedRow >= n) {
                        continue;
                    }

                    long shiftedBits;

                    if (horizontal < 0) {
                        // Shift left
                        shiftedBits =
                                rows1[shiftedRow] << (-horizontal);
                    } else {
                        // Shift right
                        shiftedBits =
                                rows1[shiftedRow] >> horizontal;
                    }

                    // Count overlapping 1s
                    count += Long.bitCount(
                            shiftedBits & rows2[row]
                    );
                }

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}
