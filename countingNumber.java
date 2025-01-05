/*
Given two positive integers a and b, return the number of common factors of a and b.

An integer x is a common factor of a and b if x divides both a and b.

 

Example 1:

Input: a = 12, b = 6
Output: 4
Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.
Example 2:

Input: a = 25, b = 30
Output: 2
Explanation: The common factors of 25 and 30 are 1, 5
 */

import java.util.Scanner;

class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;
        if(a>b){
            for(int i=1;i<=b;i++){
                if(a%i == 0 && b%i==0){
                    count++;
                }
            }
        }else{
            for(int i=1;i<=a;i++){
                if(a%i == 0 && b%i==0){
                    count++;
                }
            }

        }
        return count;
    }
}

public class countingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first positive integer (a): ");
        int a = scanner.nextInt();
        System.out.print("Enter the second positive integer (b): ");
        int b = scanner.nextInt();

        Solution solution = new Solution();

        int result = solution.commonFactors(a, b);
        System.out.println("The number of common factors of " + a + " and " + b + " is: " + result);

        scanner.close();
    }
}
