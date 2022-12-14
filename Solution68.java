import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Halloween Sale
    /*
     * Complete the 'howManyGames' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER p
     * 2. INTEGER d
     * 3. INTEGER m
     * 4. INTEGER s
     */

    public static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int i = 0, n = 0, c = p;
        while (s > 0) {
            c = p - (i * d);
            if (c <= m) {
                c = m;
            }
            s -= c;
            if (s >= 0) {
                n++;
            }
            i++;
        }
        return n;

    }

}

public class Solution68 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        int m = Integer.parseInt(firstMultipleInput[2]);

        int s = Integer.parseInt(firstMultipleInput[3]);

        int answer = Result.howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
