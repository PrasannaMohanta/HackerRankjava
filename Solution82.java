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
    // Strong Password
    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        Set<String> set = new HashSet<>();
        Set<Character> special = new HashSet<>();
        "!@#$%^&*()-+".chars().forEach(c -> special.add((char) c));
        password.chars().forEach(c -> {
            if (Character.isUpperCase((char) c)) {
                set.add("UPPER");
            } else if (Character.isLowerCase((char) c)) {
                set.add("LOWER");
            } else if (Character.isDigit((char) c)) {
                set.add("DIGIT");
            } else if (special.contains((char) c)) {
                set.add("SPECIAL");
            }
        });
        int sizeGap = 6 - password.length();
        int strengthGap = 4 - set.size();
        if (sizeGap > strengthGap)
            return sizeGap;
        else
            return strengthGap;

    }

}

public class Solution82 {
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
