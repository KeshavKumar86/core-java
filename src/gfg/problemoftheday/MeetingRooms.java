package gfg.problemoftheday;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] arr = {
                {92, 154},
                {93, 97},
                {47, 111},
                {59, 105},
                {23, 109}
        };
        //System.out.println(canAttend(arr));
        System.out.println(canAttend2(arr));
    }

    private static boolean canAttend(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i][1] > arr[i + 1][0])
                return false;
        }
        return true;
    }

    private static boolean canAttend2(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int[] flatArr = Arrays.stream(arr).flatMapToInt((int[] array) ->
                Arrays.stream(array)).toArray();
        for (int i = 1; i + 1 < flatArr.length; i = i + 2) {
            if (flatArr[i] > flatArr[i + 1])
                return false;
        }
        return true;
    }
}
/*
Given an array arr[][] such that arr[i][0] is the starting time of ith meeting and arr[i][1] is the
ending time of ith meeting, the task is to check if it is possible for a person to attend all the
meetings such that he can attend only one meeting at a particular time.

Note: A person can attend a meeting if its starting time is greater than or equal to the previous
meeting's ending time.

Examples:

Input: arr[][] = [[1, 4], [10, 15], [7, 10]]
Output: true
Explanation: Since all the meetings are held at different times, it is possible to attend all the
meetings.
Input: arr[][] = [[2, 4], [9, 12], [6, 10]]
Output: false
Explanation: It is not possible to attend the second and third meetings simultaneously.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 2*106
 */