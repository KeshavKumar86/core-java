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
        int[] temp = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[j++] = arr[i];
        }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }
}
