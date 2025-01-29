/*
Given a string s, you have to find the number of palindromic subsequences (need not necessarily be distinct) present in the string s. 

Examples:

Input: s = "abcd"
Output: 4
Explanation: palindromic subsequence are : 'a' ,'b', 'c' ,'d'
Input: s = "aab"
Output: 4
Explanation: palindromic subsequence are : 'a', 'a', 'b', 'aa'
Input: s = "b"
Output: 1
Explanation: palindromic subsequence are : 'b'
Constraints:
1<= s.size() <=30
 */

import java.util.Scanner;

class Solution
 {
     long countPS(String str)
     {
         int mod = 1000000007;
         long dp [][] = new long [str.length()][str.length()];
         for(int g=0;g<str.length();g++){
             for(int i=0,j=g;j<dp.length;i++,j++){
                 if(g==0){
                     dp[i][j] =1;
                 }else if(g==1){
                     dp[i][j] =str.charAt(i)==str.charAt(j)?3:2;
                 }else{
                     if(str.charAt(i)==str.charAt(j)){
                         dp[i][j]= ((dp[i][j-1])%mod+(dp[i+1][j]+1)%mod)%mod;
                     }else{
                         dp[i][j]= ( (dp[i][j-1])%mod+(dp[i+1][j])%mod -(dp[i+1][j-1])%mod+mod)%mod;
                     }
                 }
                 
             }
         }
         return dp[0][str.length()-1];
     }
 }

public class CountPalindromicSubsequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        Solution solution = new Solution();
        long result = solution.countPS(input);
        
        System.out.println("Number of palindromic subsequences: " + result);
        
        scanner.close();
    }
}
