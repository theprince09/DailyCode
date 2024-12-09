/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

import java.util.*;
import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {

        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);

        BigInteger sum = num1.add(num2);

        String result = sum.toString(2);
        return result;
    }
}


public class BinaryAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first binary string: ");
        String binary1 = scanner.nextLine();

        System.out.print("Enter the second binary string: ");
        String binary2 = scanner.nextLine();

        Solution solution = new Solution();
        String result = solution.addBinary(binary1, binary2);

        System.out.println("The sum of the binary strings is: " + result);

        scanner.close();
    }
}
