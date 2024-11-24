package gfg.problemoftheday;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4, -5};
        System.out.println("Result: " + maxSubarraySum(arr));

    }

    //Kadane Algorithm O(n) time solution
    static int maxSubarraySum(int[] arr) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
