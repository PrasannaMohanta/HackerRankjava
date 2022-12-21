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
    // Quicksort 1 - Partition
    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        partition(arr, 0, arr.size() - 1);
        return arr;
    }

    private static int partition(List<Integer> arr, int head, int tail) {
        int pivot = arr.get(0);
        int left = head;
        int right = tail;

        while (left < right) {
            while (arr.get(left) < pivot && left < right) {
                left++;
            }
            while (arr.get(right) > pivot && right > left) {
                right--;
            }
            swap(arr, left, right);
        }
        return left;
    }

    private static void swap(List<Integer> arr, int left, int right) {
        int current = arr.get(right);
        arr.set(right, arr.get(left));
        arr.set(left, current);

    }

}

public class Solution87 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.quickSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
