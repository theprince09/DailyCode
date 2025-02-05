/*
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

 

Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
Example 2:

Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.
Example 3:

Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
 

Constraints:

1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 and s2 consist of only lowercase English letters.
*/

import java.util.Scanner;

public class OneStringSwap {
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // Already equal, no swap needed

        int first = -1, second = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) return false; // More than 2 mismatches → can't fix with one swap
                
                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }

        // If exactly 2 mismatches, check if swapping makes them equal
        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s1.charAt(first);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input for two strings
        System.out.print("Enter first string (s1): ");
        String s1 = scanner.nextLine();
        
        System.out.print("Enter second string (s2): ");
        String s2 = scanner.nextLine();
        
        scanner.close();
        
        // Checking if they can be made equal by one swap
        boolean result = areAlmostEqual(s1, s2);
        
        // Output result
        System.out.println("Can be made equal by one swap: " + result);
    }
}
