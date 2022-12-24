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
    // Lily's Homework
    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
        // Write your code here
        List<Integer> copy = new ArrayList<>(arr);
        List<Integer> copy1 = new ArrayList<>(arr);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Collections.sort(copy);
        int count1 = 0, count2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), i);
        }
        for (int i = 0; i < copy.size(); i++) {
            if (arr.get(i) != copy.get(i)) {
                Integer tmp = arr.get(i);
                arr.set(i, arr.get(map.get(copy.get(i))));
                arr.set(map.get(copy.get(i)), tmp);
                map.put(tmp, map.get(copy.get(i)));
                count1++;
            }
        }
        Collections.sort(copy, Collections.reverseOrder());
        for (int i = 0; i < arr.size(); i++) {
            map2.put(copy1.get(i), i);
        }
        for (int i = 0; i < copy.size(); i++) {
            if (copy1.get(i) != copy.get(i)) {
                Integer tmp = copy1.get(i);
                copy1.set(i, copy1.get(map.get(copy.get(i))));
                copy1.set(map2.get(copy.get(i)), tmp);
                map2.put(tmp, map2.get(copy.get(i)));
                count2++;
            }
        }

        return Math.min(count1, count2);

    }

}

public class Solution101 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
