import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Circular Array Rotation

    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER k
     * 3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here
        int realRotations = k % a.size();
        List<Integer> response = new ArrayList<>();
        for (int i = 0; i < realRotations; i++) {
            int currentInt = a.get(a.size() - 1);
            a.remove(a.size() - 1);
            a.add(0, currentInt);
        }

        for (int j = 0; j < queries.size(); j++) {
            response.add(a.get(queries.get(j)));
        }

        return response;

    }

}

public class Solution49 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }

        List<Integer> result = Result.circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
