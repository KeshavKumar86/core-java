package gfg.problemoftheday;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println("Original Array: " + Arrays.toString(arr));
        int d = 3;
        rotateArrOptimal(arr, d);
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    /*
    This method is optimal solution to solve this problem. It is called reversal algorithm
     */
    private static void rotateArrOptimal(int[] arr, int d) {

        //reverse the array up to d places
        reverse(arr, 0, d - 1);
        //reverse the remaining array
        reverse(arr, d, arr.length - 1);
        //reverse the whole array
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int low, int high) {
        int temp;
        while (low < high) {
            //swap arr[low] and arr[high]
            temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
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
        System.arraycopy(temp, 0, arr, (n - d), d); //O(d) time
    }

}
