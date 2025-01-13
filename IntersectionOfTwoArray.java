/*
 Intersection of Two Arrays


Given two integer arrays nums1 and nums2, return an array of their 
intersection
. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j] && !ls.contains(nums1[i])){
                    ls.add(nums1[i]);
                    break;
                }
            }
        }
        int []arr = new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            arr[i] = ls.get(i);
        }
        return arr;
        
    }
}

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter the elements of the first array: ");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter the elements of the second array: ");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        Solution solution = new Solution();
        int[] result = solution.intersection(nums1, nums2);

        System.out.println("Intersection of the arrays: " + Arrays.toString(result));

        sc.close();
    }
}
