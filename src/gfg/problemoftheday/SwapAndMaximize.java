package gfg.problemoftheday;

import java.util.Arrays;

public class SwapAndMaximize {
    public static void main(String[] args) {
        Long[] arr = {2L, 8L, 6L, 5L, 7L, 9L, 10L};
        System.out.println("Result: " + maxSum(arr));

    }

    static public long maxSum(Long[] arr) {
        // code here
        Arrays.sort(arr, (a, b) -> (int) (b - a));

        // Reverse the array for descending order
        int n = arr.length;
        int low = 0, high = arr.length - 1;
        int sum = 0;
        while (low < high) {
            sum += (int) Math.abs(arr[low] - arr[high]);
            if (high - 1 != low) {
                sum += (int) Math.abs(arr[low] - arr[high - 1]);
            } else {
                sum += (int) Math.abs(arr[low] - arr[arr.length - 1]);
            }
            low++;
            high--;
        }
        if (n % 2 != 0) {
            sum += (int) Math.abs(arr[low] - arr[n - 1]);
        }
        return sum;
    }
}
