import java.util.Scanner;

public class towerofHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt(); 
        
        int ans = (int) Math.pow(2, n) - 1; 
        System.out.println("The total number of moves required: " + ans);
        
        scanner.close(); 
    }
}
