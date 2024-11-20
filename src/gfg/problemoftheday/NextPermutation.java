package gfg.problemoftheday;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 7, 5, 0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println("Array After Permutation: " + Arrays.toString(arr));

    }

    static void nextPermutation(int[] arr) {

        int n = arr.length;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                break;
            }
        }
        if (i != 0) {
            int minIndex = findMinIndex(arr, i, n, arr[i - 1]);
            // swap 2 numbers
            int temp = arr[i - 1];
            arr[i - 1] = arr[minIndex];
            arr[minIndex] = temp;
        }
        reverse(arr, i, n - 1);
    }

    static int findMinIndex(int[] arr, int low, int high, int element) {

        int result = arr[low];
        int i;
        int index = low;
        for (i = low; i < high; i++) {
            if (arr[i] < result && arr[i] > element) {
                result = arr[i];
                index = i;
            }
        }
        return index;
    }

    static void reverse(int[] arr, int low, int high) {

        int temp;
        while (low < high) {
            temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }
}
