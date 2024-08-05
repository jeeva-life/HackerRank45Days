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
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
       
        // Perform insertion sort
        for (int i = n - 1; i > 0; i--) {
            int temp = arr.get(i);
            int j = i - 1;
            int count = 0;

            // Move elements that are greater than temp to one position ahead
            while (j >= 0 && arr.get(j) > temp) {
                arr.set(j + 1, arr.get(j));
                printList(arr);
                j--;
                count++;
            }
            if(count ==0){
                return;
            }
            // Place temp in its correct position
            arr.set(j + 1, temp);

            // Print the list after each insertion
            printList(arr);
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
