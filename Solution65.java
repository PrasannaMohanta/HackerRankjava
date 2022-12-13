import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     * 1. INTEGER p
     * 2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        for (int i = p; i <= q; i++) {
            List<Integer> tempList = new ArrayList<Integer>();
            int square = i * i;
            int squareLength = (int) (Math.log10(square) + 1);
            if (squareLength <= 2) {
                while (square > 0) {
                    tempList.add(square % 10);
                    square = square / 10;
                }
            }
            String s = String.valueOf(square);
            if (s.length() > 2) {
                String s1 = s.substring(0, s.length() / 2);
                String s2 = s.substring(s.length() / 2, s.length());
                tempList.add(Integer.parseInt(s1));
                tempList.add(Integer.parseInt(s2));
            }
            int sum = 0;
            for (int j = 0; j < tempList.size(); j++) {
                sum = sum + tempList.get(j);
            }
            if (sum == i) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            System.out.println("INVALID RANGE");
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.print(list.get(k) + " ");
        }

    }

}

public class Solution65 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
