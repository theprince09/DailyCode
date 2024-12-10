/*
 Valid Palindrome

 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

 import java.util.Scanner;

class Solution {
    public boolean isPalindrome(String s) {
        String lowercase = s.toLowerCase();
        String input = lowercase.replaceAll("[^a-zA-Z0-9]", "");
        String reverse = "";

        for(int i= input.length()-1;i>=0;i--){
            reverse += input.charAt(i);
        }
        if(input.equals(reverse)){
            return true;
        }
        return false;
    }
}


public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String userInput = scanner.nextLine();

        Solution solution = new Solution();

        boolean result = solution.isPalindrome(userInput);

        if (result) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }

        scanner.close();
    }
}
