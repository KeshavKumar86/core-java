package gfg.problemoftheday;

import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 1, 2, 3, 4, 1, 4, 4, 4, 1, 3, 1, 2, 1};
        //3 2 1 1 2 3 4 1 4 4 4 1 3 1 2 1
        List<Integer> resultList = findMajorityOptimal(arr);

        System.out.println("Result: " + resultList);
    }

    private static List<Integer> findMajorityOptimal(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : arr) {

            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if(count1>arr.length/3) list.add(candidate1);
        if(count2>arr.length/3) list.add(candidate2);
        Collections.sort(list);
        return list;
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
