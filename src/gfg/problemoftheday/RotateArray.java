package gfg.problemoftheday;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        int d = 2;
        rotateArrImprove(arr, d);
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

    static void rotateArrImprove(int[] arr, int d) {

        int[] temp = new int[d];
        System.arraycopy(arr, 0, temp, 0, d); //O(d) time
        int i = 0;
        int n = arr.length;
        while ((i + d) < n) { //O(n-d) time
            arr[i] = arr[i + d];
            i++;
        }
        System.arraycopy(temp,0,arr,(n-d),d); //O(d) time
    }
}
