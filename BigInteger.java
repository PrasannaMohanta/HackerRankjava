import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigInteger {
    // java big integer

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BigInteger A = input.nextBigInteger();
        BigInteger B = input.nextBigInteger();

        System.out.println(A.add(B));
        System.out.println(A.multiply(B));

    }
}