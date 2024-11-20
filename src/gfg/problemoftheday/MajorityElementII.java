package gfg.problemoftheday;

import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //3 2 1 1 2 3 4 1 4 4 4 1 3 1 2 1
        List<Integer> resultList = findMajority(arr);
        System.out.println("Result: " + resultList);
    }

    static public List<Integer> findMajority(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int majorityNumber = n / 3;
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > majorityNumber) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

}
