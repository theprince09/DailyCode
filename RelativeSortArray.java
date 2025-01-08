/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
 
 */


import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int []arr = new int[arr1.length];
        int count = 0;
        for(int i= 0;i<arr2.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr2[i]==arr1[j]){
                    arr[count] = arr1[j];
                    count++;
                }
            }
        }
        Arrays.sort(arr1);
        
        
        for(int i= 0;i<arr1.length;i++){
            boolean found = false;
            for(int j=0;j<arr2.length;j++){
                if(arr2[j]==arr1[i]){
                    found  = true;
                    break;
                }
            }
            if(!found){
                arr[count] = arr1[i];
                count++;
            }
        }
        
        return arr;
    }
}


public class RelativeSortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.println("Enter the size of arr1:");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of arr1:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the size of arr2:");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter elements of arr2:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] result = solution.relativeSortArray(arr1, arr2);

        System.out.println("Resulting Array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
