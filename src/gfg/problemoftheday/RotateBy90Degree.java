package gfg.problemoftheday;

import java.util.Arrays;

public class RotateBy90Degree {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original: " + Arrays.deepToString(mat));
        mat = rotate(mat);
        System.out.println("Result: " + Arrays.deepToString(mat));
    }

    static int[][] rotate(int[][] mat) {
        // Code Here
        int n = mat.length;
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            res[i] = new int[n];
        }
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                res[i][n - 1 - j] = mat[j][i];
            }
        }
        return res;
    }
}
