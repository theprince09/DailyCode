/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SymmetricTree {

    // Function to check if two trees are mirror images
    boolean isMirror(TreeNode N1, TreeNode N2) {
        if (N1 == null && N2 == null) return true;
        if (N1 == null || N2 == null) return false;

        return (N1.val == N2.val) && 
               isMirror(N1.left, N2.right) && 
               isMirror(N1.right, N2.left);
    }

    // Function to check if a tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // Function to build a tree from level-order input
    public static TreeNode buildTree(Scanner scanner) {
        System.out.println("Enter node values in level order (use 'null' for empty nodes):");
        String[] values = scanner.nextLine().split(" ");
        if (values.length == 0 || values[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = buildTree(scanner);
        scanner.close();

        SymmetricTree solution = new SymmetricTree();
        boolean result = solution.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}
