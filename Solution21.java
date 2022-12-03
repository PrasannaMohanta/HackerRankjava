import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    //Staircase

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
    if (n == 0) {
        return;
      }
      
      for (int i = n; i > 0; i--) {
        int hashSize = n - i + 1;
        int spaceSize = n - hashSize;
        StringBuilder stringBuilder = new StringBuilder();
        if (spaceSize > 0) {
        
          char[] spaceChars = new char[spaceSize];
          Arrays.fill(spaceChars, ' ');
          stringBuilder.append(spaceChars);
        }
        
        
        char[] hashChars = new char[hashSize];
        Arrays.fill(hashChars, '#');
        stringBuilder.append(hashChars);
        System.out.println(stringBuilder.toString());
      }

    }

}

public class Solution21 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
