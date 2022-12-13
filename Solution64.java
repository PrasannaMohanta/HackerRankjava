import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    // Encryption
    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        String str = s.replaceAll(" ", "");
        int strLen = str.length();
        if (strLen == 1) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        int count = 1;
        int row = 0;
        int col = 0;
        while (true) {
            int minSquare = count * count;
            int maxSquare = (count + 1) * (count + 1);
            if (minSquare < strLen && maxSquare >= strLen) {
                row = count;
                col = (count + 1);
                break;
            }
            count++;
        }
        if ((row * col) < strLen) {
            row++;
        }
        String[][] matrix = new String[row][col];
        int charAtIndex = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (charAtIndex < strLen) {
                    matrix[i][j] = (str.charAt(charAtIndex) + "");
                }
                charAtIndex++;
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] != null) {
                    result.append(matrix[j][i]);
                }
            }
            result.append(" ");
        }

        return result.toString();

    }

}

public class Solution64 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
