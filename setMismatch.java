/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int []arr = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;

        for (int i = 1; i < n; i++) {
            actualSum += nums[i - 1];
            if (nums[i] == nums[i - 1]) {
                arr[0] = nums[i];
            }
        }
        actualSum += nums[n - 1];

        arr[1] = expectedSum - (actualSum - arr[0]);

        return arr;
    }
}

public class setMismatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution solution = new Solution();
        int[] result = solution.findErrorNums(nums);

        System.out.println("Duplicate number: " + result[0]);
        System.out.println("Missing number: " + result[1]);

        sc.close();
    }
}
