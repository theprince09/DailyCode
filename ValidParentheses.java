/*
 * 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

import java.util.Stack;
import java.util.Scanner;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> str = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                str.push(ch);
            } else {
                if (str.isEmpty()) {
                    return false;
                }

                char top = str.pop();
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return str.isEmpty();
    }
}
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string of parentheses: ");
        String input = scanner.nextLine();

        boolean result = solution.isValid(input);

        System.out.println("Input: \"" + input + "\" -> Output: " + result);
        
        scanner.close();
    }
}