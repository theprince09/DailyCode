public class BSonArr {

    // Function to count elements in nums that are <= val
    static int count_of_small_or_equal(int val, int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num <= val) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int k = 5; // Example: Find the 5th smallest element
        int[] nums = {1, 3, 4, 7, 10, 12, 15}; // Example array (sorted)
        
        // Define the range of your answer
        int low = nums[0];  // Minimum element in the array
        int high = nums[nums.length - 1]; // Maximum element in the array

        int result = -1; // To store the answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Count of elements <= mid
            int p = count_of_small_or_equal(mid, nums);

            if (p < k) {
                // If count is less than k, move the range up
                low = mid + 1;
            } else {
                // Check if mid is the k-th smallest
                int q = count_of_small_or_equal(mid - 1, nums);
                if (q < k) {
                    result = mid;
                    break;
                }
                // Otherwise, move the range down
                high = mid - 1;
            }
        }

        // Output the result
        if (result != -1) {
            System.out.println("The " + k + "-th smallest element is: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
