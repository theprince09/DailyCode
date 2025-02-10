/*
3174. Clear Digits
You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.

*/

import java.util.Scanner;

public class ClearDigits {
    public String removeDigits(String s) {
        StringBuilder stack = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClearDigits solution = new ClearDigits();

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        
        String result = solution.removeDigits(input);
        System.out.println("Resulting string: " + result);

        scanner.close();
    }
}
