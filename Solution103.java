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
    // Grid Challenge
    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for (int i = 0; i < grid.size(); i++) {
            char[] arr = grid.get(i).toCharArray();
            Arrays.sort(arr);
            String s = String.copyValueOf(arr);
            grid.set(i, s);
        }
        String flag = "YES";
        char[] arr1 = grid.get(0).toCharArray();

        for (int i = 1; i < grid.size(); i++) {
            char[] arr2 = grid.get(i).toCharArray();

            for (int j = 0; j < arr1.length; j++) {
                if (Character.compare(arr1[j], arr2[j]) > 0) {
                    flag = "NO";
                }
            }
            arr1 = arr2;
        }
        return flag;
    }

}

public class Solution103 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
