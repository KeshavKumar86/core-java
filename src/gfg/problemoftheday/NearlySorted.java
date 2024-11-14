package gfg.problemoftheday;

import java.util.PriorityQueue;

public class NearlySorted {
    public void nearlySorted(int[] arr, int k) {
        // code
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        k++;
        int iterator = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            }
            if (pq.size() == k) {
                arr[iterator++] = pq.remove();
            }
        }
        while (!pq.isEmpty()) {
            arr[iterator++] = pq.remove();
        }
    }
}
