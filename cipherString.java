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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        List<Character> ch = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        String regex = "[a-b]";
        for(int i=0; i< ch.size(); i++){
            if(Character.isLowerCase(ch.get(i))){
                int temp = (int) ch.get(i);
                temp +=k%26;
                if(temp <=122){
                    Character rev = (char) temp;
                    ch.set(i, rev);
                }else{
                    int temp2 = 97 + temp-122-1;
                    Character rev = (char) temp2;
                    ch.set(i, rev);
                }
            }
            if(Character.isUpperCase(ch.get(i))){
                int temp = (int) ch.get(i);
                temp +=k%26;
                if(temp <=90){
                    Character rev = (char) temp;
                    ch.set(i, rev);
                }else{
                    int temp2 = 65 + temp-90-1;
                    Character rev = (char) temp2;
                    ch.set(i, rev);
                }
            }
        }
        return ch.stream()
                       .map(String::valueOf) // Convert each character to a string
                       .collect(Collectors.joining());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
