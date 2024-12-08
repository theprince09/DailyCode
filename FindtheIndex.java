/*

Find the Index of the First Occurrence in a String 

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.
 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
*/

import java.util.Scanner;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] input1 = haystack.toCharArray();
        char[] search = needle.toCharArray();

        int count=0;
        int ans = -1;
        for(int i=0;i<input1.length;i++){
            if(search[count]==input1[i]){
                count++;
                
                if(count == search.length){
                    ans = i- count+1;
                    break;
                }
            }
            else{
                if (count > 0) {
                    i = i - count; 
                }
                count=0;
            }
        }
        return ans;
    }
}



public class FindtheIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the haystack string: ");
        String haystack = scanner.nextLine();
        
        System.out.print("Enter the needle string: ");
        String needle = scanner.nextLine();

        Solution solution = new Solution();
        int result = solution.strStr(haystack, needle);

        System.out.println("The index of the first occurrence of needle in haystack is: " + result);
        
        scanner.close();
    }
}
