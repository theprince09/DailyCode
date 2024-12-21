
class Solution{
    public boolean validPalimdrome(int n){
        int number = n;
        int rev = 0;
        while(number!=0){
            int remainder = number%10;
            rev = rev*10+remainder;
            number /=10;
        }
        if(rev==n){
            return true;
        }
        return false;
    }
}

public class palim {
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.validPalimdrome(505);
        if(ans){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
