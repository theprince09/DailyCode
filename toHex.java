import java.util.Scanner;

class Solution {
    public String toHex(int num) {
        String hex = Integer.toHexString(num);
        return hex;
    }
}

public class toHex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.print("Enter ur num: ");
        int num = sc.nextInt();
        String ans = sol.toHex(num);
        System.out.println("Hex value of "+ num + " is: "+ ans);        
    }
}
