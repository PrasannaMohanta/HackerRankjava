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
    // Day of the Programmer
    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        // Write your code here
        int numDays = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        if (year >= 1700 && year <= 1917) {
            // julian
            if (year % 4 == 0)
                ++numDays;
        } else if (year == 1918) {
            // transition
            numDays -= 13;
        } else {
            // gregorian
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                ++numDays;
            }
        }
        StringBuilder builder = new StringBuilder();
        int date = 256 - numDays;
        if (date < 10)
            builder.append("0").append(date);
        else
            builder.append(date);
        builder.append(".").append("09").append(".").append(year);
        return builder.toString();
    }

}

public class Solution34 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
