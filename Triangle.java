/*

Triangle

Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int currentValue = triangle.get(i).get(j);
                int belowLeft = triangle.get(i + 1).get(j);
                int belowRight = triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, currentValue + Math.min(belowLeft, belowRight));
            }
        }

        return triangle.get(0).get(0);
    }
}


public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle1 = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        System.out.println("Minimum Path Sum for Triangle 1: " + solution.minimumTotal(triangle1));

        List<List<Integer>> triangle2 = Arrays.asList(
            Arrays.asList(-10)
        );
        System.out.println("Minimum Path Sum for Triangle 2: " + solution.minimumTotal(triangle2));
    }
    
}


