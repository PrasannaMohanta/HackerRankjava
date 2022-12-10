import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Sherlock and Squares
    /*
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER a
     * 2. INTEGER b
     */

    public static int squares(int a, int b) {
        // Write your code here
        int res = 0;
        for (int i = (int) Math.sqrt(b); i >= Math.sqrt(a); i--) {
            if (i * i >= a && i * i <= b) {
                res++;
            }
        }
        return res;

    }

}

public class Solution55 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int a = Integer.parseInt(firstMultipleInput[0]);

            int b = Integer.parseInt(firstMultipleInput[1]);

            int result = Result.squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
