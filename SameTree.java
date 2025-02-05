/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
*/

import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructors
    TreeNode(int val) { 
        this.val = val; 
        this.left = null;
        this.right = null;
    }
}

class Solution {
    // Method to check if two trees are equal
    boolean isEqual(TreeNode N1, TreeNode N2) {
        if (N1 == null && N2 == null) return true;
        if (N1 == null || N2 == null) return false;

        return (N1.val == N2.val) &&
               isEqual(N1.left, N2.left) &&
               isEqual(N1.right, N2.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isEqual(p, q);
    }
}

public class SameTree {
    // Function to build a binary tree from user input
    public static TreeNode buildTree(Scanner scanner) {
        System.out.print("Enter node value (-1 for NULL): ");
        int val = scanner.nextInt();
        if (val == -1) return null;

        TreeNode node = new TreeNode(val);
        System.out.println("Enter left child of " + val);
        node.left = buildTree(scanner);
        System.out.println("Enter right child of " + val);
        node.right = buildTree(scanner);
        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Build first tree:");
        TreeNode root1 = buildTree(scanner);

        System.out.println("Build second tree:");
        TreeNode root2 = buildTree(scanner);

        scanner.close();

        Solution solution = new Solution();
        boolean result = solution.isSameTree(root1, root2);

        System.out.println("Are the trees the same? " + result);
    }
}

