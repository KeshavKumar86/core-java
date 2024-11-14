package gfg.problemoftheday;

import java.util.ArrayList;
import java.util.TreeSet;

public class Union {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 6, 7};

        System.out.println(findUnion(a, b));
    }
// User function Template for Java
    // a,b : the arrays
    // Function to return a list containing the union of the two arrays.

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // add your code here
        int i = 0, j = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                arrayList.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                arrayList.add(a[i]);
                i++;
            } else {
                arrayList.add(b[j]);
                j++;
            }
        }
        while (i < a.length) {
            arrayList.add(a[i]);
            i++;
        }
        while (j < b.length) {
            arrayList.add(b[j]);
            j++;
        }
        return arrayList;
    }

    public static ArrayList<Integer> findUnion2(int[] a, int[] b) {
        // add your code here
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int element : a) {
            treeSet.add(element);
        }
        for (int element : b) {
            treeSet.add(element);
        }
        return new ArrayList<>(treeSet);
    }
}
