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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> temp_arr = new ArrayList<>(arr);
        MergeSort(temp_arr, 0, temp_arr.size() - 1);
        List<Integer> new_arr = new ArrayList<>();
        
        int start = 0;
        int end = temp_arr.size() - 1;
        
        for (int i = 0; i < brr.size(); i++) {
            if (temp_arr.size() > 0) {
                int status = findVal(temp_arr, brr.get(i), start, end);
                if (status >= 0) {
                    temp_arr.remove(status);
                    end--;  // Reduce the end boundary after removal
                } else {
                    if(!new_arr.contains(brr.get(i))){
                        new_arr.add(brr.get(i));
                    }
                }
            } else {
                for (int j = i; j < brr.size(); j++) {
                    new_arr.add(brr.get(j));
                }
                break;  // Exit the loop early as all remaining elements are missing
            }
        }
        Collections.sort(new_arr);
        return new_arr;
    }
    
    static int findVal(List<Integer> arr, int val, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (val == arr.get(mid)) {
                return mid;
            }
            if (arr.get(mid) < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    static void MergeSort(List<Integer> arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid + 1, end);
            Merge(arr, start, mid, end);
        }
    }
    
    static void Merge(List<Integer> arr, int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();
        
        int i = start;
        int j = mid + 1;
        
        while (i <= mid && j <= end) {
            if (arr.get(i) < arr.get(j)) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;
            }
        }
        
        while (i <= mid) {
            temp.add(arr.get(i));
            i++;
        }
        
        while (j <= end) {
            temp.add(arr.get(j));
            j++;
        }
        
        // Now copy elements to the original array
        for (int k = 0; k < temp.size(); k++) {
            arr.set(start + k, temp.get(k));
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> temp_arr = new ArrayList<>(arr);
        MergeSort(temp_arr, 0, temp_arr.size() - 1);
        List<Integer> new_arr = new ArrayList<>();
        
        int start = 0;
        int end = temp_arr.size() - 1;
        
        for (int i = 0; i < brr.size(); i++) {
            if (temp_arr.size() > 0) {
                int status = findVal(temp_arr, brr.get(i), start, end);
                if (status >= 0) {
                    temp_arr.remove(status);
                    end--;  // Reduce the end boundary after removal
                } else {
                    if(!new_arr.contains(brr.get(i))){
                        new_arr.add(brr.get(i));
                    }
                }
            } else {
                for (int j = i; j < brr.size(); j++) {
                    new_arr.add(brr.get(j));
                }
                break;  // Exit the loop early as all remaining elements are missing
            }
        }
        Collections.sort(new_arr);
        return new_arr;
    }
    
    static int findVal(List<Integer> arr, int val, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (val == arr.get(mid)) {
                return mid;
            }
            if (arr.get(mid) < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    static void MergeSort(List<Integer> arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid + 1, end);
            Merge(arr, start, mid, end);
        }
    }
    
    static void Merge(List<Integer> arr, int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();
        
        int i = start;
        int j = mid + 1;
        
        while (i <= mid && j <= end) {
            if (arr.get(i) < arr.get(j)) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;
            }
        }
        
        while (i <= mid) {
            temp.add(arr.get(i));
            i++;
        }
        
        while (j <= end) {
            temp.add(arr.get(j));
            j++;
        }
        
        // Now copy elements to the original array
        for (int k = 0; k < temp.size(); k++) {
            arr.set(start + k, temp.get(k));
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

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
