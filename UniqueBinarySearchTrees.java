/*
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19
*/

import java.util.Scanner;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1; // Base cases

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j]; // Applying the formula
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();

        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        int result = solution.numTrees(n);
        
        System.out.println("Number of unique BSTs for n = " + n + ": " + result);
    }
}
