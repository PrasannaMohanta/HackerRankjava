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
    // Manasa and Stones
    /*
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER a
     * 3. INTEGER b
     */

    public static List<Integer> stones(int n, int a, int b) {
        // Write your code here
        List<Integer> ciguli = new ArrayList<>();

        int bigNum = 0;
        int smallNum = 0;
        int diff = Math.abs(b - a);

        for (int i = 0; i < (n - 1); i++) {
            if (a < b) {
                smallNum += a;
                bigNum += b;
            } else {
                smallNum += b;
                bigNum += a;
            }
        }

        while (smallNum <= bigNum && a != b) {
            ciguli.add(smallNum);
            smallNum += diff;
        }

        if (a == b) {
            ciguli.add((n - 1) * a);
        }

        return ciguli;

    }

}

public class Solution74 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.stones(n, a, b);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
