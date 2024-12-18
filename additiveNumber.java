/*
 * 306. Additive Number
Solved
Medium
Topics
Companies
An additive number is a string whose digits can form an additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits, return true if it is an additive number or false otherwise.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: 
The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: 
The additive sequence is: 1, 99, 100, 199. 
1 + 99 = 100, 99 + 100 = 199
 */

import java.util.Scanner;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                String num1Str = num.substring(0, i);
                String num2Str = num.substring(i, i + j);
                if ((num1Str.startsWith("0") && num1Str.length() > 1) ||
                    (num2Str.startsWith("0") && num2Str.length() > 1)) {
                    continue;
                }
                long num1 = Long.parseLong(num1Str);
                long num2 = Long.parseLong(num2Str);
                String remaining = num.substring(i + j);
                if (isValid(num1, num2, remaining)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(long num1, long num2, String remaining) {
        while (!remaining.isEmpty()) {
            long next = num1 + num2;
            String nextStr = String.valueOf(next);
            if (!remaining.startsWith(nextStr)) {
                return false;
            }
            num1 = num2;
            num2 = next;
            remaining = remaining.substring(nextStr.length());
        }
        return true;
    }
}


public class additiveNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number string: ");
        String num = scanner.nextLine();
        
        Solution sol = new Solution();
        boolean ans = sol.isAdditiveNumber(num);
        
        if (ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        scanner.close();
    }
}
