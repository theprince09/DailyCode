
/*
 * 164. Maximum Gap
Solved
Medium
Topics
Companies
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.

 

Example 1:

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 */

import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxGap = 0;
        for(int i=1;i<nums.length;i++){
            int add = nums[i]-nums[i-1]; 
            if(add>maxGap){
                maxGap = add;
            }
        }
        return maxGap;
    }
}

public class maxGap {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ur array size: ");
        int size = sc.nextInt();
        int []arr = new int[size];
        System.out.println("Enter ur array: ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        int ans = sol.maximumGap(arr);
        System.out.println("Maximum gap between given array is: " + ans);

    }
}
