/*
 Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal 
substring
 consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 
 */

import java.util.Scanner;

class Solution {
    public int lengthOfLastWord(String s) {
        s.trim();
        String []arr = s.split("\\s+");
        String LastWord = arr[arr.length-1];
        int length = LastWord.length();
        return length;
    }
}
public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine(); // Take user input

        Solution sol = new Solution();
        int length = sol.lengthOfLastWord(input);

        System.out.println("The length of the last word is: " + length);
    }
}
