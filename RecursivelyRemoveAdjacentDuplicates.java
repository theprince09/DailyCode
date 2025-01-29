/*
Given a string s, remove all its adjacent duplicate characters recursively, until there are no adjacent duplicate characters left.

Note: If the resultant string becomes empty, return an empty string.

Examples:

Input: s = "geeksforgeek"
Output: "gksforgk"
Explanation:  g(ee)ksforg(ee)k -> gksforgk
Input: s = "abccbccba"
Output: ""
Explanation: ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)
Input: s = "abcd"
Output: "abcd"
Explanation: There are no adjacent duplicate characters
Constraints:
1<= s.size() <= 105


 */

import java.util.Scanner;

class Solution{
    String removeUtil(String s) {
        // code here
        return helper(new StringBuilder(s),s.length()).toString();
    }
    
    StringBuilder helper(StringBuilder sb,int len){
        char prev = sb.charAt(0);
        int prevIndex = 0;
        
        int i;
        for (i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == prev) {
                continue;
            } else if (i - prevIndex > 1) {
                sb.replace(prevIndex, i, "");
                i = prevIndex-1;
                if (i < 0){ 
                    prev = sb.charAt(0);
                    prevIndex = 0;
                    i = 0;
                }
            } else {
                prevIndex = i;
                prev = sb.charAt(i);
            }
        }
        
        if (i - prevIndex > 1)
            sb.replace(prevIndex, i, "");
        
        if (sb.length()==0 || sb.length() == len) {
            return sb;
        }
    
        return helper(sb, sb.length());
    }
}

public class RecursivelyRemoveAdjacentDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input for the string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        
        // Creating a Solution object and calling the function
        Solution solution = new Solution();
        String result = solution.removeUtil(inputString);
        
        // Printing the result
        System.out.println("Resultant String after removing adjacent duplicates: " + result);
        
        scanner.close();
    }
}
