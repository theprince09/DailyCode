/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */

import java.util.Scanner;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expectSum = n*(n+1)/2;

        int actualSum = 0;
        for(int num : nums){
            actualSum+=num;
        }
        return expectSum-actualSum;
    }
}

public class missingNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array (n): ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int missingNumber = solution.missingNumber(nums);

        System.out.println("The missing number is: " + missingNumber);

        scanner.close();
    }
}
