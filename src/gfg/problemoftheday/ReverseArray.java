package gfg.problemoftheday;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        reverseArray(arr);
        System.out.println("Reverse Array: " + Arrays.toString(arr));

    }

    public static void reverseArray(int[] arr) {
        // code here
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
