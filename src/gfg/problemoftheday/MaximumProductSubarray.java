package gfg.problemoftheday;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {-1, 0, -1};
        System.out.println("Result: " + maxProductOptimal(arr));
    }

    static int maxProduct(int[] arr) {
        int product;
        int maxProduct = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            product = 1;
            for (int j = i; j < n; j++) {
                product *= arr[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

    static int maxProductOptimal(int[] arr) {
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix *= arr[i];
            suffix *= arr[n - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

}
