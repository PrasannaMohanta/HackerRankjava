import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Mini-Max Sum
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        long sumArr[] = new long[size];

        for (int i = 0; i < size; i++) {
            sumArr[i] = 0;
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    sumArr[i] += arr.get(j);
                }
            }
        }

        Arrays.sort(sumArr);

        System.out.print(sumArr[0] + " " + sumArr[size - 1]);
    }

}

public class Solution22 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
