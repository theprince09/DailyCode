/*

Minimum Limit of Balls in a Bag

Example 1:

Input: nums = [9], maxOperations = 2
Output: 3
Explanation: 
- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
Example 2:

Input: nums = [2,4,8,2], maxOperations = 4
Output: 2
Explanation:
- Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
 
 */

import java.util.Scanner;

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1; 
        int right = Integer.MIN_VALUE; 

        for (int num : nums) {
            right = Math.max(right, num);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, maxOperations, mid)) {
                result = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canDivide(int[] nums, int maxOperations, int penalty) {
        int operations = 0;

        for (int num : nums) {
            if (num > penalty) {
                
                operations += (num - 1) / penalty;
            }
            if (operations > maxOperations) {
                return false; 
            }
        }

        return true; 
    }
}




public class MinimumLimitofBallsinaBag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of bags: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the number of balls in each bag: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the maximum number of operations: ");
        int maxOperations = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.minimumSize(nums, maxOperations);

        System.out.println("The minimum penalty is: " + result);
        
        scanner.close();
    }
}
