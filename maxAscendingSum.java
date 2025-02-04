/*
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

 

Example 1:

Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
Example 2:

Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
Example 3:

Input: nums = [12,17,15,13,10,11,12]
Output: 33
Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
*/

import java.util.Scanner;

class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; 
        int currentSum = nums[0];  

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { 
                currentSum += nums[i];
            } else {  
                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i];  
            }
        }
        return Math.max(maxSum, currentSum);  
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        scanner.close(); // Close the scanner

        Solution sol = new Solution();
        System.out.println("Maximum Ascending Subarray Sum: " + sol.maxAscendingSum(nums));
    }
}
