import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Repeated String
    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long freq = 0, count = 0, a = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'a')
                freq++;
        }
        long div = n / s.length();
        long rem = n % s.length();
        for (int i = 0; i < rem; i++) {
            if (s.charAt(i) == 'a')
                a++;
        }
        if (rem != 0)
            count = div * freq + a;
        else
            count = div * freq;
        return count;

    }

}

public class Solution59 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
