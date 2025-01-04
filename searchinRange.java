/*
Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */

import java.util.Scanner;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                arr[count] = i;
                count++;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                arr[count] = i;
                break;
            }
        }
        if (count == 0) {
            arr[0] = -1;
            arr[1] = -1;
        }
        return arr;
    }
}


public class searchinRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        Solution solution = new Solution();
        int[] result = solution.searchRange(nums, target);

        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
}
