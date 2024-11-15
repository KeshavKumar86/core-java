package java8.stream;

public class SecondLargest {
    // User function Template for Java
    public int getSecondLargest(int[] arr) {
        // Code Here
        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] == largest) {
                continue;
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
