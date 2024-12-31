/*
 * Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"
 

Constraints:

-107 <= num <= 107
 */

import java.util.Scanner;

class Solution {
    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder base3 = new StringBuilder();
        if(num>0){
            while (num > 0) {
               int remainder = num % 7;
                base3.append(remainder);
                num /= 7;
            }
        }else{
            num = -(num);
            while (num > 0) {
               int remainder = num % 7;
                base3.append(remainder);
                num /= 7;
            }
            base3.append("-");

        }

        return base3.reverse().toString();
    }
}

public class Base7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int num = scanner.nextInt();
        Solution solution = new Solution();
        String result = solution.convertToBase7(num);
        System.out.println("Base-7 representation: " + result);
    }
}
