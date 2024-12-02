//Check If a Word Occurs As a Prefix of Any Word in a Sentence
/*
Input: sentence = "i love eating burger", searchWord = "burg"
Output: 4
Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.

Input: sentence = "this problem is an easy problem", searchWord = "pro"
Output: 2
Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
 * 
 */

import java.util.Scanner;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String[] words = sentence.split(" ");
        
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1; 
            }
        }
        
        return -1;
    }
}

public class prefixSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();
        
        System.out.print("Enter the search word: ");
        String searchWord = scanner.nextLine();
        
        Solution solution = new Solution();
        
        int result = solution.isPrefixOfWord(sentence, searchWord);
        System.out.println("Output: " + result);
        
        scanner.close();
    }
}
