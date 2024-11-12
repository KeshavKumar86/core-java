package gfg.problemoftheday;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {92, 154},
                {93, 97},
                {47, 111},
                {59, 105},
                {23, 109}
        };
        System.out.println(canAttend(arr));
    }

    private static boolean canAttend(int[][] arr) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : arr) {
            if (map.containsKey(ints[0])) {
                return false;
            }
            map.put(ints[0], ints[1]);
        }
        Integer previousValue = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int key = entry.getKey();
            if (previousValue != null) {
                if (key > entry.getValue() || previousValue > key) {
                    return false;
                }
            }
            previousValue = entry.getValue();
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