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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        List<Character> number = numbers.chars()
                        .mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> lower = lower_case.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        List<Character> upper = upper_case.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        List<Character> special = special_characters.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());
                
        List<Character> ans = password.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());
                
        List<Character> size4 = new ArrayList<>(4);
        for(int i=0;i<ans.size();i++){
            if(lower.contains(ans.get(i))){
                if(!size4.contains('l')){
                    size4.add('l');
                }
            }
            if(number.contains(ans.get(i))){
                if(!size4.contains('n')){
                    size4.add('n');
                }
            }
            if(upper.contains(ans.get(i))){
                if(!size4.contains('u')){
                    size4.add('u');
                }
            }
            if(special.contains(ans.get(i))){
                if(!size4.contains('s')){
                    size4.add('s');
                }
            }
        }if(ans.size()<6){
            if(size4.size() !=4){
                return Math.max(6-ans.size(), 4-size4.size());
                }
            else{
                    return 6-ans.size();
                }
        }if(size4.size() == 4){
            return 0;
        }else{
            return 4-size4.size();
        }
    }      
        
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
