/*
 * Day 32 - LeetCode
 *
 * Problem: Brace Expansion II
 *
 * Given an expression containing lowercase English words, '{', '}',
 * and ',':
 *
 * - ',' represents union.
 * - Adjacent expressions represent concatenation.
 * - Braces control the grouping.
 *
 * Return all possible expanded strings in lexicographical order
 * without duplicates.
 *
 * Approach:
 * 1. Use a stack of string lists to store the results of individual
 *    expressions.
 * 2. Use an operator stack:
 *      '+' -> Union
 *      '*' -> Concatenation
 * 3. When ',' is encountered, resolve pending operations until the
 *    current '{' is reached, then push '+'.
 * 4. When '{' is encountered:
 *      - If it follows a word or '}', push '*' for concatenation.
 *      - Then push '{' as a boundary marker.
 * 5. When '}' is encountered, resolve all operations until the
 *    matching '{'.
 * 6. For concatenation, combine every string from the left list
 *    with every string from the right list.
 * 7. After processing the entire expression, sort the result and
 *    remove duplicates.
 *
 * Time Complexity: Depends on the number of generated strings.
 * Space Complexity: Depends on the number of generated strings.
 *
 * Date Solved: 25 September 2026
 */

import java.util.*;

class Solution {

    List<Character> operators = new ArrayList<>();
    List<List<String>> stack = new ArrayList<>();

    // Perform the operation at the top of the operator stack.
    private void perform() {

        int x = stack.size() - 2;
        int y = stack.size() - 1;

        char operation = operators.get(operators.size() - 1);

        if (operation == '+') {

            // Union
            stack.get(x).addAll(stack.get(y));

        } else {

            // Concatenation
            List<String> next = new ArrayList<>();

            for (String left : stack.get(x)) {
                for (String right : stack.get(y)) {
                    next.add(left + right);
                }
            }

            stack.set(x, next);
        }

        operators.remove(operators.size() - 1);
        stack.remove(stack.size() - 1);
    }

    public List<String> braceExpansionII(String expression) {

        int n = expression.length();

        char previous = '@';
        char current;

        for (int i = 0; i < n; i++) {

            current = expression.charAt(i);

            if (current == ',') {

                // Resolve operations inside the current braces.
                while (!operators.isEmpty()
                        && operators.get(operators.size() - 1) != '{') {

                    perform();
                }

                operators.add('+');
            }

            else if (current == '{') {

                // Word or '}' followed by '{' means concatenation.
                if (previous == '}' || isLetter(previous)) {
                    operators.add('*');
                }

                // Mark the beginning of a brace group.
                operators.add('{');
            }

            else if (current == '}') {

                // Resolve everything inside this brace group.
                while (!operators.isEmpty()
                        && operators.get(operators.size() - 1) != '{') {

                    perform();
                }

                // Remove the matching '{'.
                operators.remove(operators.size() - 1);
            }

            else {

                // A word/letter after '}' means concatenation.
                if (previous == '}') {
                    operators.add('*');
                }

                // Read the complete word.
                StringBuilder word = new StringBuilder();

                while (i < n && isLetter(expression.charAt(i))) {
                    word.append(expression.charAt(i));
                    i++;
                }

                stack.add(new ArrayList<>());
                stack.get(stack.size() - 1).add(word.toString());

                // The loop already moved one position ahead.
                i--;

                current = expression.charAt(i);
            }

            previous = current;
        }

        // Resolve all remaining operations.
        while (!operators.isEmpty()) {
            perform();
        }

        List<String> answer = stack.get(0);

        // Sort lexicographically.
        Collections.sort(answer);

        // Remove duplicates.
        List<String> unique = new ArrayList<>();

        for (String str : answer) {
            if (unique.isEmpty()
                    || !unique.get(unique.size() - 1).equals(str)) {

                unique.add(str);
            }
        }

        return unique;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
