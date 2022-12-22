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
    // Separate the Numbers
    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        // Write your code here
        for (int n = 1; n < s.length() / 2 + 1; n++) {
            // get the substring with first n digits
            String substr = s.substring(0, n);
            // transfer to number
            BigInteger number = new BigInteger(substr);

            int idx = n;
            while (true) {
                // add one to number
                number = number.add(BigInteger.ONE);
                // if we check that (number + 1) is the next number
                if (s.indexOf(number.toString(), idx) == idx) {
                    // skip the index
                    idx += number.toString().length();
                } else {
                    break;
                }
                if (idx == s.length()) {
                    // finished traversing whole string
                    System.out.println("YES " + substr);
                    return;
                }
            }
        }
        System.out.println("NO");

    }

}

public class Solution95 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
