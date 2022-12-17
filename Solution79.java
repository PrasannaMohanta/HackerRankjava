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
    // Insertion Sort - Part 1
    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int last = arr.get(arr.size() - 1);
        boolean sorted = false;
        int i = arr.size() - 2;
        while (!sorted) {
            if (arr.get(i) > last) {
                arr.set(i + 1, arr.get(i));
            } else {
                arr.set(i + 1, last);
                sorted = true;
            }
            arr.stream().forEach(x -> System.out.printf("%d ", x));
            System.out.println();
            if (i == 0 && !sorted) {
                arr.set(0, last);
                arr.stream().forEach(x -> System.out.printf("%d ", x));
                sorted = true;
            }
            --i;
        }

    }

}

public class Solution79 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
