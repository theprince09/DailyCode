/*
 Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 
 */

import java.util.Scanner;

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0){
            return false;
        }
        return (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }
}

public class isPowerFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it is a power of four: ");
        int num = scanner.nextInt();

        Solution solution = new Solution();
        boolean result = solution.isPowerOfFour(num);

        System.out.println(num + " is a power of four? " + result);
    }
}
