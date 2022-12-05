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
    // Between Two Sets
    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        if (Collections.min(a) > Collections.max(b)) {
            return 0;
        }
        int maxFactor = Collections.min(b);
        int minFactor = Collections.max(a);
        ArrayList<Integer> firstTest = new ArrayList<>();
        for (int i = minFactor; i <= maxFactor; i++) {
            for (int x : b) {
                if (x % i != 0) {
                    break;
                }
                firstTest.add(i);
            }
        }

        ArrayList<Integer> bFactors = new ArrayList<>();
        for (int i = minFactor; i <= Collections.max(firstTest); i++) {
            if (Collections.frequency(firstTest, i) == b.size()) {
                bFactors.add(i);
            }
        }
        ArrayList<Integer> secondTest = new ArrayList<>();
        for (int x : bFactors) {
            for (int y : a) {
                if (x % y != 0) {
                    break;
                }
                secondTest.add(x);
            }
        }

        ArrayList<Integer> finalList = new ArrayList<>();
        for (int i = minFactor; i <= Collections.max(secondTest); i++) {
            if (Collections.frequency(secondTest, i) == a.size()) {
                finalList.add(i);
            }
        }
        int result = finalList.size();
        return result;
    }

}

public class Solution29 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
