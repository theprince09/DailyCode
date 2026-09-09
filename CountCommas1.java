/*
 * Day 16 - LeetCode
 *
 * Problem: Count Commas
 *
 * Given an integer n, count the total number of commas that appear
 * when writing all integers from 1 to n using standard decimal notation.
 *
 * Example:
 * Numbers from 1 to 999:
 *     0 commas
 *
 * Numbers from 1000 to 999999:
 *     1 comma each
 *
 * Numbers from 1000000 onward:
 *     2 commas each
 *
 * Approach:
 * 1. Numbers below 1000 do not contain any commas.
 * 2. Process numbers in ranges based on their number of commas:
 *
 *    1000 - 999999999       -> 1 comma
 *    1000000 - 999999999999 -> 2 commas
 *    and so on.
 *
 * 3. For each range, calculate how many numbers are present.
 * 4. Multiply the number of values by the number of commas in that range.
 * 5. Move to the next range by multiplying the range boundaries by 1000.
 *
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 *
 * Date Solved: 9 September 2026
 */

class Solution {

    public long countCommas(long n) {

        // Numbers up to 999 contain no commas
        if (n <= 999) {
            return 0;
        }

        long totalCommas = 0;

        // Start of the first comma range
        long rangeStart = 1000;

        // End of the current range
        long rangeEnd = rangeStart * 1000 - 1;

        // Number of commas in the current range
        int commas = 1;

        while (rangeStart <= n) {

            // Number of values present in this range
            long numbers =
                    Math.min(n, rangeEnd) - rangeStart + 1;

            // Add total commas contributed by this range
            totalCommas += (long) commas * numbers;

            // If the current range already reaches n,
            // there is nothing more to process.
            if (rangeEnd > n) {
                break;
            }

            // Move to the next comma range
            rangeStart = rangeStart * 1000;
            rangeEnd = rangeStart * 1000 - 1;

            commas++;
        }

        return totalCommas;
    }
}
