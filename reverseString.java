/*
Write a function that reverses a string. The input string is given as an array of characters s.


You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */

import java.util.Scanner;

class Solution {
    public void reverseString(char[] s) {
        char []newArr = new char[s.length];
        int count =0;
        for(int i=s.length-1;i>=0;i--){
            newArr[count] = s[i];
            count++;
        }
        for(int i=0;i<s.length;i++){
            s[i] = newArr[i];

        }

    }
}

public class reverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string:");
        String input = scanner.nextLine();

        char[] s = input.toCharArray();

        Solution solution = new Solution();
        solution.reverseString(s);

        System.out.println("Reversed string:");
        System.out.println(new String(s));
        
        scanner.close();
    }
}
