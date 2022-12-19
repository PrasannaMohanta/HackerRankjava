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
    // Two Characters
    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        // Write your code here
        int length = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            }
        }
        for (int m = 0, n = 1; n < list.size() && m < list.size() - 1; n++) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == list.get(m) || s.charAt(i) == list.get(n)) {
                    if (stack.isEmpty()) {
                        stack.push(s.charAt(i));
                    } else if (stack.peek() == s.charAt(i)) {
                        stack.removeAllElements();
                        break;
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
            }
            if (length < stack.size()) {
                length = stack.size();
            }

            if (n == list.size() - 1) {
                m++;
                n = m;
            }
        }
        return length;

    }

}

public class Solution83 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
