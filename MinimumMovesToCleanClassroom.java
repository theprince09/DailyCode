/*
 * Day 9 - LeetCode
 *
 * Problem: Minimum Moves to Clean the Classroom
 *
 * Given a classroom grid:
 *
 * 'S' -> Starting position
 * 'L' -> Litter that needs to be collected
 * 'R' -> Recharge station
 * 'X' -> Blocked cell
 * '.' -> Empty cell
 *
 * Moving to an adjacent cell costs 1 unit of energy.
 * The player cannot move when energy becomes 0.
 *
 * Whenever the player reaches an 'R' cell, their energy is restored
 * to the initial energy value.
 *
 * Return the minimum number of moves required to collect all litter.
 * If it is impossible, return -1.
 *
 * Approach:
 * 1. Find the starting position and all litter positions.
 * 2. Assign a unique index to every litter item.
 * 3. Use a bitmask to keep track of collected litter.
 *
 *    Example:
 *    If there are 3 litter items:
 *
 *    000 -> none collected
 *    001 -> first collected
 *    101 -> first and third collected
 *    111 -> all collected
 *
 * 4. Use BFS because every movement has the same cost (1).
 * 5. The BFS state contains:
 *
 *    (row, column, current energy, collected litter mask)
 *
 * 6. For every neighboring cell:
 *    - Decrease energy by 1.
 *    - Collect litter if the destination is 'L'.
 *    - Restore energy if the destination is 'R'.
 *    - Add the new state to the queue if it has not been visited.
 *
 * 7. As soon as the mask contains all litter items, return the number
 *    of moves.
 *
 * Time Complexity: O(R * C * energy * 2^L)
 *
 * Space Complexity: O(R * C * energy * 2^L)
 *
 * Where:
 * R = number of rows
 * C = number of columns
 * L = number of litter items
 *
 * Date Solved: 1 September 2026
 */

import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int rows = classroom.length;
        int cols = classroom[0].length;

        int startRow = -1;
        int startCol = -1;

        // Store litter coordinates
        List<int[]> litterCoordinates = new ArrayList<>();

        // Map each litter coordinate to its bit index
        Map<String, Integer> litterMap = new HashMap<>();

        // Find starting position and litter
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                char cell = classroom[r].charAt(c);

                if (cell == 'S') {
                    startRow = r;
                    startCol = c;

                } else if (cell == 'L') {

                    int index = litterCoordinates.size();

                    litterCoordinates.add(new int[]{r, c});
                    litterMap.put(r + "," + c, index);
                }
            }
        }

        int litterCount = litterCoordinates.size();

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        // Mask where all litter items are collected
        int targetMask = (1 << litterCount) - 1;

        /*
         * dist[row][col][energy][mask]
         *
         * Stores the minimum number of moves required to reach
         * a particular state.
         */
        int[][][][] dist = new int[
                rows
        ][
                cols
        ][
                energy + 1
        ][
                1 << litterCount
        ];

        // Initialize all states to -1
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int e = 0; e <= energy; e++) {
                    Arrays.fill(dist[r][c][e], -1);
                }
            }
        }

        // BFS state: row, column, energy, collected mask
        Queue<int[]> queue = new LinkedList<>();

        dist[startRow][startCol][energy][0] = 0;

        queue.offer(new int[]{
                startRow,
                startCol,
                energy,
                0
        });

        while (!queue.isEmpty()) {

            int[] state = queue.poll();

            int r = state[0];
            int c = state[1];
            int currentEnergy = state[2];
            int mask = state[3];

            int moves = dist[r][c][currentEnergy][mask];

            // All litter collected
            if (mask == targetMask) {
                return moves;
            }

            // Try all four directions
            for (int direction = 0; direction < 4; direction++) {

                int nr = r + dr[direction];
                int nc = c + dc[direction];

                // Check boundaries and blocked cells
                if (nr < 0 || nr >= rows
                        || nc < 0 || nc >= cols
                        || classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Cannot move without energy
                if (currentEnergy == 0) {
                    continue;
                }

                // Moving costs one unit of energy
                int newEnergy = currentEnergy - 1;

                int newMask = mask;

                char destination = classroom[nr].charAt(nc);

                // Collect litter
                if (destination == 'L') {

                    int litterIndex =
                            litterMap.get(nr + "," + nc);

                    newMask |= (1 << litterIndex);
                }

                // Recharge energy
                if (destination == 'R') {
                    newEnergy = energy;
                }

                // Visit the new state if not visited
                if (dist[nr][nc][newEnergy][newMask] == -1) {

                    dist[nr][nc][newEnergy][newMask] =
                            moves + 1;

                    queue.offer(new int[]{
                            nr,
                            nc,
                            newEnergy,
                            newMask
                    });
                }
            }
        }

        // Impossible to collect all litter
        return -1;
    }
}
