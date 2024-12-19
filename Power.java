/*
 * 50. Pow(x, n)
Solved
Medium
Topics
Companies
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */

import java.util.Scanner;

class Solution {
    public double myPow(double x, int n) {
        double result = Math.pow(x,n);
        return result;
    }
}

public class Power {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ur num: ");
        double input = sc.nextDouble();
        System.out.print("Enter power: ");
        int n = sc.nextInt();
        double answer = sol.myPow(input, n);
        System.out.println("Output: "+ answer);

        sc.close();
        
    }
}
