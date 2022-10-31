import java.util.Scanner;

public class Anagram {
    // anagram
    static boolean isAnagram(String a, String b) {

        // Complete the function
        a = a.replace(" ", "").toLowerCase();
        b = b.replace(" ", "").toLowerCase();
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        java.util.Arrays.sort(c);
        java.util.Arrays.sort(d);
        String s1 = new String(c);
        String s2 = new String(d);
        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}