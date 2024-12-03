/*
Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
 */

 import java.util.Scanner;

 class Solution {
     public int divide(int dividend, int divisor) {
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
             return Integer.MAX_VALUE;
         }
         return dividend / divisor;
     }
 }
 
 public class DivideTwoIntegers {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         System.out.print("Enter dividend: ");
         int dividend = scanner.nextInt();
 
         System.out.print("Enter divisor (non-zero): ");
         int divisor = scanner.nextInt();
 
         if (divisor == 0) {
             System.out.println("Divisor cannot be zero.");
             return;
         }
 
         Solution solution = new Solution();
 
         int result = solution.divide(dividend, divisor);
         System.out.println("Output: " + result);
     }
 }
 