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
    // Breaking the Records
    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        ArrayList<Integer> Hlist = new ArrayList<>();
        ArrayList<Integer> Llist = new ArrayList<>();
        int max = scores.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) > max) {
                max = scores.get(i);
                Hlist.add(max);
            } else if (scores.get(i) < min) {
                min = scores.get(i);
                Llist.add(min);
            }
        }
        Llist.remove(0);

        ArrayList<Integer> records = new ArrayList<>();
        records.add(Hlist.size());
        records.add(Llist.size());

        return records;
    }

}

public class Solution30 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
