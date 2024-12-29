/*
 Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

 

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1
 
 */
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i=0;i<citations.length;i++){
            if (citations[n - i - 1] < i + 1) {
                return i;
            }  

        }
        return n;

    }
}


public class hIindex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of papers: ");
        int n = scanner.nextInt();
        
        int[] citations = new int[n];
        System.out.print("Enter the citations for the papers: ");
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int hIndex = solution.hIndex(citations);
        
        System.out.println("The h-index is: " + hIndex);
        
        scanner.close();
    }
}
