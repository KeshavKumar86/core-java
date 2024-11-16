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

        int nonZeroCount = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[nonZeroCount];
                arr[nonZeroCount] = temp;
                nonZeroCount++;
            }
        }
    }
}
