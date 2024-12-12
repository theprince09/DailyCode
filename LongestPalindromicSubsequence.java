/*
Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 */

import java.util.Scanner;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) { 
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
 

/*

class Solution {
    public boolean palindrome(String str){
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed); 
    }


    public int longestPalindromeSubseq(String s) {
        if(palindrome(s)){
            return s.length();
        }
        int count = 0;
        
        char []arr = s.toCharArray();
        
        int []output = new int[10];
        int size = 0;
        List<Character> uniqueElements = new ArrayList<>();
        Set<Character> seen = new HashSet<>();
        for (char item : arr) {
            if (!seen.contains(item)) {
                uniqueElements.add(item);
                seen.add(item);
                }
            }
        for(int i=0;i<uniqueElements.size();i++){
            int ans = 0;
            for(int j=0;j<arr.length;j++){
                if(uniqueElements.get(i)==arr[j]){
                    ans++;
                }
            }
            output[size] = ans;
            size++;
        }
        int max = Arrays.stream(output).max().getAsInt();
        return max;
    }
}
 */

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String s = scanner.nextLine(); 
        
        Solution solution = new Solution();
        
        int result = solution.longestPalindromeSubseq(s);
        
        System.out.println("Length of longest palindromic subsequence: " + result);
        
        scanner.close();
    }
}


