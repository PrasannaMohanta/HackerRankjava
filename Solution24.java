import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Time Conversion
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String[] time = s.split(":");
        int hour = Integer.valueOf(time[0]);
        int min = Integer.valueOf(time[1]);
        int sec = Integer.valueOf(time[2].substring(0, 2));
        String ampm = time[2].substring(2, 4);

        if (ampm.equals("AM") && hour == 12)
            hour = 0;
        if (ampm.equals("PM") && hour < 12)
            hour = hour + 12;
        String res = String.format("%02d:%02d:%02d", hour, min, sec);

        return res;

    }

}

public class Solution24 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
