package gfg.problemoftheday;

import java.math.BigInteger;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 7, 8};
        System.out.println("Result: " + maxSubarraySum(arr));

    }
    //This solution is logically correct. Here we are calculating sum of every sub-array and finding
    //maximum O(n*n) solution
    static int maxSubarraySum(int[] arr) {

        int n = arr.length;
        BigInteger maxSum  = BigInteger.valueOf(Integer.MIN_VALUE);

       for(int i=0;i<n;i++){
           BigInteger sum = BigInteger.valueOf(0);
           for(int j = i;j<n;j++){
               sum = sum.add(BigInteger.valueOf(arr[j]));
               if(sum.compareTo(maxSum)>0){
                   maxSum = sum;
               }
           }
       }
        return (maxSum.intValue());
    }
}
