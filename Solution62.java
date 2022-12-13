import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // ACM ICPC Team
    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < topic.size(); i++) {
            List<Integer> l = new ArrayList<>();

            for (int k = 0; k < topic.get(i).length(); k++) {
                if (topic.get(i).charAt(k) == '1') {
                    l.add(k + 1);
                }

            }
            map.put(i + 1, l);

        }
        int max = 0, no = 0;
        for (int i = 1; i <= topic.size(); i++) {
            for (int j = i + 1; j <= topic.size(); j++) {
                Set<Integer> s = new HashSet<>();
                s.addAll(map.get(i));
                s.addAll(map.get(j));
                if (s.size() == max) {
                    no++;
                } else if (s.size() > max) {
                    no = 1;
                    max = s.size();
                }

            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(max);
        res.add(no);
        return res;

    }

}

public class Solution62 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String topicItem = bufferedReader.readLine();
            topic.add(topicItem);
        }

        List<Integer> result = Result.acmTeam(topic);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
