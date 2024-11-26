package gfg.problemoftheday;

public class MaxCircularSubarraySum {
    public static void main(String[] args) {

        int[] arr = {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println("Result: " + circularSubarraySum(arr));
    }
    private static int circularSubarraySum(int[] arr) {

        int currentMin = 0;
        int currentMax = 0;
        int globalMin = arr[0];
        int globalMax = arr[0];
        int totalSum = 0;
        for (int element : arr) {
            currentMin += element;
            currentMin = Math.min(currentMin, element);
            globalMin = Math.min(globalMin, currentMin);
            currentMax += element;
            currentMax = Math.max(currentMax, element);
            globalMax = Math.max(globalMax, currentMax);
            totalSum += element;
        }
        if (globalMax < 0) {
            return globalMax;
        }
        return Math.max(globalMax, totalSum - globalMin);
    }
}
/*
Case 1: Non-Circular Maximum Subarray
This is the straightforward Kadane's algorithm for finding the maximum subarray sum in a regular array.

Treat the array as a normal linear array (ignore circularity).
Find the maximum subarray sum using Kadane's algorithm.
For example:

In arr[] = [8, -8, 9, -9, 10, -11, 12], the non-circular maximum subarray is [12] with a sum of 12.
Case 2: Circular Maximum Subarray
To find the maximum sum when the subarray "wraps around" the array:

First, compute the total sum of the array.
Find the minimum subarray sum using a variation of Kadane's algorithm. This is because subtracting
the minimum subarray from the total sum gives the sum of the "complement" subarray, which effectively
wraps around.
For example, in the array arr[] = [8, -8, 9, -9, 10, -11, 12], the minimum subarray is [-11]
with a sum of -11.
Total sum = 8 + (-8) + 9 + (-9) + 10 + (-11) + 12 = 11.
The maximum sum for the circular subarray is:
Total sum - Minimum subarray sum = 11 - (-11) = 22.
Compare this circular sum with the result from Case 1.
Final Solution
Take the maximum of:

The non-circular subarray sum (from Case 1).
The circular subarray sum (from Case 2).
Edge Case
If all elements in the array are negative:

The circular subarray sum might incorrectly consider an empty array due to the subtraction step.
To handle this, if the non-circular subarray sum (Kadane's result) is the maximum element, return
that instead.
Intuition
Kadane’s algorithm finds the best "straight-line" subarray.
The circular case finds the best "wrap-around" subarray by removing the worst subarray
(minimum subarray).
This ensures we account for both possibilities in the circular array, giving the overall maximum.
 */
