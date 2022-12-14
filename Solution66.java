import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Beautiful Triplets
    /*
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER d
     * 2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        // Write your code here
        int a = 0;
        int var = 0, count = 0;
        for (int i = 0; i < arr.size() - 2; i++) {
            a = i;
            var = 1;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) - arr.get(a) == d) {
                    a = j;
                    var++;
                }
                if (var == 3) {
                    count++;
                    break;
                }
            }
        }
        return count;

    }

}

public class Solution66 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
