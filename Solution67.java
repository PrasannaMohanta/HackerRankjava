import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Minimum Distances
    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        int minDistance = Integer.MAX_VALUE;
        int currentDistance = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                currentDistance = Math.abs(i - map.get(a.get(i)));
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            } else {
                map.put(a.get(i), i);
            }
        }
        if (minDistance == Integer.MAX_VALUE)
            return -1;
        else
            return minDistance;
    }

}

public class Solution67 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
