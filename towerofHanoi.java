import java.util.Scanner;
import java.util.Stack;

class Solution {

    // Using the formula approach: 2^n - 1
    public int formulaApproach(int n) {
        return (int) Math.pow(2, n) - 1;
    }

    // Using the recursive approach: T(n) = 2*T(n-1) + 1
    public int recursiveApproach(int n) {
        if (n == 1) {
            return 1; // Base case: Only one move for a single disk
        }
        return 2 * recursiveApproach(n - 1) + 1; // Recurrence relation
    }

    // Print stack contents
    private void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    // Print the current state of all stacks
    public void print(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3) {
        System.out.println("S1:");
        printStack(s1);
        System.out.println("=========");
        System.out.println("S2:");
        printStack(s2);
        System.out.println("=========");
        System.out.println("S3:");
        printStack(s3);
        System.out.println("***");
        System.out.println("***");
    }

    // Tower of Hanoi using stacks
    public void hanoi(Stack<Integer> s1, int n1, Stack<Integer> s2, Stack<Integer> s3) {
        if (n1 == 1) {
            s3.push(s1.pop());
            print(s1, s2, s3);
            return;
        }
        hanoi(s1, n1 - 1, s3, s2);
        s3.push(s1.pop());
        print(s1, s2, s3);
        hanoi(s2, n1 - 1, s1, s3);
    }
}

public class towerofHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt();

        // Using the formula approach
        int ansFormula = sol.formulaApproach(n);
        System.out.println("Using Formula Approach: The total number of moves required: " + ansFormula);

        // Using the recursive approach
        int ansRecursive = sol.recursiveApproach(n);
        System.out.println("Using Recursive Approach: The total number of moves required: " + ansRecursive);

        // Tower of Hanoi with stack simulation
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        for (int i = n; i > 0; i--) {
            s1.push(i); // Initialize s1 with disks in decreasing order
        }

        System.out.println("Initial State:");
        sol.print(s1, s2, s3);

        System.out.println("Simulating Tower of Hanoi moves:");
        sol.hanoi(s1, n, s2, s3);

        scanner.close();
    }
}
