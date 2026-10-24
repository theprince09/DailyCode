class Solution {

    /*
     * Day 60 - LeetCode
     * Problem: Count Days Spent Together
     *
     * Approach:
     * 1. Convert each MM-DD date into a numeric day value.
     * 2. Find the later arrival date using Math.max().
     * 3. Find the earlier departure date using Math.min().
     * 4. Calculate the overlap, including both boundary days.
     * 5. Return 0 if the date ranges do not overlap.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * Date Solved: 24 October 2026
     */

    public int countDaysTogether(
            String arriveAlice,
            String leaveAlice,
            String arriveBob,
            String leaveBob) {

        int start = Math.max(f(arriveAlice), f(arriveBob));
        int end = Math.min(f(leaveAlice), f(leaveBob));

        return Math.max(0, end - start + 1);
    }

    // Convert MM-DD into a comparable numeric day value.
    private int f(String s) {
        int month = (s.charAt(0) - '0') * 10
                  + (s.charAt(1) - '0');

        int day = (s.charAt(3) - '0') * 10
                + (s.charAt(4) - '0');

        return (275 * month) / 9
             - 30
             - 2 * ((month + 9) / 12)
             + day;
    }
}
