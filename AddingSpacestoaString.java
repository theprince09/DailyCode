/*

Adding Spaces to a String

Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
Output: "Leetcode Helps Me Learn"
Explanation: 
The indices 8, 13, and 15 correspond to the underlined characters in "LeetcodeHelpsMeLearn".
We then place spaces before those characters.

Input: s = "icodeinpython", spaces = [1,5,7,9]
Output: "i code in py thon"
Explanation:
The indices 1, 5, 7, and 9 correspond to the underlined characters in "icodeinpython".
We then place spaces before those characters.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int spaceIndex = 0; 

        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                ans.append(" "); 
                spaceIndex++;       
            }
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}



public class AddingSpacestoaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        System.out.print("Enter the space indices (comma-separated): ");
        String[] spaceStrings = scanner.nextLine().split(",");
        int[] spaces = new int[spaceStrings.length];
        for (int i = 0; i < spaceStrings.length; i++) {
            spaces[i] = Integer.parseInt(spaceStrings[i].trim());
        }

        Solution solution = new Solution();

        String result = solution.addSpaces(s, spaces);

        System.out.println("Output: \"" + result + "\"");

        scanner.close();
    }
}
