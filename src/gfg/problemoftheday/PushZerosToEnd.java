package gfg.problemoftheday;

import java.util.Arrays;

public class PushZerosToEnd {
    public static void main(String[] args) {

        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        pushZerosToEnd(arr);
        System.out.println("Resulted Array: " + Arrays.toString(arr));
    }

    static void pushZerosToEnd(int[] arr) {

        int[] resArray = new int[arr.length];
        int count = 0;
        for (int j : arr) {
            if (j != 0) {
                resArray[count++] = j;
            }
        }
        while (count < arr.length) {
            resArray[count++] = 0;
        }
        System.arraycopy(resArray, 0, arr, 0, resArray.length);
    }
}
