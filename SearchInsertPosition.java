/*
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

 import java.util.Scanner;
 import java.util.Arrays;

class Solution {
    public int searchInsert(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                return count;
            }
            if(nums[i]==target){
                return count;
            }
            count++;
        }
        return count;
    }
}

public class SearchInsertPosition {
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
        int position = solution.searchInsert(nums, target);

        System.out.println("The target should be inserted at index: " + position);
        
        scanner.close();
    }
}
