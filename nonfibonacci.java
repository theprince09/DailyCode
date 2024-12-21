/*
 Input: Series: [4,7,1,13,10,21,8]
 Output: Non-Fibonacci Numbers in Series:  [4,7,10]

 Explanation: Find Non-Fibonacci Numbers:

Check each number in the series:

4: Not in Fibonacci numbers → Non-Fibonacci

7: Not in Fibonacci numbers → Non-Fibonacci

1: In Fibonacci numbers → Fibonacci

13: In Fibonacci numbers → Fibonacci

10: Not in Fibonacci numbers → Non-Fibonacci

21: In Fibonacci numbers → Fibonacci

8: In Fibonacci numbers → Fibonacci
 */

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<Integer> check(int []arr){
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        while (true) {
            int next = (fibonacci.get(fibonacci.size()-1)) +(fibonacci.get(fibonacci.size()-2));
            if(next>max){
                break;
            }
            fibonacci.add(next);
            
        }

        List<Integer> nonfibonacci = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(!fibonacci.contains(arr[i])){
                nonfibonacci.add(arr[i]);
            }

        }
        return nonfibonacci;

    }
}
 
public class nonfibonacci {
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 13, 10, 21, 8}; 
        Solution sol = new Solution();
        List<Integer> nonfibonacci =  sol.check(arr);
        System.out.println("Non fibonacci numbers are: " + nonfibonacci);
    }
}
