package gfg.problemoftheday;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {-1, -3, -10, 0, 60};
        System.out.println("Result: " + maxProduct(arr));
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
}
