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
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
         int maxRange = 100;  // Define the range of input values
         List<Integer> freq = new ArrayList<>(Collections.nCopies(maxRange, 0));//initializing with zeros
         for(int i=0;i<arr.size();i++){
            int pos = arr.get(i);
            freq.set(pos, freq.get(pos)+1);
        }
        List<Integer> sorted = new ArrayList<>(Collections.nCopies(arr.size(), 0));//initial zeros
        int j=0;
        int count =0;
        for(j=0;j<100;j++){
            int temp = j;
            while(freq.get(temp)>0){
                sorted.set(count,temp);
                count++;
                freq.set(temp, freq.get(temp)-1);
            }
        }
        return sorted;

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

        List<Integer> result = Result.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
