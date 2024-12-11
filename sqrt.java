/*
 * Sqrt(x)
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1
 */

import java.util.Scanner;

class Solution {
    public int mySqrt(int x) {
        int sq =(int) Math.sqrt(x);
        return sq;
    }
}

public class sqrt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int x = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.mySqrt(x);

        System.out.println("The square root of " + x + " rounded down is: " + result);

        scanner.close();
    }
}
