/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}

public class BinaryTreePostorderTraversal {
    // Function to build a binary tree from level-order input
    public static TreeNode buildTree(Scanner scanner) {
        System.out.println("Enter root value (or -1 for null):");
        int rootVal = scanner.nextInt();
        if (rootVal == -1) return null;

        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println("Enter left child of " + current.val + " (-1 for null):");
            int leftVal = scanner.nextInt();
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.add(current.left);
            }

            System.out.println("Enter right child of " + current.val + " (-1 for null):");
            int rightVal = scanner.nextInt();
            if (rightVal != -1) {
                current.right = new TreeNode(rightVal);
                queue.add(current.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = buildTree(scanner);
        scanner.close();

        Solution solution = new Solution();
        List<Integer> postorderResult = solution.postorderTraversal(root);

        System.out.println("Postorder Traversal:");
        System.out.println(postorderResult);
    }
}
