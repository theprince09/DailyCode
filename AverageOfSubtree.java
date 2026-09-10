/*
 * Day 17 - LeetCode
 *
 * Problem: Count Nodes Equal to Average of Subtree
 *
 * Given the root of a binary tree, return the number of nodes whose
 * value is equal to the average of the values in their subtree.
 *
 * The average is calculated using integer division.
 *
 * Approach:
 * 1. For every node, calculate:
 *    - Sum of all values in its subtree.
 *    - Number of nodes in its subtree.
 *
 * 2. Use a helper function that returns both values:
 *
 *    {subtree sum, subtree node count}
 *
 * 3. For the current node:
 *
 *    average = subtree sum / subtree node count
 *
 *    If the node's value equals this average, increment the answer.
 *
 * 4. Recursively repeat the same process for the left and right
 *    subtrees.
 *
 * Time Complexity: O(n^2) for this implementation because the subtree
 * information is calculated repeatedly.
 *
 * Space Complexity: O(h), where h is the height of the tree due to
 * recursion.
 *
 * Date Solved: 10 September 2026
 */

/**
 * Definition for a binary tree node.
 *
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /*
     * Returns:
     * [0] -> sum of the subtree
     * [1] -> number of nodes in the subtree
     */
    private int[] get(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = get(root.left);
        int[] right = get(root.right);

        int sum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        return new int[]{sum, count};
    }

    public int averageOfSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int answer = 0;

        // Get sum and count for the current node's subtree
        int[] left = get(root.left);
        int[] right = get(root.right);

        int sum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        // Integer division is used for the average
        if (root.val == sum / count) {
            answer++;
        }

        // Check left and right subtrees
        answer += averageOfSubtree(root.left);
        answer += averageOfSubtree(root.right);

        return answer;
    }
}
