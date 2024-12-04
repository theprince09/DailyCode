/*
 * Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 */


import java.util.*;

class Solution {
    public boolean search(int []num,int j){
        for(int i=0;i<num.length;i++){
            if(j == num[i]){
                System.out.println(num[i] + " Search Found!");
                return true;
            }
        }
        System.out.println(j+" Not Search Found!");
        return false;
    }
    public int firstMissingPositive(int[] nums) {
        int missing = 1;

        while(true){
            if(!search(nums, missing)){
                break;
            }
            missing++;
        
        }  
        return missing;
    }
}
public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        
        System.out.print("Enter size of array: ");
        size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.firstMissingPositive(arr);
        System.out.println(result);
    }
}



