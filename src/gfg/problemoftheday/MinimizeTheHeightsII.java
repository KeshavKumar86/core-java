package gfg.problemoftheday;

import java.util.Arrays;

public class MinimizeTheHeightsII {
    public static void main(String[] args) {
        int[] arr = {3, 9, 12, 16, 20};
        int k = 3;
        System.out.println(getMinDiff(k, arr));
    }

    public static int getMinDiff(int k, int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int minDiff = arr[n - 1] - arr[0];
        for (int i = 0; i <= n - 2; i++) {
            int max = Math.max(arr[i] + k, arr[n - 1] - k);
            int min = Math.min(arr[0] + k, arr[i + 1] - k);
            if (arr[i + 1] - k < 0) {
                continue;
            }
            minDiff = Math.min(minDiff, max - min);
        }
        return minDiff;
    }
}
