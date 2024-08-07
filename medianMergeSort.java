import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
    // Write your code here
        int size = arr.size();
        buildHeap(arr, size);

        // Perform heap sort
        for (int i = size - 1; i > 0; i--) {
            // Swap the first element with the last unsorted element
            int temp = arr.get(i);
            arr.set(i, arr.get(0));
            arr.set(0, temp);

            // Reduce the heap size and heapify the root element
            heapify(arr, 0, i);
        }

        // Find the median
        int median;
        if (size % 2 == 1) {
            // Odd number of elements, middle element is the median
            median = arr.get(size / 2);
        } else {
            // Even number of elements, average the two middle elements
            int mid1 = arr.get((size / 2) - 1);
            int mid2 = arr.get(size / 2);
            median = (mid1 + mid2) / 2; // Simple average, works well for integers
        }

        return median;
    }

    static void buildHeap(List<Integer> arr, int size) {
        // Build the max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, i, size);
        }
    }

    static void heapify(List<Integer> arr, int index, int size) {
        int left = 2 * index + 1;
        int right = left + 1;

        int max = index;

        if (left < size && arr.get(left) > arr.get(max)) {
            max = left;
        }
        if (right < size && arr.get(right) > arr.get(max)) {
            max = right;
        }

        if (index != max) {
            // Swap elements
            int temp = arr.get(max);
            arr.set(max, arr.get(index));
            arr.set(index, temp);

            // Recursively heapify the affected subtree
            heapify(arr, max, size);
        }
    }
    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
