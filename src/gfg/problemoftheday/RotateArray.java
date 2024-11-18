package gfg.problemoftheday;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println("Original Array: " + Arrays.toString(arr));
        int d = 3;
        rotateArr(arr, d);
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    static void rotateArr(int[] arr, int d) {

        for (int j = 0; j < d; j++) {
            int temp = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = temp;
        }
    }
}
