/*
Move Pieces to Obtain a String

Example 1:

Input: start = "_L__R__R_", target = "L______RR"
Output: true
Explanation: We can obtain the string target from start by doing the following moves:
- Move the first piece one step to the left, start becomes equal to "L___R__R_".
- Move the last piece one step to the right, start becomes equal to "L___R___R".
- Move the second piece three steps to the right, start becomes equal to "L______RR".
Since it is possible to get the string target from start, we return true.
Example 2:

Input: start = "R_L_", target = "__LR"
Output: false
Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
After that, no pieces can move anymore, so it is impossible to obtain the string target from start.
Example 3:

Input: start = "_R", target = "R_"
Output: false
Explanation: The piece in the string start can move only to the right, so it is impossible to obtain the string target from start.
 */

import java.util.Scanner;

class Solution {
    public boolean canChange(String start, String target) {
        String sFiltered = start.replace("_", "");
        String tFiltered = target.replace("_", "");
        if (!sFiltered.equals(tFiltered)) {
            return false;
        }

        int i = 0, j = 0;
        int n = start.length();

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            if (i == n || j == n) {
                break;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && j > i) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}




public class MovePiecestoObtainaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the start string:");
        String start = scanner.nextLine();

        System.out.println("Enter the target string:");
        String target = scanner.nextLine();

        Solution solution = new Solution();

        boolean result = solution.canChange(start, target);
        System.out.println("Can transform: " + result);

        scanner.close();
    }
}


