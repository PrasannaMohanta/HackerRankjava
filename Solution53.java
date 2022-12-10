import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Extra Long Factorials
    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger number = new BigInteger(Integer.toString(n));
        BigInteger result = recurFact(number);

        System.out.println(result);

    }

    private static BigInteger recurFact(BigInteger number) {

        if (number.equals(BigInteger.valueOf(1)) || number.equals(BigInteger.valueOf(0)))
            return BigInteger.valueOf(1);

        return number.multiply(recurFact(number.subtract(new BigInteger("1"))));

    }

}

public class Solution53 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
