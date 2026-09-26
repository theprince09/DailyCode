/*
 * Day 33 - LeetCode
 *
 * Problem: Evaluate the Bracket Pairs of a String
 *
 * Given a string s containing bracketed keys and a knowledge list
 * containing key-value pairs, replace every key with its
 * corresponding value.
 *
 * If a key does not exist in the knowledge list, replace it with "?".
 *
 * Approach:
 * 1. Store all key-value pairs in a HashMap.
 * 2. Traverse the string from left to right.
 * 3. When '(' is encountered, find the corresponding ')'.
 * 4. Extract the key between the brackets.
 * 5. Look up the key in the HashMap.
 * 6. If the key exists, append its value; otherwise append "?".
 * 7. Continue until the entire string has been processed.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(m)
 *
 * Where:
 *   n = length of the string
 *   m = total size of the knowledge map
 *
 * Date Solved: 26 September 2026
 */

import java.util.*;

class Solution {

    public String evaluate(String s, List<List<String>> knowledge) {

        // Store knowledge as key-value pairs.
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            // Normal character.
            if (s.charAt(i) != '(') {
                result.append(s.charAt(i));
                i++;
                continue;
            }

            // Find the closing bracket.
            int j = i + 1;

            while (s.charAt(j) != ')') {
                j++;
            }

            // Extract the key.
            String key = s.substring(i + 1, j);

            // Replace with value or '?' if key doesn't exist.
            result.append(map.getOrDefault(key, "?"));

            // Move past ')'.
            i = j + 1;
        }

        return result.toString();
    }
}
