/*
 * Day 29 - LeetCode
 *
 * Problem: Result Array
 *
 * Given an array nums, process queries where each query:
 * 1. Updates one element of the array.
 * 2. Queries the number of subarrays in a given suffix whose
 *    product modulo k equals a specified value x.
 *
 * Approach:
 * 1. Build a segment tree over the array.
 * 2. For every segment, store:
 *      - prod: product of all elements modulo k.
 *      - cnt[r]: number of subarrays inside the segment whose
 *                product modulo k equals r.
 * 3. When merging two child segments:
 *      - Keep all subarrays completely inside the left segment.
 *      - Keep all subarrays completely inside the right segment,
 *        but multiply their product by the product of the left segment.
 * 4. For every update, modify the corresponding leaf and rebuild
 *    the affected path.
 * 5. For every query, combine the relevant segment tree nodes and
 *    return cnt[x].
 *
 * Time Complexity:
 *      Build:  O(n * k)
 *      Update: O(k * log n)
 *      Query:  O(k * log n)
 *
 * Space Complexity: O(n * k)
 *
 * Date Solved: 22 September 2026
 */

class Solution {

    int[] treeProd;
    int[][] treeCnt;
    int K;

    class Node {
        int prod;
        int[] cnt;

        Node() {
            cnt = new int[K];
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        int n = nums.length;
        this.K = k;

        treeProd = new int[4 * n];
        treeCnt = new int[4 * n][k];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Apply the point update.
            update(1, 0, n - 1, index, value);

            // Query the range [start, n - 1].
            Node resNode = query(1, 0, n - 1, start, n - 1);

            result[i] = resNode.cnt[x];
        }

        return result;
    }

    // Build the segment tree.
    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {

            int remainder = nums[left] % K;

            treeProd[node] = remainder;
            treeCnt[node][remainder] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(2 * node, left, mid, nums);
        build(2 * node + 1, mid + 1, right, nums);

        pushUp(node);
    }

    // Merge the left and right children.
    private void pushUp(int node) {

        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        // Product of the complete segment.
        treeProd[node] =
                (treeProd[leftChild] * treeProd[rightChild]) % K;

        // Subarrays completely inside the left segment.
        for (int i = 0; i < K; i++) {
            treeCnt[node][i] = treeCnt[leftChild][i];
        }

        // Subarrays that extend from the left segment into the right.
        for (int i = 0; i < K; i++) {

            if (treeCnt[rightChild][i] > 0) {

                int newRemainder =
                        (treeProd[leftChild] * i) % K;

                treeCnt[node][newRemainder] +=
                        treeCnt[rightChild][i];
            }
        }
    }

    // Point update.
    private void update(
            int node,
            int left,
            int right,
            int index,
            int value) {

        if (left == right) {

            int remainder = value % K;

            treeProd[node] = remainder;

            // Clear the old counts.
            for (int i = 0; i < K; i++) {
                treeCnt[node][i] = 0;
            }

            treeCnt[node][remainder] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(2 * node, left, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, right, index, value);
        }

        // Recalculate this node after the update.
        pushUp(node);
    }

    // Range query.
    private Node query(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight) {

        // Complete segment is inside the query range.
        if (queryLeft <= left && right <= queryRight) {

            Node result = new Node();

            result.prod = treeProd[node];

            for (int i = 0; i < K; i++) {
                result.cnt[i] = treeCnt[node][i];
            }

            return result;
        }

        int mid = left + (right - left) / 2;

        // Query lies completely in the left child.
        if (queryRight <= mid) {
            return query(
                    2 * node,
                    left,
                    mid,
                    queryLeft,
                    queryRight
            );
        }

        // Query lies completely in the right child.
        if (queryLeft > mid) {
            return query(
                    2 * node + 1,
                    mid + 1,
                    right,
                    queryLeft,
                    queryRight
            );
        }

        // Query overlaps both children.
        Node leftNode = query(
                2 * node,
                left,
                mid,
                queryLeft,
                queryRight
        );

        Node rightNode = query(
                2 * node + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
        );

        Node result = new Node();

        // Product of the combined range.
        result.prod =
                (leftNode.prod * rightNode.prod) % K;

        // Subarrays completely inside the left part.
        for (int i = 0; i < K; i++) {
            result.cnt[i] = leftNode.cnt[i];
        }

        // Subarrays extending into the right part.
        for (int i = 0; i < K; i++) {

            if (rightNode.cnt[i] > 0) {

                int newRemainder =
                        (leftNode.prod * i) % K;

                result.cnt[newRemainder] +=
                        rightNode.cnt[i];
            }
        }

        return result;
    }
}
