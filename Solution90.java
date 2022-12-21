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
    // The Full Counting Sort
    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        // Write your code here
        for (int i = 0; i < arr.size() / 2; i++) {
            List<String> tempList = arr.get(i);
            tempList.set(1, "-");
            arr.set(i, tempList);
        }
        arr.sort(Comparator.comparingInt(s -> Integer.parseInt(s.get(0))));
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (List<String> element : arr) {
            stringJoiner.add(element.get(1));
        }
        System.out.println(stringJoiner);

    }

}

public class Solution90 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
