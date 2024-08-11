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
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
    // Write your code here
        List<Integer> ans = new ArrayList<>();
        
        // Check for the maximum subarray sum using Kadane's Algorithm
        int maxSoFar = arr.get(0); // Start with the first element
        int currentMax = arr.get(0); // Current subarray max
        
        for (int i = 1; i < arr.size(); i++) {
            currentMax = Math.max(arr.get(i), currentMax + arr.get(i));
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        
        ans.add(maxSoFar);
        
        // Check for the sum of all positive integers
        int positiveSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                positiveSum += arr.get(i);
            }
        }
        
        if (positiveSum == 0) {
            // If there are no positive numbers, add the maximum single element
            positiveSum = maxSoFar;
        }
        
        ans.add(positiveSum);
        
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
