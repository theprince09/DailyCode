import java.util.*;

class Solution {

    /*
     * Day 67 - LeetCode
     * Problem: Shortest Path
     *
     * Approach:
     * 1. Build an adjacency list using the given edges.
     * 2. Use a min-priority queue to process states by distance.
     * 3. Track (distance, consecutiveRun, node) for each state.
     * 4. If the next node has the same label, increment the run.
     * 5. Otherwise, reset the run to 1.
     * 6. Use best[] to avoid processing states dominated by
     *    a shorter or equal run.
     * 7. Return the distance when the destination is reached.
     *
     * Time Complexity: O((n + E) log(n + E))
     * Space Complexity: O(n + E)
     *
     * Date Solved: 30 October 2026
     */

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        // Build adjacency list.
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(
                new int[]{edge[1], edge[2]}
            );
        }

        // best[node] stores the smallest run length settled so far.
        int[] best = new int[n];
        Arrays.fill(best, k + 1);

        // State: {distance, consecutiveRun, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        pq.offer(new long[]{0, 1, 0});

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            long distance = current[0];
            int run = (int) current[1];
            int node = (int) current[2];

            // Skip a dominated state.
            if (run >= best[node]) {
                continue;
            }

            // Destination reached.
            if (node == n - 1) {
                return (int) distance;
            }

            best[node] = run;

            // Explore neighboring nodes.
            for (int[] edge : graph[node]) {

                int next = edge[0];
                int weight = edge[1];

                int nextRun = labels.charAt(next)
                        == labels.charAt(node)
                        ? run + 1
                        : 1;

                if (nextRun < best[next]) {
                    pq.offer(new long[]{
                        distance + weight,
                        nextRun,
                        next
                    });
                }
            }
        }

        return -1;
    }
}
