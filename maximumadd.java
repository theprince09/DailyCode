/*
 * Maximum Number of Integers to Choose From a Range I
 You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:

The chosen integers have to be in the range [1, n].
Each integer can be chosen at most once.
The chosen integers should not be in the array banned.
The sum of the chosen integers should not exceed maxSum.
Return the maximum number of integers you can choose following the mentioned rules.

 

Example 1:

Input: banned = [1,6,5], n = 5, maxSum = 6
Output: 2
Explanation: You can choose the integers 2 and 4.
2 and 4 are from the range [1, 5], both did not appear in banned, and their sum is 6, which did not exceed maxSum.
Example 2:

Input: banned = [1,2,3,4,5,6,7], n = 8, maxSum = 1
Output: 0
Explanation: You cannot choose any integer while following the mentioned conditions.
Example 3:

Input: banned = [11], n = 7, maxSum = 50
Output: 7
Explanation: You can choose the integers 1, 2, 3, 4, 5, 6, and 7.
They are from the range [1, 7], all did not appear in banned, and their sum is 28, which did not exceed maxSum.
 */

import java.util.*;

class Solution {
    public void maxCount(int[] banned, int n,int MaxSum) {
        Arrays.sort(banned); 
        List<Integer> arr = new ArrayList<>();
        int count = 0;
        int num = 1;

        while (num <= n) {
            
            if (count < banned.length && num == banned[count]) {
                count++;
            } else {
                arr.add(num); 
            }
            num++;
        }       
        int maxCount = 0;
        int currentSum = 0;

        for (int number : arr) {
            if (currentSum + number <= MaxSum) {
                currentSum += number;
                maxCount++;
            } else {
                break; 
            }
        }

        System.out.println("Max Sum is: "+ maxCount);

    }
}

public class maximumadd {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] banned = {11};
        int n = 7;
        int MaxSum = 50;
        solution.maxCount(banned, n,MaxSum);
    }
}


