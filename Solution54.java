import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Append and Delete
    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. STRING t
     * 3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int n = s.length(), m = t.length();
        if (n + m <= k)
            return "Yes";
        int idx = 0;
        while (idx < Math.min(n, m) && s.charAt(idx) == t.charAt(idx)) {
            idx++;
        }
        int res = (n - idx) + (m - idx);
        if (res < k) {
            while (res < k) {
                res += 2;
            }
            if (res == k) {
                return "Yes";
            }
            return "No";
        } else if (res == k) {
            return "Yes";
        } else {
            return "No";
        }

    }

}

public class Solution54 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
